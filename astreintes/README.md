# Astreintes

Chaque mois on propose aux employés volontaires de postuler pour obtenir une semaine d'astreinte sur le mois suivant.
Les employés votent sur les semaines du mois à venir, et l'affectation se fait à la fin du mois.
Chaque employé peut postuler sur autant de semaines qu'il veut selon sa disponibilité.
A la fin du vote, @tdb affecte les astreintes en essayant d'être le plus juste possible.

## Critères d'acceptance

CandidateFinder a pour but d'affecter les astreintes du mois suivant aux candidats:
* Le candidat qui n'a jamais fait d'astreinte est prioritaire (cf Open questions)
* Le candidat a qui on a affecté l'astreinte la plus ancienne est prioritaire

Given: A1 a eu l'astreinte la plus, A2 la précédente et ainsi de suite, A3, A4,...
Exemple1:
1   A8, A7, A4
2   A3, A2,
3   A1
4   A6
 Quelle est l'affectation attendue?


USE CASES:

GIVEN personne n'a voté
WHEN je fais tourner l'algo
THEN throw une exception

GIVEN un candidat @aar postule seul sur toutes les semaines de ce mois
WHEN je fais tourner l'algo
THEN j'affecte @aar sur toutes les semaines

GIVEN @sco et @sdi postulent sur la même semaine
et SCO a fait la semaine N-1 et SDI a fait la semaine N-2
WHEN je fais tourner l'algo
THEN j'affecte la semaine à @sdi

Un candidat n'as pas le droit de faire plus de 2 semaines consécutives d'astreintes

Open questions :
* Choisir entre deux candidats qui n'on jamais fait d'astreinte
