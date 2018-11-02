package no.kristiania.prg200.database.core;



import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


public class TimeslotsDao extends AbstractDao implements DataAccessObject<Timeslots> {

    public TimeslotsDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Timeslots timeslots) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql =
                    "insert into Timeslots (timeslots_time)"
                            + "values (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setObject(1, timeslots.getTime ());
                statement.executeUpdate();

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    timeslots.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Timeslots retrieve(Long id) throws  SQLException {
        return retrieveSingleObject ( "SELECT * FROM timeslots WHERE id = ?", this::mapToTimeslots, id );

    }

    @Override
    public List<Timeslots> listAll() throws SQLException {
        return list("select * from timeslots", this::mapToTimeslots);
    }


    public Timeslots mapToTimeslots(ResultSet rs) throws SQLException{
        Timeslots timeslots = new Timeslots ();
        timeslots.setId ( rs.getLong ( "id" ) );
        timeslots.setTime ( rs.getString ( "timeslots_time" ) );
        return timeslots;
    }


}