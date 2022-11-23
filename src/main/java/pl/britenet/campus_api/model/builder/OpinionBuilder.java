package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Opinion;

public class OpinionBuilder{

    private final Opinion opinion;

    public OpinionBuilder(){ this.opinion = new Opinion(); }

    public OpinionBuilder setIdOpinion(int idOpinion){
        this.opinion.setIdOpinion(idOpinion);
        return this;
    }
    public OpinionBuilder setIdProduct(int idProduct){
        this.opinion.setIdProduct(idProduct);
        return this;
    }
    public OpinionBuilder setIdUser(int idUser){
        this.opinion.setIdUser(idUser);
        return this;
    }
    public OpinionBuilder setOpinionDate(String date){
        this.opinion.setOpinionDate(date);
        return this;
    }
    public OpinionBuilder setOpinionContent(String opinionContent){
        this.opinion.setOpinionContent(opinionContent);
        return this;
    }
    public OpinionBuilder setRating(int rating){
        this.opinion.setRating(rating);
        return this;
    }
}
