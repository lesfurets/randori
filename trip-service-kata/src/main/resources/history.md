Randori LesFurets
===

Trip service kata
---

Le sujet: Refactoring d'un service legacy

#### Présents
dra
sdi
adu
bde

#### Animateurs
ble
mbo

#### Conditions
1h30 Le Vendredi 30 Octobre de 15h30 à 17h, avec 20min de debrief

#### Remarques


#### Notes de séance
Gros débat au départ: Faut-il passer par un extract method ou introduce field. Conclusions:
- introduce field s'approche plus d'un refactoring qui permet de passer a de l'injection
- MAIS:
   1. Il y a un risque de changer le comportement, selon la manière d'introduir le champ (on risque de passer de n appels à 1 appel)
   2. On viole clairement la règle "uniquement des refactorings automatiques" si on introduis correctement le field (a savoir avec un supplier)
   3. Extraire une méthode et l'écraser pour mocker permet de résoudre le problème directement, garnir les tests, et refactorer plus tard
Décus de n'avoir pas poussé le code jusqu'a un modèle avec de l'injection et de l'extraction de services

#### Idées
Imposer franchement la règle "tous les refactorings doivent être automatiques" : Ca impose de passer par des mocks avec surchage en limitant l'accès aux refactorings du type "injection de factory"
Passer a 1h30 spécifiquement pour ce kata: On a besoin de temps pour bien gérer tous les tests avant de passer a l'injection, et l'injection est quelque chose qu'on souhaite pratiquer dans ce kata également
