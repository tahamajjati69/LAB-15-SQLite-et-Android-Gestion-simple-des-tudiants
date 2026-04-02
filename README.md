
## 📘 TP Android – Gestion des Étudiants (SQLite)

## 🎯 Objectif
Ce TP permet de comprendre :
- La création d’une application Android  
- L’utilisation de SQLite  
- La gestion des données (CRUD)  
- L’interaction avec l’interface utilisateur  

---

## 📁 Structure du projet
~~~
app/
├── java/
│   └── ma.fst.projet.app_1/
│       ├── MainActivity.java
│       ├── classes/
│       │   └── Etudiant.java
│       ├── service/
│       │   └── EtudiantService.java
│       └── util/
│           └── MySQLiteHelper.java
│
└── res/
    └── layout/
        └── activity_main.xml
~~~
---

## ⚙️ Installation et lancement
1. Ouvrir le projet dans Android Studio  
2. Laisser Gradle charger les dépendances  
3. Lancer l’application sur un émulateur ou un téléphone  

---

## ▶️ Exécution

### 🔹 Étape 1 : Lancer l’application
- Cliquer sur **Run ▶️** dans Android Studio  
- Choisir un émulateur ou un téléphone connecté  

---

### 🔹 Étape 2 : Ajouter un étudiant
- Saisir le **nom** et le **prénom**  
- Cliquer sur **Ajouter**  
- Message de confirmation affiché  

---

### 🔹 Étape 3 : Rechercher un étudiant
- Saisir l’**ID**  
- Cliquer sur **Chercher**  
- Les informations s’affichent  

---

### 🔹 Étape 4 : Supprimer un étudiant
- Saisir l’**ID**  
- Cliquer sur **Supprimer**  
- L’étudiant est supprimé de la base  

---

### 🔹 Étape 5 : Vérification
- Les données restent sauvegardées même après fermeture de l’application  
- Utilisation de SQLite pour la persistance  

---
## Exemple de sorte :

https://github.com/user-attachments/assets/1321250c-d615-409b-ab3b-95b76c78f4cf



## 🧩 Composants

### 🔹 Etudiant (Modèle)
Classe représentant un étudiant :
- id  
- nom  
- prenom  

---

### 🔹 MySQLiteHelper (Base de données)
Permet :
- La création de la base `etudiants.db`  
- La création de la table `etudiant`  

