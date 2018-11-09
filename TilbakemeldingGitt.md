# Tilbakemelding gitt
## Gruppe som er blitt evaluert: 33
### Gruppe som har utført evaluering: 16

Hva var bra? 
Ryddig mappestruktur. Det var lurt f.eks. å underdele http-delen i en server- og klient-del.
Dessuten ser det fint ut at dere har skilt DAO, entiteter og interface i core-delen.
Det ser ut som at dere har omfattende tester av de forskjellige modulene deres, noe som er bra.
Pom-filer var opprettet til alle modulene og slike ting som <dependencies> og <plugins> ser relevante ut i forhold til modulene.
Klassene ser for oss ut til å ha relevante navn.


Hva kan vi lære? 
Noe vi kan ta lærdom av av å se på deres kode, er f.eks. deres ryddighet når det kommer til mappestrukturen.
Dere har i tillegg lagt inn en commandline-modul som vi ikke har tenkt på, så det kunne være relevant for oss å legge til dette i vårt prosjekt.

Hva funket dårlig/mindre bra? 
På den pcen vi fikk se koden på, ville ikke testene kjøre, heller ingen av main-klassene. 
Det ble spekulert i om dette kunne skyldes at "Eclipse" oppførte seg vrang, da vi synes at selve koden så bra ut.
Server og jdbc del er ikke koblet sammen.

Konklusjon
Alt i alt et ryddig program, med logisk navngivning og fin mappestruktur.
Når alt er satt sammen og fungerer i harmoni tror vi dette kommer til å funke fint.