# Introduction à Kubernetes

Objectif : Déployer et faire communiquer 2 microservices entre eux

## Setup

Minikube : installation minimaliste de Kubernetes pour tests en local
https://kubernetes.io/docs/tasks/tools/install-minikube/

Exemple sous mac :
```brew cask install minikube```
```brew install virtualbox```

## Getting started

Déployer un premier Service :
https://kubernetes.io/docs/getting-started-guides/minikube/

## Déployer un microservice placé dans un backend

Step1: Avoir quelque chose à déployer...
```
# Recupérer le microservice http REST (Jersey) préparé
git co studies/backend__microservice
cd backends/protectplus/proxy
# Builder son image docker
docker build -t protectplus:v1 .
# Vérifier qu'il fonctionne
docker run -p 8080:8080 protectplus
curl http://localhost:8080/backends/protectplus/tarification
# Nétoyer
docker ps
docker kill sha1
# Pour l'avoir dans l'intellij depuis le monorepo : aller dans Maven Projects, "+" puis fournir le pom.xml
```

Step2: Le déployer sur minikube (le kubernetes light local)

c'est un remix de https://kubernetes.io/docs/tutorials/stateless-application/hello-minikube/#create-a-minikube-cluster

```
# Lancer minikube
minikube start
# idk, https://kubernetes.io/docs/getting-started-guides/minikube/#reusing-the-docker-daemon
eval $(minikube docker-env)
# Undo with eval $(minikube docker-env -u)
# Deployer notre docker image sur minikube
kubectl run protectplus --image=protectplus:v1 --port=8080
# Regarder qu'on l'a bien déployé
kubectl get deployments
kubectl get pods
# Ou en visuel
minikube dashboard
# Exposer notre service
kubectl expose deployment protectplus --type=LoadBalancer
# Regarder
kubectl get services
# ???
minikube service protectplus
# Vérifier que notre service répond sur l IP fournie
curl http://192.168.99.100:32353/backends/protectplus/tarification
# Regarder les logs
kubectl get logs
kubectl logs protectplus-804590595-z4592
```

