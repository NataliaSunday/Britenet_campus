package pl.britenet.campus_api.database.DatabaseService;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseService {

    private HikariDataSource dataSource; //pool

    public DatabaseService() {
        this.dataSource = new HikariDataSource(HikariConfigFactory.createStandardConfig());
    }

    public void performDML(String dml) { //data manipulation lang

        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(dml)) {

            statement.executeUpdate();
        }catch (SQLException e){ //error sqlexepction, error runtime
            throw new IllegalStateException(e);
        }
    }
    public <T> T performSQL(String sql, ResultParser<T> resultParser) {
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            return  resultParser.parse(statement.executeQuery());
            }
        catch (SQLException e){ //error sqlexepction, error runtime
            throw new IllegalStateException(e);
        }
    }
}
