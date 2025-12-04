# 04-Chat-Client

Ce repository est la suite du repository [04-Chat-Server](https://github.com/remabd/04-Chat-Server), il s'occupe de la partie client.
Au lancement du programme, l'utilisateur doit rentrer le port et l'adresse du serveur sur lequel il veut se connecter.
À la connexion , l'utilisateur peut choisir son nom et sa room parmis une existante ou en créer une.
Pour se déconnecter, l'utilisateur doit taper `exit`.

## Build And Run

After cloning:
```
cd 04-Chat-Client
mvn compile
mvn exec:java -Dexec.mainClass="com.client.app.App" -Dexec.args="address port"
```
