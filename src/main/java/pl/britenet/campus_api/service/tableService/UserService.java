package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.model.builder.UserBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserService {

    private final DatabaseService databaseService;

    public UserService(DatabaseService databaseService) {this.databaseService = databaseService;}
    public List<User> getUserAll(){
        String dql ="SELECT * FROM users";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<User> userList = new ArrayList<>();
               while (resultSet.next()){
                    userList.add(new UserBuilder()
                            .setIdUser(resultSet.getInt("id_user"))
                            .setName(resultSet.getString("name"))
                            .setSurname(resultSet.getString("surname"))
                            .setPassword(resultSet.getString("user_password"))
                            .setNickname(resultSet.getString("nickname"))
                            .setCountry(resultSet.getString("country"))
                            .setCity(resultSet.getString("city"))
                            .setHomeNumber(resultSet.getString("home_number"))
                            .setZipCode(resultSet.getString("zip_code"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .seteMail(resultSet.getString("e_mail"))
                            .getUser());

                }
               return userList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }
    public User getUserOne(int id){
        String dql =String.format("SELECT * FROM users where id_user=%d",id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    return new UserBuilder()
                            .setIdUser(resultSet.getInt("id_user"))
                            .setName(resultSet.getString("name"))
                            .setSurname(resultSet.getString("surname"))
                            .setPassword(resultSet.getString("user_password"))
                            .setNickname(resultSet.getString("nickname"))
                            .setCountry(resultSet.getString("country"))
                            .setCity(resultSet.getString("city"))
                            .setHomeNumber(resultSet.getString("home_number"))
                            .setZipCode(resultSet.getString("zip_code"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .seteMail(resultSet.getString("e_mail"))
                            .getUser();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertUser(User user){
        String dml = String.format("INSERT INTO users (name, surname, user_password, nickname, country, city, home_number, zip_code, phone_number, e_mail) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", user.getName(), user.getSurname(), user.getPassword(), user.getNickname(), user.getCountry(), user.getCity(), user.getHomeNumber(), user.getZipCode(), user.getPhoneNumber(), user.geteMail());
        this.databaseService.performDML(dml);
    }
    public void updateUser(User user) {
        String dml = String.format(Locale.US,"UPDATE users SET  name = '%s', surname ='%s', user_password = '%s', nickname= '%s', country='%s', city='%s', home_number = '%s', zip_code = '%s', phone_number ='%s', e_mail='%s' WHERE id_user= %d;", user.getName(), user.getSurname(), user.getPassword(), user.getNickname(),user.getCountry(), user.getCity(), user.getHomeNumber(), user.getZipCode(), user.getPhoneNumber(), user.geteMail(), user.getIdUser());
        this.databaseService.performDML(dml);
    }


    public void delUser(int id) {
        String dml = String.format("DELETE FROM users WHERE id_user=%d", id);
        this.databaseService.performDML(dml);
    };

    public User getUserAuth(String nickname, String password){
        String dql =String.format("SELECT * FROM users WHERE nickname = '%s' and user_password = '%s';", nickname, password);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    return new UserBuilder()
                            .setIdUser(resultSet.getInt("id_user"))
                            .setName(resultSet.getString("name"))
                            .setSurname(resultSet.getString("surname"))
                            .setPassword(resultSet.getString("user_password"))
                            .setNickname(resultSet.getString("nickname"))
                            .setCountry(resultSet.getString("country"))
                            .setCity(resultSet.getString("city"))
                            .setHomeNumber(resultSet.getString("home_number"))
                            .setZipCode(resultSet.getString("zip_code"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .seteMail(resultSet.getString("e_mail"))
                            .getUser();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });

    }


}


