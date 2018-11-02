package no.kristiania.prg200.database.core;



import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


public class TracksDao /*extends AbstractDao implements DataAccessObject<Tracks> */{

//    public TracksDao(DataSource dataSource){
//        super (dataSource);
//    }
//
//    @Override
//    public void save(Tracks tracks) throws SQLException {
//        try (Connection connection = dataSource.getConnection()) {
//            String sql =
//                    "insert into tracks (tracks_tracks, talks_id, days_id, timeslots_id, rooms_id)"
//                            + "values (?, ?, ?, ?, ?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//                statement.setObject(1, tracks.getTracks());
//                statement.setObject(2, tracks.talks_id);
//                statement.setObject(3, tracks.days_id);
//                statement.setObject(4, tracks.timeslots_id);
//                statement.setObject(5, tracks.rooms_id);
//
//                statement.executeUpdate();
//
//                try (ResultSet rs = statement.getGeneratedKeys()) {
//                    rs.next();
//                    tracks.setId(rs.getLong(1));
//                }
//            }
//        }
//    }
//
//    @Override
//    public Tracks retrieve(Long id) throws  SQLException {
//        return retrieveSingleObject ( "SELECT * FROM tracks WHERE id = ?", this::mapToTracks, id );
//
//    }
//
//    @Override
//    public List<Tracks> listAll() throws SQLException {
//        return list("select * from tracks", this::mapToTracks);
//    }
//
//
//    public Tracks mapToTracks(ResultSet rs) throws SQLException{
//        Tracks tracks = new Tracks ();
//        tracks.setId ( rs.getLong ( "id" ) );
//        tracks.setTracks ( rs.getString ( "tracks_tracks" ) );
//        tracks.setTracks ( rs.getString ( "days_id" ) );
//        tracks.setTracks ( rs.getString ( "timeslots_id" ) );
//        tracks.setTracks ( rs.getString ( "rooms_id" ) );
//        return tracks;
//    }


}