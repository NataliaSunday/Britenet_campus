package pl.britenet.campus_api.database.DatabaseService;

import com.zaxxer.hikari.HikariConfig;

public class HikariConfigFactory {

    public  static HikariConfig createStandardConfig(){ //driver
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/campus_base"); //prot jdbc - connector
        config.setUsername("root");
        config.setPassword("");
        return config;
    }
}
