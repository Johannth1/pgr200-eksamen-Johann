package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Random;

/**
 * I denne klassen kobler vi sammen klassene Days + DaysDao, Talks + TalksDao, Rooms + RoomsDao og Timeslots + TimeslotsDao.
 *
 * TODO: Ordne opp i denne klassen så man tar i bruk de andre klassene.
 */

public class Tracks extends AbstractDao {
    Long id;
    ArrayList<Days> daysArrayList;
    ArrayList<Rooms> roomsArrayList;
    ArrayList<Talks> talksArrayList;
    ArrayList<Timeslots> timeslotsArrayList;

    Random random = new Random();


    public Tracks(DataSource dataSource){
        super(dataSource);
        daysArrayList = new ArrayList<>();
        roomsArrayList = new ArrayList<>();
        talksArrayList = new ArrayList<>();
        timeslotsArrayList = new ArrayList<>();
    }

    public boolean createStandardTracks(){
        createStandardDays();
        createStandardRooms();
        createStandardTalks();
        createStandardTimeslots();

        System.out.println(daysArrayList  + "\n"
                         + roomsArrayList + "\n"
                         + talksArrayList + "\n"
                         + timeslotsArrayList);
        return true;
    }

    public boolean createStandardDays(){
//        DaysDao daysDao = new DaysDao(dataSource);
        Days days = new Days(randomLong (), randomDays(), randomDates());
        daysArrayList.add(days);
        //System.out.println(daysArrayList);
        return true;
    }

    public boolean createStandardRooms(){
        Rooms rooms = new Rooms (randomLong (), randomRooms ());
        roomsArrayList.add(rooms);
        //System.out.println(roomsArrayList);
        return true;
    }

    public boolean createStandardTalks(){
        Talks talks = new Talks(randomLong (), randomTitle (), randomDescription (), randomTopic ());
        talksArrayList.add(talks);
        //System.out.println(talksArrayList);
        return true;
    }

//    public boolean createStandardTimeslots(){
//        Timeslots timeslots = new Timeslots(randomLong(), randomTime ());
//        timeslotsArrayList.add(timeslots);
//        //System.out.println(timeslotsArrayList);
//        return true;
//    }

    public Timeslots createStandardTimeslots(){
        Timeslots timeslots = new Timeslots(randomLong(), randomTime ());
        timeslotsArrayList.add(timeslots);
        //System.out.println(timeslotsArrayList);
        return timeslots;
    }

    private Long randomLong(){
        return pickOneLong(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
    }

    private String randomDays(){
        return pickOne(new String[] {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag"});
    }
    private String randomDates() {
        return pickOne ( new String[] {"01.10.2018", "07.10.2018", "22.10.2018", "01.11.2018", "03.11.2018"});
    }

    private String randomRooms(){
        return pickOne(new String[]{"Svane-salen", "Heisrommet", "Drømmerommet", "Vandresalen", "Klasserommet", "Festsalen", "Konferansesalen", "Grupperom 1"});
    }

    private String randomTitle() {
        return pickOne ( new String[] {"Dinosaurer i ", "Datamaskiner i ", "Matematikk for ", "", "Velkommen til "});
    }

    private String randomTopic() {
        return pickOne(new String[] {"nåtiden", "gårsdagen", "fremtiden", "barnehagen", "verden"});
    }

    private String randomDescription() {
        return pickOne(new String[] {"En samtale om data.", "Informasjon om tid og rom.", "Mange steder på en gang."});
    }

    private String randomTime(){
        return pickOne ( new String[] {"08.00-09.00", "11.00-14.15", "10.00-13.00", "", "16.30-18.00"});
    }

    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private Long pickOneLong(Long[] longs) {
        return longs[random.nextInt(longs.length)];
    }


}

