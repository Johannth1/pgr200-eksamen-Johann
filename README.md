# Mappeinnlevering eksamen 
## Gruppe 16 - Johann og Line 


Av        Line Nathalie Rønning Og   Johan Th. Næss 

FeideID   Ronlin17                   Nesjoh17

----------------

###Kjøreinstruksjoner
Kjør main metoden i klassen conference, det skal starte opp et HttpEchoServer-objekt og kjøre dennes main-metode, 
samt koble HttpServeren opp mot postgres-databasen vår via DBConnection.createDataSource().
Samtidig opprettes Tracks og TracksDao som populerer DBen vår med data(selv om disse dataene ikke kommer fra klienten, dessverre).


----------------
###Line Coverage (Link) 

https://ibb.co/hrJn8L

https://ibb.co/fpcfTL



---------------

###Selvevaluering 

Vi har jobbet mye på skolen, vi fant fort ut at det var best å bruke én datamaskin. Så det ble egentlig bare par programmering hele veien. Der vi brukte én datamaskin til å slå opp for å løse problemer vi hadde underveis, og den andre maskinen til å skrive koden på. 
Dette fungerte veldig bra, da det er lettere med to personer. Det var litt uvant i starten da vi ikke er vant med at noen sitter og ser på når vi sitter å programmerer, men det gikk fort over. 
Vi opplevde at det ble mye bedre på denne måten vi gjorde det, siden det var lettere å oppdage feil i koden når én kodet og én så på. Slik kunne vi lettere få fikset småfeil(og store feil..) med en gang uten å gå tilbake senere uten å ha noen anelse om hva som var galt. 
Det var også mye mer effektivt til tider i og med at vi hadde "dobbelt opp" med kunnskap, så hvis den ene sto fast om hva vi skulle gjøre videre kunne den andre foreslå hva den andre skulle skrive. Eller hvordan vi skulle løse problemet vi hadde kommet oss inn i. 
Vi har jobbet litt hjemme, men for det meste har vi trivdes med å sitte sammen på skolen og kode. Vi har brukt Slack til å kommunisere oss i mellom og for å sende filer/kode til hverandre. 
Vi har flere prosjekter i andre fag samtidig, så da har vi prøvd å møtes de dagene vi har kunnet, der vi ikke var opptatt med de andre gruppene i de fagene vi hadde. 



Vi mener at vi fortjener karakteren A basert på innsatsen vi har lagt inn i dette prosjektet. 
Dette begrunner vi med at innsatsen vi har lagd inn i dette prosjekter har vært upåklagelig. 
Vi har møttes ofte på skolen. Her har vi lagt ned mye arbeid for å få til et godt resultat. 
Samtidig har vi brukt mye tid på å sitte hjemme å arbeide på prosjektet. 

 
Innholdsmessig vil nok prosjektet sto til en svak C (forhåpentligvis(selv om det mest sannsynligvis blir D)); 
Vi har mange av punktene vi trenger for fullføre innleveringen, vi har blant annet en server som kobler seg opp mot Postgres ved hjelp av 
«innlevering.properties» som ligger i «Resources» mappen i «Database-Core» men vi har ikke fått til gjøre om input fra klienter til å legge det i en 
«outputstream» for å se sende den via «Server» til «Databasen», og så gjøre det om til en «SQL Spørring» vi har god testdekning og en flere UML datamodeller som ligger i «image» mappen.  



    `String grade = "B"
    public String getBetterGrade(String grade){
        if(grade != "C"){
            grade = "C";
        } else {
            grade = "A"
        }
        System.out.println(grade);
        return grade;
    }`



----------------
###Video

I denne videoen parprogrammerer vi. Det ble bare tid til én test, siden vi brukte over en time på å få den til å bli grønn. :hankey: 
Videoen skulle jo egentlig bare vart i 3-8 minutter, men siden videoen ble på over en time, måtte vi ta i bruk av noen kreative løsninger for å korte ned på filmen. 
Så da ble videoen klippet, og hastigheten på filmen ble også økt, men ikke for mye så man ikke fikk med seg hva som skjedde. :construction_worker: 
Vil oppfordre til å stoppe videoen og se på problemene vi støter på underveis. Så du kan enkelt følge med på hvordan vi løste problemene og fikk koden til å kjøre grønt til slutt. :bug:  

Link

https://youtu.be/fuXUXFP1mjU

----------------

###Kommentarer til selve koden

Flertallsnavn på klasser: Vi er klar over at det er foretrukket praksis å skulle lage klasser med entallsnavn heller enn flertallsnavn, men det var noe vi hadde glemt da vi startet prosjektet.
Så hvis vi ikke har rettet opp i navngivningen innen mappen blir levert inn, er det rett og slett fordi vi heller har måttet prioritere annen funksjonalitet i koden.

Det er fremdeles en del som gjenstår for å få programmet til å kjøre sql-spørringer fra klient via server til databasen. 

----------------
### Vedlegg
Vår evaluering av en annen gruppe, ligger som vedlegg ``TilbakemeldingGittG33.md``.
Evaluering fra en annen gruppe ligger som vedlegg ``TilbakemeldingFaatt.md``.
Dokumentasjon Datamodell(UML) ligger som vedlegg i mappen ``images``.


----------------
