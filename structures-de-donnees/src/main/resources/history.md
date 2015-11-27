Randori LesFurets
===

Structures de données
---

Le sujet: Utiliser les structures de données du jdk

#### Présents
Alexandre D.
Denis R.
Mathieu G.
Benjamin D.
Jordhan L.

#### Animateurs
Mathieu B.

#### Conditions
55min le vendredi 27 novembre 2015 de 16h05 à 17h00 avec 5min de debrief, et débats pendant la session

#### Remarques
Pas trop de problèmes de clavier. Le layout commence à rentrer, et les raccourcis à devenir naturels

#### Notes de séance

Débats sur:
    - Petit retour du débat "return null"/"fail hard". On reste sur "fail hard", consensus.
    - Faut-il un NullPointerException ou une IllegalArgumentException? Consensus faible sur IllegalArgumentException au motif qu'il exprime un problème avec l'argument, alors que NullPointerException est clairement un accident en déréférencant une variable null.
    - Faut-il implémenter equals/hashCode pour gérer un cas commun de déduplication, ou au contraire avoir un equals/hashCode toujours valide (une vraie condition d'égalité) et utiliser des Maps pour dédupliquer? A priori, plutôt gérer le cas général, mais on peut difficilement le forcer en TDD
    - Faut-il employer java.lang.Objects.checkArgument et consors, ou des if()? Le sujet n'est pas clos: Ces méthodes sont plus concises, réduisent certaines métriques de complexité, mais sont plus difficiles à lires pour des novices. A voir.
    - Faut-il implémenter Comparable pour gérer l'ordre, ou déclarer des constantes Comparator qui indiquent les différents ordres possibles? Ou bien encore, employer des lambdas dans les méthodes requérant un Comparator? Ca dépend des circonstances: S'il existe un ordre naturel, pourquoi pas Comparable. Sinon, constantes et/ou lambdas. Les lambdas s'ils n'ont pas besoin de champs privés sont parfaits.

Découverte par certains de "Objects.hashCode" et "Objects.equals", très appréciée
Re-découverte du générateur de equals/hashCode de IntelliJ, dont l'implèm est correcte mais pas idéale

#### Idées
Explorer Lombok, pour voir ce qu'il apporte sur equals/hashCode, mais aussi ses défauts comme les plantages de surlignage des erreurs de comppilation dans IDEA.
Ajouter une déduplication par email en plus de celle "par tous les champs"
Tenter un point bonus sur les subsets d'un SortedSet
