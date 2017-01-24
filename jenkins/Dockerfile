FROM jenkins:alpine

# plugins par défaut
RUN /usr/local/bin/install-plugins.sh ant build-timeout email-ext gradle workflow-aggregator ssh-slaves timestamper ws-cleanup
# plugins additionnels
RUN /usr/local/bin/install-plugins.sh pipeline-utility-steps
RUN /usr/local/bin/install-plugins.sh pipeline-model-definition # pour prendre une dépendance en amont (soucis de téléchargement)
RUN /usr/local/bin/install-plugins.sh blueocean
RUN /usr/local/bin/install-plugins.sh gitlab-plugin
RUN /usr/local/bin/install-plugins.sh extra-columns flyway-runner workflow-aggregator momentjs slack internetmeme

# docker build -f Dockerfile .
# docker tag equ/jenkins-plugins:devel
# docker run -p 8080:8080 -p 50000:50000 -v $HOME/dev/jenkins/docker-home/:/var/jenkins_home equ/jenkins-plugins:devel
# credentials.xml contient la clé gitlab
# github-plugin-configuration.xml contient la conf git
#
# Lists all plugins Pour lister tous les plugins installés (à lancer depuis le dossier plugins du jenkins home :
# find . -name 'MANIFEST.MF' -exec grep -H 'Plugin-Version' {} \; | cut -d '/' -f2,4 | sed 'sX/MANIFEST.MF:Plugin-Version: X:Xg'
# docker images # docker rmi # docker pull
# docker ps # docker rm # docker start
