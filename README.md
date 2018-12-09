# DevOpsInnlevering

Hensikten med dette prosjektet er å lage en automatisert pipeline.<br/>
Applikasjonen er ikke viktig.

Denne applikasjonen kjørte på google cloud og aws, men er nå tatt ned.

### Beskrivelse av appen:
Kildekoden består av 3 moduler:
-   ansible
-   documentation-viewer
-   springserver

Jenkins-serveren min kjører på en virtuell 64-bits ubuntu-maskin på Amazon Web Services. <br/>
Kubernetes-clusteret og applikasjonen kjører på google cloud. <br/>
Hele hensikten med å kjøre byggserveren på AWS og selve appen på Google Cloud er å bevise at det er mulig. <br/>
Det hadde vært enklere/sikrere(via internt nett) å kjøre alt på samme cloud-plattform. <br/>

## For å bygge prosjektet som containere

I roten av prosjektet

$ docker-compose build

## Bygge individuelt

#### I springserver-modulen:

$ mvn clean install

#### I documentation-viewer-modulen:

$ npm install

$ npm run start

## Beskrivelse av pipelinen

#### 1. localhost
Her kan man kjøre bash/ansible-script for å sette opp github-repo og initialisere git lokalt. <br/>
Man kan også kjøre ansible-playbook via ssh til en remote VM for å installere de mest grunnleggende programmene for å kjøre dette prosjektet. <br/>
Man må da endre hosts:-feltet i main.yml og legge inn den hosten i /etc/ansible/hosts-fila. (hvis ansible er installert på ubuntu).<br/>


#### 2. github
Arkiverer koden.

#### 3. jenkinsserver
Jenkinsserveren har webhooks til dette repoet og sjekker om det er kommet nye commits til koden hvert 5-minutt.<br/>
Jenkinsserveren kjører stegene i jenkinsfilen. <br/>
Blant annet å kjøre testene i koden, bygge docker-containere og deployere appen til google cloud. <br/> 
Appen blir også skalert. <br/>

Det første steget(ansible-playbook main.yml) er helt unødvendig å kjøre som steg på en byggserver. <br/>
Dette skulle egentlig ha blitt kjørt som en kommando(ansible-playbook) på en egen maskin for å automatisere serveroppsett. <br/>




#### 4. google cloud
Kjører kubernetes-cluster med endepunkt: 35.198.181.185 <br/>

Det er en spring server som kjører på port 80. 

Endepunkt:

 /hostname 	angir docker-container-id’en som springserveren kjører I. \
 
 /health            angir hvordan serveren har det.
 
 
 /info		Gir litt info om appen. Den er stygt formattert I json.


