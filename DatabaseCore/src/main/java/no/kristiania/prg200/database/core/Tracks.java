package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * I denne klassen kobler vi sammen Days, Talks, Rooms og Timeslots.
 *
 * todo: evaluer om det er nødvendig med String tracks i tracks. + equals-metode + passende toString-metode
 */

public class Tracks extends AbstractDao {
    Long id;
    //Long id = getId ();
    String tracks;

    //Random random = new Random();
    RandomObject randomObject = new RandomObject ();


    public Tracks(DataSource dataSource){
        super(dataSource);
        //id = getId();
        id = randomObject.randomLong ();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public Tracks createStandardTracks() throws SQLException {
        Tracks tracks = new Tracks(dataSource);
        //tracks.setId(randomLong());
        tracks.setTracks(randomObject.randomTracks());
        //createStandardDays();
        createStandardRooms();
        createStandardTalks();
        createStandardTimeslots();

        return tracks;
    }

    public Days createStandardDays() throws SQLException {
//        DaysDao daysDao = new DaysDao(dataSource);
        Days days = new Days(randomObject.randomLong(), randomObject.randomDays(), randomObject.randomDates());
        DaysDao daysDao = new DaysDao ( dataSource );
        daysDao.save ( days );
        //daysArrayList.add(days);
        //System.out.println(daysArrayList);
        return days;
    }

    public Rooms createStandardRooms() throws SQLException {
        Rooms rooms = new Rooms (randomObject.randomLong (), randomObject.randomRooms ());
        RoomsDao roomsDao = new RoomsDao ( dataSource );
        roomsDao.save ( rooms );
        //roomsArrayList.add(rooms);
        //System.out.println(roomsArrayList);
        return rooms;
    }

    public Talks createStandardTalks() throws SQLException {
        Talks talks = new Talks(randomObject.randomLong (), randomObject.randomTitle (), randomObject.randomDescription (), randomObject.randomTopic ());
        TalksDao talksDao = new TalksDao ( dataSource );
        talksDao.save ( talks );
        //talksArrayList.add(talks);
        //System.out.println(talksArrayList);
        return talks;
    }

    public Timeslots createStandardTimeslots() throws SQLException {
        Timeslots timeslots = new Timeslots(randomObject.randomLong(), randomObject.randomTime ());
        TimeslotsDao timeslotsDao = new TimeslotsDao ( dataSource );
        timeslotsDao.save ( timeslots );
        //timeslotsArrayList.add(timeslots);
        //System.out.println(timeslotsArrayList);
        System.out.println(toString());
        return timeslots;
    }

    @Override
    public String toString() {
        return "Tracks { ID = '" + id + "' tracks = '" + tracks + "' }";
    }
}

