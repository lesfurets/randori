FROM jenkins:alpine
# https://hub.docker.com/_/jenkins/
# Même doc plus à jour : https://github.com/jenkinsci/docker/blob/master/README.md

# nécessaire pour lancer gradle
USER root
RUN apk add --no-cache "libstdc++"
USER jenkins

# Installation des plugins
# plugins suggérés par défaut
RUN /usr/local/bin/install-plugins.sh ant build-timeout email-ext gradle workflow-aggregator ssh-slaves timestamper ws-cleanup
# plugins additionnels : pipelines et blue ocean
RUN /usr/local/bin/install-plugins.sh pipeline-utility-steps pipeline-model-definition blueocean
# Plugins additionnels : de l'extra !
RUN /usr/local/bin/install-plugins.sh gitlab-plugin extra-columns flyway-runner workflow-aggregator momentjs slack internetmeme
# Pour lancer les tests gradle
RUN /usr/local/bin/install-plugins.sh gradle

# Pour ne pas avoir le wizard au démarrage
# https://groups.google.com/forum/#!topic/jenkinsci-users/Pb4QZVc2-f0
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion

# Copie des fichiers comme valeur par défaut pour l'initialisation du workspace:
#   scriptApproval.xml                  Autorisation des commandes de base
#   hudson.plugins.gradle.Gradle.xml    Config du plugin Gradle
COPY *.xml /usr/share/jenkins/ref/


# Construction de l'image, depuis jenkins-doker :
# docker build -t repository.admin.courtanet.net:10443/jenkins-randori -f Dockerfile .

# Push dans le repository
# docker push repository.admin.courtanet.net:10443/jenkins-randori

# Déploiement de l'image docker
# docker run -p 8080:8080 -v $HOME/dev/jenkins-home/:/var/jenkins_home repository.admin.courtanet.net:10443/jenkins-randori

