package pl.britenet.campus_api.database.DatabaseService;

import java.sql.ResultSet;

public interface ResultParser<T> {
    T parse (ResultSet resultSet);
}
