package no.kristiania.prg200.database.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;




public class TalksDao extends AbstractDao implements DataAccessObject<Talks> {

    public TalksDao(DataSource dataSource){
        super (dataSource);
    }

    @Override
    public void save(Talks talks) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql =
                    "insert into Talks (talks_title, talks_topic, talks_description) "
                            + "values (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setObject(1, talks.getTitle ());
                statement.setObject ( 2, talks.getTopic ());
                statement.setObject ( 3, talks.getDescription ());
                statement.executeUpdate();

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    rs.next();
                    talks.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Talks retrieve(Long id) throws SQLException {
        return retrieveSingleObject ( "SELECT * FROM talks WHERE id = ?", this::mapToTalks, id);
    }

    @Override
    public List<Talks> listAll() throws SQLException {
        return list("select * from talks", this::mapToTalks);
    }


    public Talks mapToTalks(ResultSet rs) throws SQLException{
        Talks talks = new Talks ();
        talks.setId ( rs.getLong ( "id" ) );
        talks.setTitle ( rs.getString ( "talks_title" ) );
        talks.setTopic ( rs.getString ( "talks_topic" ) );
        talks.setDescription ( rs.getString ( "talks_description" ) );
        return talks;
    }


}