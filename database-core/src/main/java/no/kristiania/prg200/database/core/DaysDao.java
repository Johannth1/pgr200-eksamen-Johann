package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DaysDao extends AbstractDao implements DataAccessObject<Days> {

    public DaysDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Days days) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql =
                    "insert into Days (days_days, days_date) values (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setObject(1, days.getDays());
                statement.setObject ( 2, days.getDate () );
                statement.executeUpdate();

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    days.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Days retrieve (Long id) throws SQLException{
        return retrieveSingleObject ( "SELECT * FROM days WHERE id = ?", this::mapToDays, id);
    }

    @Override
    public List<Days> listAll() throws SQLException {
        return list("SELECT * FROM days", this::mapToDays);
    }


    public Days mapToDays(ResultSet rs) throws SQLException{
        Tracks tracks = new Tracks(dataSource);
        Days days = tracks.createStandardDays ();
        days.setId ( rs.getLong ( "id" ) );
        days.setDays ( rs.getString ( "days_days" ) );
        days.setDate ( rs.getString ( "days_date" ) );
        System.out.println(days);
        return days;
    }


}
