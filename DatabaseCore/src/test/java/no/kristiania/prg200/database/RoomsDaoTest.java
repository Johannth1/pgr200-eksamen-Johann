package no.kristiania.prg200.database;

import no.kristiania.prg200.database.core.*;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class RoomsDaoTest {

    private RoomsDao roomsDao = new RoomsDao (TestDataSource.createDataSource() );

    @Test
    public void shouldCreateRooms() throws SQLException{
        Rooms rooms = sampleRooms();
        roomsDao.save(rooms);
        assertThat(rooms).hasNoNullFieldsOrProperties();
        assertThat (roomsDao.retrieve (rooms.getId()))
                .isEqualToComparingFieldByField(rooms);
    }

    @Test
    public void shouldRetrieveRoomsById() throws IOException, SQLException {
        Rooms rooms = sampleRooms();
        roomsDao.save(rooms);

        assertThat(rooms.getId()).isNotNull();
        assertThat(roomsDao.retrieve(rooms.getId()))
                .isEqualToComparingFieldByField(rooms);
    }

    @Test
    public void shouldFindSavedRooms() throws SQLException, IOException{
        Rooms rooms = sampleRooms ();
        roomsDao.save(rooms);

        assertThat(roomsDao.listAll().contains(rooms));
    }

    private Rooms sampleRooms() {
        Rooms rooms = new Rooms(0L, "");

        rooms.setRoom(randomRoom());
        return rooms;
    }

    private String randomRoom() {
        return pickOne ( new String[] {"Rom 1", "Rom 2", "Rom 3", "", "Rom 4"});
    }


    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private static Random random = new Random ();

}