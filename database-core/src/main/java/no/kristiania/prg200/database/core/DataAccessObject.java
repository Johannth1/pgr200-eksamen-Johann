package no.kristiania.prg200.database.core;

import java.sql.SQLException;
import java.util.List;

public interface DataAccessObject<T> {

    void save(T object) throws SQLException;

    T retrieve(Long id) throws SQLException;

    List<T> listAll() throws SQLException;

}
