# Dictionnaire de données Aerosoft

## UTILISATEUR

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| idUtilisateur | Identifiant de l'utilisateur | Int | Clé primaire |
| Mail | E-mail de l'utilisateur | Char |   |
| motDePasse | Mot de passe de l'utilisateur | Char |   |
| Statut | Statut de l'utlisateur | Bool |   |
| idRole | Identifiant de rôle | Int | Clé étrangère |

## ROLE

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| idRole | Identifiant du rôle | Int | Clé primaire |
| roleNom | Intitulé du rôle | Char | |

## VOL

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| NumVol | Identifiant vol | Char | Clé primaire |
| AeroportDept | Code de l'aéroport de départ | Char |   |
| Hdepart | Heure de départ | Time |   |
| AeroportArr | Code de l'aéroport d'arrivée | Char |   |
| Harrivée | Heure d'arrivée | Time |   |
| idAeroport | Identifiant de l'aéroport | Char | Clé étrangère |

## AEROPORT

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| IdAeroport | Identifiant de l'aéroport | Char | Clé primaire |
| NomAeroport | Nom de l'aéroport | Char |   |
| NomVilleDesservie | Nom de la ville desservie | Char |   |

## AFFECTATION

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| IdAffectation | Identifiant de l'affectation | Char | Clé primaire |
| DateVol | Date du vol | Date |   |
| AffectationCode | Statut de l'affectation | Boolean |  |
| NumAvion | Identifiant de l'avion | Char | Clé étrangère |
| NumVol | Identifiant du vol | Char | Clé étrangère |
| IdPilote | Identifiant du pilote | Int | Clé étrangère |

## PILOTE

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| IdPilote | Identifiant du pilote | Char | Clé primaire |
| NomPilote | Nom du pilote | Char |   |
| PrenomPilote | Prenom du pilote | Char |  |

## AVION

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| NumAvion | Identifiant de l'avion | Char | Clé primaire |
| IdAeroport | Identifiant de l'aéroport | Char | Clé étrangère |
| TypeAvion | Code du type de l'avion | Char | Clé étrangère |

## CONSTRUCTEUR

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| Idconstructeur | Identifiant du constructeur | Int | Clé primaire |
| NomConstructeur | Nom du constructeur | Char |  |

## DETAILAVION

| Nom | Description | Type | Commentaire |
|---|---|---|---|---|
| TypeAvion | Identifiant du type de l'avion | Char | Clé primaire |
| Capacite | Capacité de l'avion | Int |  |
| IdConstructeur | Identifiant du constructeur | Int | Clé étrangère |
