package no.kristiania.prg200.database.core;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {

    T mapResultSet(ResultSet rs) throws SQLException;

}

