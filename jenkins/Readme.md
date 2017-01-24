# Jenkins pipelines by LF

## Pré-requis
* Docker 2.3.6 minimum
* Pour développer, IntelliJ ou au minimum groovyConsole
* Un accès au moins en read-only à github
* Un token pour slack (OK chez LF)

## Introduction to groovy
http://groovy-lang.org/

IntelliJ has a groovy console: Actions... / Groovy Console

### GString vs. String

    String s = 'aaa'
    GString gs = "aaa${s.length()}
    println gs // displays aaa3
    
    """This is a multiline String
    this is very useful
    because you can include JSON:
    {
      "node": "value"
    }"""

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
    myFunction 5                            // 8
    

## Jenkins pipelines
Jenkins docker image: https://hub.docker.com/_/jenkins/

    docker pull jenkins:alpine
    mkdir -p $HOME/dev/jenkins/docker-home/
    docker run -p 8080:8080 -p 50000:50000 -v $HOME/dev/jenkins/docker-home/:/var/jenkins_home jenkins:alpine

### Exemple de Pipeline Jenkins
    stage('etape 1'){
        parallel(
            firstBranch: {
                node(){
                    println 'toto'
                    sh 'sleep 3'
                }
            },
            secondBranch: {
                node(){
                    println 'toto'
                    sh 'sleep 3'
                }
            }
        )
    }
        
        
    stage('etape 2') {
        node() {
            println 'toto'
        }
    }

# TODO
Expliquer le NonCPS/CompileStatic/Jenkins Security

## Les pipelines Jenkins chez LF
### Objectif
* Un job pour lister toutes branches d'un repo qui n'ont pas été modifiées depuis plus de N jours.
* Des tests de non-régression.
* Extra : notifier par slack chaque auteur de la branche si celle-ci a plus d'un mois d'ancienneté.

### Let's play in a docker
    # Dossier dans lequel tous le workspace jenkins sera placé
    mkdir $HOME/dev/jenkins/docker-home2
    # Déploie l'image docker de jenkins dans un container docker
    docker run -p 8080:8080 -p 50000:50000 -v $HOME/dev/jenkins/docker-home2/:/var/jenkins_home equ/jenkins-plugins:devel

[Jenkins est déployé sur le port 8080](http://localhost:8080)

### Structure des jobs chez LF
    TODO avec le deploy
    
### GitHub Configuration
https://github.com/settings/tokens
https://wiki.jenkins-ci.org/display/JENKINS/Github+Plugin

### Trucs et astuces
#### Obtenir l'âge d'une branche
[stackoverflow - How can I get a list of git branches, ordered by most recent commit?](http://stackoverflow.com/questions/5188320/how-can-i-get-a-list-of-git-branches-ordered-by-most-recent-commit)

[Git SCM - For each ref et ses field names](https://git-scm.com/docs/git-for-each-ref/2.5.1)


    # Afficher le nombre de jours depuis Epoch
    date "+%s"
    # Affiche le nombre de jours d'une branche depuis Epoch
    git for-each-ref --sort=committerdate refs/heads/ --format='%(color:yellow)%(refname:short)%(color:reset) %(authorname) (%(color:green)%(committerdate:raw)%(color:reset)) (%(color:green)%(authordate:raw)%(color:reset))



