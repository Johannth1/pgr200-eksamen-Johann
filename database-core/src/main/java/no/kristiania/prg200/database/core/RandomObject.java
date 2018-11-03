package no.kristiania.prg200.database.core;

import java.util.Random;

/**
 * TODO: Flytte Random-metoder over i denne klassen og få metodene til å funke de stedene metodene blir brukt.
 */

public class RandomObject {

    Random random = new Random();

    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private Long pickOneLong(Long[] longs) {
        return longs[random.nextInt(longs.length)];
    }

    public Long randomLong(){
        return pickOneLong(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
    }

    public String randomDays(){
        return pickOne(new String[] {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag"});
    }

    public String randomDates() {
        return pickOne ( new String[] {"01.10", "07.10", "22.10", "01.11", "03.11"});
    }

    public String randomRooms(){
        return pickOne(new String[]{"Svane-salen", "Heisrommet", "Drømmerommet", "Vandresalen", "Klasserommet", "Festsalen", "Konferansesalen", "Grupperom 1", "Rosérommet"});
    }

    public String randomTitle() {
        return pickOne ( new String[] {"Dinosaurer i ", "Datamaskiner i ", "Matematikk for ", "", "Velkommen til "});
    }

    public String randomDescription() {
        return pickOne(new String[] {"nåtiden", "gårsdagen", "fremtiden", "barnehagen", "verden"});
    }

    public String randomTopic() {
        return pickOne(new String[] {"En samtale om data.", "Informasjon om tid og rom.", "Mange steder på en gang."});
    }

    public String randomTime(){
        return pickOne ( new String[] {"08.00-09.00", "11.00-14.15", "10.00-13.00", "", "16.30-18.00"});
    }

    public String randomTracks(){
        return pickOne ( new String[]{"Forelesning 1", "Forelesning 2", "Samtale", "Track 20"} );
    }
}
