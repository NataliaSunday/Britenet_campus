package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Opinion;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.model.builder.OpinionBuilder;
import pl.britenet.campus_api.model.builder.ProductBuilder;
import pl.britenet.campus_api.model.builder.UserBuilder;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OpinionService {

    private final DatabaseService databaseService;

    public OpinionService(DatabaseService databaseService) { this.databaseService = databaseService; };

    public List<Opinion> getOpinionAll() {
        String dql ="SELECT o.id_opinion, o.id_product, o.id_user, o.opinion_date, o.opinion_content, o.rating, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail  FROM opinion o INNER JOIN users u ON o.id_user = u.id_user;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Opinion> opinionList = new ArrayList<>();
                while (resultSet.next()){
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();
                    opinionList.add(new OpinionBuilder()
                            .setIdOpinion(resultSet.getInt("id_opinion"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setOpinionDate(resultSet.getString("opinion_date"))
                            .setOpinionContent(resultSet.getString("opinion_content"))
                            .setRating(resultSet.getInt("rating"))
                            .setUser(user)
                            .getOpinion());

                }
                return opinionList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }

    public Opinion getOpinionOne (int id) {
        String dql = String.format("SELECT o.id_opinion, o.id_product, o.id_user, o.opinion_date, o.opinion_content, o.rating, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail  FROM opinion o INNER JOIN users u ON o.id_user = u.id_user WHERE id_opinion = %d", id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();
                    return new OpinionBuilder()
                            .setIdOpinion(resultSet.getInt("id_opinion"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setOpinionDate(resultSet.getString("opinion_date"))
                            .setOpinionContent(resultSet.getString("opinion_content"))
                            .setRating(resultSet.getInt("rating"))
                            .setUser(user)
                            .getOpinion();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertOpinion(Opinion opinion) {
        String dml = String.format( "INSERT INTO opinion (id_product, id_user, opinion_date, opinion_content, rating) VALUES ('%d','%d','%s','%s','%d');",
                opinion.getIdProduct(), opinion.getIdUser(), opinion.getOpinionDate(), opinion.getOpinionContent(), opinion.getRating());
        System.out.println( opinion.getOpinionContent());
        this.databaseService.performDML(dml);
    }

    public void updateOpinion(Opinion opinion) {
        String dml = String.format("UPDATE opinion SET id_product = %d, id_user = %d, opinion_date = '%s', opinion_content = '%s', rating = %d WHERE id_opinion = '%d'", opinion.getIdProduct(), opinion.getIdUser(), opinion.getOpinionDate(), opinion.getOpinionContent(), opinion.getRating(), opinion.getIdOpinion() );
        this.databaseService.performDML(dml);
    };

    public void delOpinion(int id) {
        String dml = String.format("DELETE FROM opinion WHERE id_opinion=%d", id);
        this.databaseService.performDML(dml);
    };


    public List<Opinion> getOpinionsByProd (int prodId) {
        String dql = String.format("SELECT o.id_opinion, o.id_product, o.id_user, o.opinion_date, o.opinion_content, o.rating, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail  FROM opinion o INNER JOIN users u ON o.id_user = u.id_user WHERE o.id_product = %d", prodId);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Opinion> opinionList = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();
                    opinionList.add(new OpinionBuilder()
                            .setIdOpinion(resultSet.getInt("o.id_opinion"))
                            .setIdProduct(resultSet.getInt("o.id_product"))
                            .setIdUser(resultSet.getInt("o.id_user"))
                            .setOpinionDate(resultSet.getString("o.opinion_date"))
                            .setOpinionContent(resultSet.getString("o.opinion_content"))
                            .setRating(resultSet.getInt("o.rating"))
                            .setUser(user)
                            .getOpinion());

                }
                return opinionList;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }

        });
    }

}


