
# TP1 RMI : Cabinet Vétérinaire

[![MIT License](https://img.shields.io/github/license/Gaiko19/HAI704I-RMI)](https://img.shields.io/github/license/Gaiko19/HAI704I-RMI/)
[![release](https://img.shields.io/github/v/release/Gaiko19/HAI704I-RMI)](https://github.com/Gaiko19/HAI704I-RMI/releases/tag/v1.0)

Ce projet implémente le TP1 de l'UE HAI704I de l'Université de Montpellier. 
Il s'agit de mettre en place un cabinet de vétérinaire virtuel contenant des animaux et des clients (des vétérinaires du cabinet).
Les clients se connectent au serveur via des fonctions utilisant la technologie RMI leur permettant de récupérer les informations contenues dans le serveur.

## Contenu

Ce projet contient : 
- Trois paquets : un client, un serveur et un paquet common contenant les classes communes au deux projets.
- Un Makefile afin de compiler et lancer les différents projets
- Un fichier policy pour sécuriser l'accès au serveur
- Ce README

## Pré-requis

Le projet est fait pour ne fonctionner que sur Linux, les `CLASSPATH` utilisés peuvent ne pas fonctionner sous Windows.

Vous avez également besoin d'avoir `JAVA` d'installé sur votre machine.

## Utilisation

1. Commencer par installer le projet en récupérant le [`ZIP`](https://github.com/Gaiko19/HAI704I-RMI/releases/tag/v2.0) du projet et en en extrayant son contenues.

2. Compiler les trois paquets en faisant la commande `make` dans votre terminal (ouvert dans le dossier extrait).

3. Lancer le serveur avec `make run-server`.

4. Lancer votre (ou vos) client(s) avec `make run-client`.

5. Vous pouvez lancer le client en version graphique avec `make run-gui`.

6. Suivez les instructions ou options proposées par le client.

7. Une fois terminé vous pouvez nettoyer les fichiers avec `make clean`.
    
## Authors

Ce projet a été fait par :

- [Said Adam](https://github.com/gaiko19)
- [Cossu Arnaud](https://github.com/ArnaudCs)

En M1 Génie Logiciel à l'Université de Montpellier



