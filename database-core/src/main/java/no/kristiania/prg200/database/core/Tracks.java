package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;

/**
 * I denne klassen kobler vi sammen klassene Days + DaysDao, Talks + TalksDao, Rooms + RoomsDao og Timeslots + TimeslotsDao.
 *
 * TODO: Ordne opp i denne klassen så man tar i bruk de andre klassene.
 */

public class Tracks extends AbstractDao {
    Long id;

    ArrayList<Days> daysArrayList;
    ArrayList<Rooms> roomsArrayList;


    public Tracks(DataSource dataSource){
        super(dataSource);
        daysArrayList = new ArrayList<>();
        roomsArrayList = new ArrayList<>();


    }

    public boolean createStandardDays(){
//        DaysDao daysDao = new DaysDao(dataSource);
        Days days = new Days(1L, "Mandag", "22.10.2018");

        daysArrayList.add(days);
        System.out.println(daysArrayList);
        return true;
    }

    public boolean createStandardRooms(){
        Rooms rooms = new Rooms (2L, "Svane-salen");
        roomsArrayList.add(rooms);

        System.out.println(roomsArrayList);
        return true;
    }


}
