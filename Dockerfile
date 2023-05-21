# Utilisez une image de base appropriée qui inclut Python et Flask
FROM python:3.9

# Définissez le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copiez les fichiers de votre application dans le conteneur
COPY . /app

# Installez les dépendances de votre application
RUN pip install --no-cache-dir -r requirements.txt

# Définissez les variables d'environnement Flask
ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0

# Exposez le port 5000 pour accéder à votre application
EXPOSE 5000

# Démarrez votre application avec Flask
CMD ["flask", "run"]