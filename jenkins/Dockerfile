FROM jenkins:alpine
# https://hub.docker.com/_/jenkins/
# Même doc plus à jour : https://github.com/jenkinsci/docker/blob/master/README.md

# plugins suggérés par défaut
RUN /usr/local/bin/install-plugins.sh ant build-timeout email-ext gradle workflow-aggregator ssh-slaves timestamper ws-cleanup
# plugins additionnels : pipelines et blue ocean
RUN /usr/local/bin/install-plugins.sh pipeline-utility-steps pipeline-model-definition blueocean
# Plugins additionnels : de l'extra !
RUN /usr/local/bin/install-plugins.sh gitlab-plugin extra-columns flyway-runner workflow-aggregator momentjs slack internetmeme

# Pour ne pas avoir le wizard au démarrage
# https://groups.google.com/forum/#!topic/jenkinsci-users/Pb4QZVc2-f0
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion

# docker build -t equ/jenkins-plugins:devel -f Dockerfile .
# docker run -p 8080:8080 -v $HOME/dev/jenkins/docker-home/:/var/jenkins_home equ/jenkins-plugins:devel
# L'option  -p 50000:50000 est inutile tant que tous les agents sont dans le master
# credentials.xml contient la clé gitlab
# github-plugin-configuration.xml contient la conf git
#
# Lists all plugins Pour lister tous les plugins installés (à lancer depuis le dossier plugins du jenkins home :
# find . -name 'MANIFEST.MF' -exec grep -H 'Plugin-Version' {} \; | cut -d '/' -f2,4 | sed 'sX/MANIFEST.MF:Plugin-Version: X:Xg'
# docker images # docker rmi # docker pull
# docker ps # docker rm # docker start
