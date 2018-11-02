package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


public class RoomsDao extends AbstractDao implements DataAccessObject<Rooms> {

    public RoomsDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Rooms rooms) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql =
                    "insert into Rooms (rooms_room)"
                            + "values (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setObject(1, rooms.getRoom());
                statement.executeUpdate();

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    rooms.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Rooms retrieve(Long id) throws  SQLException {
        return retrieveSingleObject ( "SELECT * FROM rooms WHERE id = ?", this::mapToRooms, id );

    }

    @Override
    public List<Rooms> listAll() throws SQLException {
        return list("SELECT * FROM rooms", this::mapToRooms);
    }


    public Rooms mapToRooms(ResultSet rs) throws SQLException{
        Rooms rooms = new Rooms(1L, "");
        rooms.setId ( rs.getLong ( "id" ) );
        rooms.setRoom ( rs.getString ( "rooms_room" ) );
        System.out.println(rooms);
        return rooms;
    }


}