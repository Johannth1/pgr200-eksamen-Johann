package no.kristiania.prg200.database.core;



import javax.sql.DataSource;
import java.sql.*;
import java.util.List;


public class TracksDao extends AbstractDao implements DataAccessObject<Timeslots>{


    public TracksDao(DataSource dataSource) {
        super ( dataSource );
    }

    @Override
    public void save(Timeslots object) throws SQLException {

    }

    @Override
    public Timeslots retrieve(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Timeslots> listAll() throws SQLException {
        return null;
    }
}