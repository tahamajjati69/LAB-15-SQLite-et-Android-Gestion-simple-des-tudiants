## 📘 TP Android – Gestion des Étudiants (SQLite & RecyclerView)

## 🎯 Objectif
Ce TP permet de maîtriser :
- L’architecture logicielle sous Android (Packages, Services, Util)
- La persistance des données avec SQLite
- L'affichage dynamique de listes avec un RecyclerView et un Adapter
- La gestion complète des données (CRUD) : Ajouter, Lire, Modifier, Supprimer

---

## 📁 Structure du projet
~~~~
app/
├── java/
│   └── ma.fst.projet.app_1/
│       ├── MainActivity.java
│       ├── EtudiantAdapter.java
│       ├── classes/
│       │   └── Etudiant.java
│       ├── service/
│       │   └── EtudiantService.java
│       └── util/
│           └── MySQLiteHelper.java
│
└── res/
    └── layout/
        ├── activity_main.xml
        └── item_etudiant.xml
~~~~
---

## ⚙️ Installation et lancement
1. Ouvrir le projet dans Android Studio
2. Laisser Gradle charger les dépendances
3. Lancer l’application sur un émulateur ou un téléphone

---

## ▶️ Exécution et Fonctionnalités

### 🔹 Étape 1 : Ajouter un étudiant
- Saisir le nom et le prénom
- Cliquer sur **Ajouter**
- L'étudiant apparaît immédiatement dans la liste en bas

### 🔹 Étape 2 : Rechercher un étudiant
- Saisir l’ID dans le champ correspondant
- Cliquer sur **Chercher**
- Les informations s’affichent dans les champs de saisie

### 🔹 Étape 3 : Modifier un étudiant
- Cliquer sur le bouton **Modifier cette ligne** dans la liste
- Modifier les informations dans les champs en haut
- Cliquer sur le bouton orange **Modifier** pour valider

### 🔹 Étape 4 : Supprimer un étudiant
- Saisir l’ID de l'étudiant
- Cliquer sur **Supprimer**
- La liste se met à jour automatiquement

---

## 🧩 Composants Principaux

### 🔹 Etudiant (Modèle)
Classe représentant un étudiant avec les attributs : id, nom, et prenom.

### 🔹 EtudiantAdapter (Interface Liste)
Gère l'affichage de chaque ligne dans le RecyclerView en utilisant le layout item_etudiant.xml. Il permet également de renvoyer les données vers le formulaire principal lors d'un clic.

### 🔹 MySQLiteHelper & EtudiantService
Assurent la création de la base de données et l'exécution des requêtes SQL pour la persistance des données.

---

## 🎥 Démonstration
https://github.com/user-attachments/assets/d8c5340a-e992-4925-803a-dbabf1e77ee3
