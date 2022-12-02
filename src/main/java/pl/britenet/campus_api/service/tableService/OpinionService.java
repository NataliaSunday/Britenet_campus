package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Opinion;
import pl.britenet.campus_api.model.builder.OpinionBuilder;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OpinionService {

    private final DatabaseService databaseService;

    public OpinionService(DatabaseService databaseService) { this.databaseService = databaseService; };

    public List<Opinion> getOpinionAll() {
        String dql ="SELECT * FROM opinion";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Opinion> opinionList = new ArrayList<>();
                while (resultSet.next()){
                    opinionList.add(new OpinionBuilder()
                            .setIdOpinion(resultSet.getInt("id_opinion"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setOpinionDate(resultSet.getString("opinion_date"))
                            .setOpinionContent(resultSet.getString("opinion_content"))
                            .setRating(resultSet.getInt("rating"))
                            .getOpinion());

                }
                return opinionList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }

    public Opinion getOpinionOne (int id) {
        String dql = String.format("SELECT * FROM opinion where id_opinion = %d", id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    return new OpinionBuilder()
                            .setIdOpinion(resultSet.getInt("id_opinion"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setOpinionDate(resultSet.getString("opinion_date"))
                            .setOpinionContent(resultSet.getString("opinion_content"))
                            .setRating(resultSet.getInt("rating"))
                            .getOpinion();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertOpinion(Opinion opinion) {
        String dml = String.format( "INSERT INTO opinion (id_product, id_user, opinion_date, opinion_content, rating) VALUES ('%d','%d','%S','%S','%d');",
                opinion.getIdProduct(), opinion.getIdUser(), opinion.getOpinionDate(), opinion.getOpinionContent(), opinion.getRating());
        this.databaseService.performDML(dml);
    }

    public void updateOpinion(int id, String col, String newContent) {
        if(col.equalsIgnoreCase("id_product") || col.equalsIgnoreCase("id_user") || col.equalsIgnoreCase("rating")){
            int parseNewContent = Integer.parseInt(newContent);
            String dml = String.format("UPDATE opinion SET %S = '%d' WHERE id_opinion = '%d'", col,  parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else if (col.equalsIgnoreCase("opinion_date") || col.equalsIgnoreCase("opinion_content") || col.equalsIgnoreCase("description")) {
            String dml = String.format(Locale.US, "UPDATE opinion SET %S = '%S' WHERE id_opinion = '%d'", col, newContent, id);
            this.databaseService.performDML(dml);
        }else {
            throw new NullPointerException();
        }
    }

    public void delOpinion(int id) {
        String dml = String.format("DELETE FROM opinion WHERE id_opinion=%d", id);
        this.databaseService.performDML(dml);
    };
}
