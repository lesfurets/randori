Randori LesFurets
===

Anagrames
---

Le sujet: Implémenter un détecteur d'anagrames

### Première séance

#### Présents
- Arnaud P.
- Mehdi B.
- Hugo V.
- Andrei A.
- Jonathan F.

#### Animateurs
- Bastien L.
- Mathieu B.

#### Conditions
1h le Vendredi 2 Octobre 2015, de 16h05 à 17h05, avec 50min de code et 10min de debrief. Laptop MBP avec clavier azerty + clavier PC azerty et layouts fr.FR et en.US.

#### Remarques
- Nous n'avons pas commencé par le test d'intégration, mais directement au niveau unitaire
- Nous avons peut être manqué d'analyse au départ, il aurait été intéressant de mieux préciser ce qu'on souhaitait obtenir
- Tout le monde trouve dommage de "tricker" le test avec du code qui passe vert sans remplir la fonction. Néanmoins, tous l'ont fait.

#### Notes de séance
- Le style "LesFurets" pour la gestion des inputs invalides est plutôt de retourner un défaut "sain", plutôt que de lancer une exception. Cependant, la plupart des participants préféreraient cette dernière solution.
- Le style "LesFurets" pour le nommage des méthodes tend à utiliser le français pour le domaine et l'anglais pour le reste. Nous avons instinctivement utilisé l'anglais de façon assez homogène (a l'exception des mots 'exemples')
- Nous avons choisi de travailler par interruption de flot, à savoir renvoyer le défaut dès qu'une exception est gérée, plutôt que préparer le retour et n'avoir qu'un seul point de sortie.
- Il y avait une forte volonté de passer rapidement sur les tests "peu intéressants" (par exemple tester les cas d'entrées invalides) en les groupant et en groupant la solution. Les animateurs ont tenu bon et maintenu l'ordre d'un test par tour. Les participants reprochent la lenteur du procédé pour peu de valeur. Nous devrons expliquer ce point.
- Beaucoup de temps passé à chercher les racourcis clavier sur un clavier différent. On se rend compte de l'importance de ces racourcis et de l'habitude de chacun de ne pas utiliser la souris.

#### Idées
- Travailler du code de production difficile en randori pour éprouver la méthode dans notre environnement
- Travailler des tests temporels (exemple: partir d'un test `timebombed`)
- Travailler un sujet moins algorithmique mais avec plus de design
- Travailler un sujet autour des raccourcis claviers pour apprendre les trucs et astuces les uns des autres (probablement avec une population "homogène" du point de vue layout de clavier / OS)
