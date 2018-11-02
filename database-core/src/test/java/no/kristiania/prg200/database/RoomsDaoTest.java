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
        Rooms rooms = new Rooms(randomLong (), randomRoom ());

        rooms.setRoom(randomRoom());
        return rooms;
    }

    private Long randomLong(){
        return pickOneLong(new Long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L});
    }

    private String randomRoom() {
        return pickOne ( new String[] {"Rom 1", "Rom 2", "Rom 3", "", "Rom 4"});
    }


    private String pickOne(String[] strings) {
        return strings[random.nextInt(strings.length)];
    }

    private Long pickOneLong(Long[] longs) {
        return longs[random.nextInt(longs.length)];
    }

    private static Random random = new Random ();

}