package no.kristiania.prg200.database.core;



import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


public class TracksDao extends AbstractDao implements DataAccessObject<Tracks>{
//        Tracks tracks;
//        Talks talks;
//        Days days;
//        Timeslots timeslots;
//        Rooms rooms;

    public TracksDao(DataSource dataSource) {
        super ( dataSource );
//        talks.getId();
//        days.getId();
//        timeslots.getId();
//        rooms.getId();
//
//        Talks talks = tracks.createStandardTalks();
//        Days days = tracks.createStandardDays();
//        Timeslots timeslots = tracks.createStandardTimeslots();
//        Rooms rooms = tracks.createStandardRooms();
    }

    @Override
    public void save(Tracks tracks) throws SQLException {
        Talks talks = tracks.createStandardTalks();
        Days days = tracks.createStandardDays();
        Timeslots timeslots = tracks.createStandardTimeslots();
        Rooms rooms = tracks.createStandardRooms();
        try (Connection connection = dataSource.getConnection()) {
            String sql =
                    "insert into Tracks (tracks_tracks, talks_id, days_id, timeslots_id, rooms_id)"
                            + "values (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setObject(1, tracks.getTracks());
                statement.setObject(2, talks.getId());
                statement.setObject(3, days.getId());
                statement.setObject(4, timeslots.getId());
                statement.setObject(5, rooms.getId());
                statement.executeUpdate();

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    tracks.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Tracks retrieve(Long id) throws SQLException {
        return retrieveSingleObject ( "SELECT * FROM tracks WHERE id = ?", this::mapToTracks, id );
    }

    @Override
    public List<Tracks> listAll() throws SQLException {
        return list("SELECT * FROM tracks", this::mapToTracks);
    }

    public  Tracks mapToTracks(ResultSet rs) throws SQLException{
        Tracks tracks = new Tracks(dataSource);

        Talks talks = tracks.createStandardTalks();
        Days days = tracks.createStandardDays();
        Timeslots timeslots = tracks.createStandardTimeslots();
        Rooms rooms = tracks.createStandardRooms();

        tracks.setId ( rs.getLong ( "id" ) );
        talks.setId ( rs.getLong ( "talks_id" ) );
        days.setId ( rs.getLong ( "days_id" ) );
        timeslots.setId ( rs.getLong ( "timeslots_id" ) );
        rooms.setId ( rs.getLong ( "rooms_id" ) );
        //System.out.println (tracks);
        return tracks;
    }
}
