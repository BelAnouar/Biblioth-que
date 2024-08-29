# Bibliothèque Municipale - Système de Gestion Informatique

## Description du projet

Ce projet consiste en une application console développée en Java 8 pour automatiser et gérer efficacement l'inventaire des livres et magazines, ainsi que les emprunts et retours au sein d'une bibliothèque municipale. L'application est structurée en plusieurs couches, suivant une architecture MVC, pour séparer les responsabilités et faciliter la maintenance du code.

## Fonctionnalités

- **Ajouter un document** : Permet d'ajouter un livre ou un magazine à l'inventaire de la bibliothèque.
- **Emprunter un document** : Gère l'emprunt d'un document par un utilisateur.
- **Retourner un document** : Gère le retour d'un document emprunté.
- **Afficher tous les documents** : Liste tous les documents présents dans la bibliothèque.
- **Rechercher un document** : Recherche rapide d'un document par son titre ou autre critère.

## Structure de l'application

L'application est organisée en trois couches principales :

1. **Couche de présentation** :
    - **`ConsoleUI`** : Gère l'interface utilisateur en console. Elle présente un menu interactif permettant d'accéder aux différentes fonctionnalités de l'application.

2. **Couche métier** :
    - **`Document`** (classe abstraite) : Classe de base représentant un document. Les classes `Livre` et `Magazine` en héritent.
    - **`Livre`** : Représente un livre avec un attribut supplémentaire `isbn`.
    - **`Magazine`** : Représente un magazine avec un attribut supplémentaire `numero`.
    - **`Bibliotheque`** : Gère la collection de documents et les opérations associées (ajout, emprunt, retour, etc.).

3. **Couche utilitaire** :
    - **`DateUtils`** : Fournit des méthodes utilitaires pour la manipulation des dates.

## Contenu des classes principales

### Classe abstraite `Document`
- **Attributs** : `id`, `titre`, `auteur`, `datePublication`, `nombreDePages`
- **Méthodes abstraites** :
    - `emprunter()`
    - `retourner()`
    - `afficherDetails()`

### Classe `Livre`
- **Attribut supplémentaire** : `isbn`
- **Implémente les méthodes abstraites** de `Document`.

### Classe `Magazine`
- **Attribut supplémentaire** : `numero`
- **Implémente les méthodes abstraites** de `Document`.

## Spécifications techniques

- **Stockage des documents** : Utilisation d'`ArrayList<Document>` pour stocker les documents.
- **Recherche rapide** : Implémentation avec `HashMap<String, Document>` pour une recherche efficace.
- **Gestion des dates** : Intégration de la Java Time API.
- **Programmation fonctionnelle** : Utilisation d'expressions lambda et des Stream API (en bonus).

## Interface utilisateur

L'application présente un menu interactif avec les options suivantes :

```plaintext
1. Ajouter un document
2. Emprunter un document
3. Retourner un document
4. Afficher tous les documents
5. Rechercher un document
6. Quitter

Veuillez entrer votre choix (1-6) :
