# TestStatistique
Implémentation du test de Kruskal Wallis puis le test de Friedman en java durant le cours de Statistique non parametrique

### Test de Kruskal Wallis :
Domaine d'utilisations : Le test peut être effectuer sur K echantillons **INDEPENDANT**


Objectif du test de Kruskall Wallis : comparer K échantillons et de determiner si un des k est plus efficace que l'autres.

Nous utiliseront les échantillons donner en cours à savoir : 
- Groupe 1 : 66 ,68 ,80 ,72 ,74 ,57 ,75
- Groupe 2 : 77 ,68 ,67 ,85 ,89 ,74 ,61
- Groupe 3 : 79 ,83 ,78 ,92 ,98 ,69 ,91

On va commencer par les trier dans l'ordre et determiner leurs rangs. Une fois ranger, on determine la somme des rangs pour chaque échantillons. 
Nous avons au final :
- Rangs Groupe 1 : 53
- Rangs Groupe 2 : 68
- Rangs Groupe 3 : 110

Enfin, nous allons trouver la valeur discriminantes en utilisant la formule suivante :

| 12 / N(N+1) x Somme(Ri^2/ni) - 3(N+1) |
|:-------------------------------------:|

Pour conclure on recherche le tAlpha de notre cas dans la table du Khi 2 et on la compare avec notre valeur discriminante.

- Si h < tAlpha : On accepte H0
- Si h > tAlpha : On rejete H0

### Test de Friedman :
Domaine d'utilisations : Le test peut être effectuer sur K echantillons **DEPENDANT**


Objectif du test de Kruskall Wallis : comparer K échantillons et de determiner si un des k est plus efficace que l'autres.

Nous utiliseront les échantillons donner en cours à savoir :

| Objet   | Commercant 1  | Commercant 2 | Commercant 3 |
|:--------|:-------------:|:------------:|:------------:|
| Stylo   |       4       |      5       |     4,5      |
| Trousse |       9       |      12      |      11      | 
| Fraise  |       6       |     6,2      |     7,4      |
| Beurre  |      2,5      |     2,9      |     3,20     | 
| Mangue  |     13,50     |      15      |    15,30     |

L'objectif est donc de trouver si les marchands sont équivalents

On va commencer par les assigner des rangs aux observations.
Nous avons au final :

| Objet   | Commercant 1 | Commercant 2 | Commercant 3 |
|:--------|:------------:|:------------:|:------------:|
| Stylo   |      1       |      3       |      2       |
| Trousse |      1       |      3       |      2       |
| Fraise  |      1       |      2       |      3       |
| Beurre  |      1       |      2       |      3       |
| Mangue  |      1       |      2       |      3       |
| Rang    |    Ri = 5    |   Ri = 12    |   Ri = 13    |

Enfin, nous allons trouver la valeur discriminantes en utilisant la formule suivante :

| 12 / nk(k+1) x Somme(Rj - (n(k+1)/2)^2 ) |
|:----------------------------------------:|

Pour conclure on recherche le tAlpha de notre cas dans la table du Khi 2 et on la compare avec notre valeur discriminante.

- Si h < tAlpha : On accepte H0
- Si h > tAlpha : On rejete H0
