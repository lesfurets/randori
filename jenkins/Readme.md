# Jenkins pipelines by LF

Dans ce randori seront abordés :
* une introduction à groovy
* la prise en main des pipelines Jenkins
* l'utilisation qui en est faite chez lesfurets
* les tests de non régression sur les pipelines

## Pré-requis
* Docker 1.13.0 minimum
* Pour développer, IntelliJ ou au minimum groovyConsole
* Un accès au moins en read-only à github
* Un token pour slack (OK chez LF)
* Gradle (optionnel, seulement pour lancer des tests en local) [Guide d'installation](https://docs.gradle.org/current/userguide/installation.html#sec:prerequisites)


    # Sur MacOs
    brew install gradle
    # Sur ubuntu-likes
    apt-get install gradle

## Introduction to groovy
http://groovy-lang.org/

Une console groovy est disponible dans IntelliJ : `Actions` / `Groovy Console...`

### GString vs. String

    String s = 'aaa'
    GString gs = "aaa${s.length()}
    println gs // displays aaa3
    
    """This is a multiline GString
    It can be useful to write a long text
    even with string substitution like ${aaa}"""
    
    '''This is multiline String
    No string substitution done here.'''

### Map and lists
Easy way to define a map:

    Map m = [ 
        firstKey: [
            otherKey: "value"
        ],
        otherKey: [
            entry: "value",
            entry2: "value2"
        ]
    ]

And a list:

    List l = [1, 2, 3, 4, 5]
    l = 1..32 // much easier
    println l

### Safe navigation operator
    println m?.someKey?.otherKey            // null
    println m?.otherKey?.entry2             // value2
    
### Closure - the lambda ancester
    (1..5).each{ println it }               // 1 2 3 4 5
    Closure c = { int i, int j ->
        println i+j
    }
    c(4, 5)                                 // 9
### Implicit return
    def myFunction(int j) {
        int i = 3
        i + j
    }
    println myFunction 5                            // 8
    
### def is evil

## Quelques points d'attention
Jenkins permet de faire l'essentiel des fonctions groovy, et ajoute quelques fonctions, comme :
* ```node``` pour exécuter du code dans un agent Jenkins
* ```stage``` pour créer une sorte d'étape visuelle dans le pipeline
* ```parallel``` pour paralléliser des tâches
* ```sh``` pour exécuter une commande sh
* ```checkout``` pour faire un clone d'un scm
La liste est longue et peut être complétée par les différents plugins qu'on ajoute à Jenkins

### Groovy Sandboxing

    If some script authors are “regular users” with only more limited permissions,
    such as Job/Configure, it is inappropriate to let them run arbitrary scripts

Objectif : empêcher les utilisateurs d'exécuter des commandes critiques depuis leurs scripts.

Lorsqu'on appelle des fonctions/méthodes encore non autorisées, Jenkins force une erreur sur les jobs
qui essaient de les exécuter et ajoute les dites fonctions à une liste d'attente des fonctions à 
valider. Un administrateur peut les valider.

La page de validation est ici :
http://localhost:8080/scriptApproval/

[Documentation complète](https://wiki.jenkins-ci.org/display/JENKINS/Script+Security+Plugin)

### @NonCPS
Jenkins a l'habitude à chaque instruction d'enregistrer toutes les variables locales dans un fichier.
Cela lui permet en cas de panne, de relancer les agents là où ils s'étaient arrêtés.

Or certains objets ne sont pas sérialisables. Si vous affectez un objet non sérialisable à une
variable, une erreur surviendra. Pour contourner cette difficulté :
 * soit vous n'enregistrez pas ces objets dans une variable
 * soit vous rendez la méthode `@NonCPS`
 
Une méthode ayant l'annotation `@NonCPS` :
* sera exécutée d'une traîte, sans enregistrer les états intermédiaires
* ne pourra pas lancer de commandes Jenkins telles que `sh`, `git`, `input`, `stage`, `node`...

## Les pipelines Jenkins chez LF
### Objectif
* Un job pour lister toutes branches d'un repo qui n'ont pas été modifiées depuis plus de N jours.
* Des tests de non-régression.
* Extra : notifier par slack chaque auteur de la branche si celle-ci a plus d'un mois d'ancienneté.


## Jenkins pipelines
Pour ce randori, on pourra utiliser une image docker Jenkins.
Une version maison a été poussée sur nexus, elle contient la 
version officielle complétée d'une petite série de plugins.

### Let's play in a docker
* Cloner le projet randori si ce n'est pas déjà fait : 
`git clone "https://github.com/lesfurets/randori.git"`
* Créer une branche qui part du master : `git checkout -b "$USER" origin/master`
* Remplacer `jenkins-session-1` par le nom de la branche créée à l'étape précédente dans :
    * dans `jenkins/jenkins-docker/jobs/gradleTest/config.xml`
    * dans `jenkins/jenkins-docker/jobs/pipelineRandori/config.xml`
* Depuis le dossier jenkins, initialiser le workspace du futur docker (par défaut $HOME/dev/jenkins-home ):


    mkdir -p $HOME/dev/jenkins-home/jobs/
    # création des jobs :
    cp -r jenkins-docker/jobs $HOME/dev/jenkins-home/


* Récupérer l'image docker : 


    # Déploie l'image docker de jenkins-LF dans un container docker
    docker run -p 8080:8080 -v $HOME/dev/jenkins-home/:/var/jenkins_home repository.admin.courtanet.net:10443/jenkins-randori

[Jenkins est déployé sur le port 8080](http://localhost:8080)

* Jenkins a déjà 2 jobs :
    * pipelineRandori sur lequel on va travailler
    * gradleTest qui vérifie qu'il n'y a pas de régression sur le job pipelineRandori

### Trucs et astuces
#### Obtenir l'âge d'une branche
[stackoverflow - How can I get a list of git branches, ordered by most recent commit?](http://stackoverflow.com/questions/5188320/how-can-i-get-a-list-of-git-branches-ordered-by-most-recent-commit)

[Git SCM - For each ref et ses field names](https://git-scm.com/docs/git-for-each-ref/2.5.1)


    # Afficher le nombre de jours depuis Epoch
    date "+%s"
    # Affiche le nombre de jours d'une branche depuis Epoch
    git for-each-ref --sort=committerdate refs/heads/ --format='%(color:yellow)%(refname:short)%(color:reset) %(authorname) (%(color:green)%(committerdate:raw)%(color:reset)) (%(color:green)%(authordate:raw)%(color:reset))



