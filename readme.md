# TP1 AQL
## Auteur : Nicolas Potel

### Lancement des tests

Les tests sont lancés en faisant la commande : `mvn clean install test`.

### Q2.1

| Classe d'équivalence | Fonction | Valeur | Signification |
|---|---|---|---|
| CE1 | restart | / | Création d'un nouveau board |
| CE2 | mark | is_valid(row, col) == false | Position invalide |
| CE3 | mark | isWinningMoveByPlayer(currentTurn, row, col) == true | Mouvement de fin de partie |
| CE4 | mark | isWinningMoveByPlayer(currentTurn, row, col) == false | Ajout d'une nouvelle position sans terminer la partie -> changement de joueur actif |
| CE5 | isValid | state == GameState.FINISHED | La partie est déjà terminée |
| CE6 | isValid | isOutOfBounds(row) | La row spécifiée est en dehors du plateau |
| CE7| isValid | isOutOfBounds(col) | La col spécifiée est en dehors du plateau |
| CE8 | isValid | isCellValueAlreadySet(row, col) | La case n'est pas vide |
| CE9 | isValid | true | La position spécifiée est valide |
| CE10 | isWinningMoveByPlayer | cells[currentRow][0].getValue() == cells[currentRow][1].getValue() == cells[currentRow][2].getValue() == player | Le joueur a gagné en remplissant une ligne |
| CE11 | isWinningMoveByPlayer | cells[0][currentCol].getValue() == cells[1][currentCol].getValue() == cells[2][currentCol].getValue() == player | Le joueur a gagné en remplissant une colonne |
| CE12 | isWinningMoveByPlayer | cells[0][0].getValue() == cells[1][1].getValue() == cells[2][2].getValue() == player | Le joueur a rempli la diagonale \ |
| CE13 | isWinningMoveByPlayer | cells[0][2].getValue() == cells[1][1].getValue() == cells[2][0].getValue() == player | Le joueur a rempli la diagonale / |
| CE14 | / | / | Aucun gagnant (partie nulle) | 

### Q3.1
Dans les tests, nous considérons que la case 0/0 se situe en bas à gauche de la grille.
