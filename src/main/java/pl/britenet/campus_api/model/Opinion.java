package pl.britenet.campus_api.model;

public class Opinion {


    private int idOpinion;
    private int idProduct;
    private int idUser;
    private String opinionDate;
    private String opinionContent;
    private int rating;
    private Product product;
    private User user;

    public Opinion(){};

    public int getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(int idOpinion) {
        this.idOpinion = idOpinion;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getOpinionDate() {
        return opinionDate;
    }

    public void setOpinionDate(String opinionDate) {
        this.opinionDate = opinionDate;
    }

    public String getOpinionContent() {
        return opinionContent;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return
                "\nidOpinion=" + idOpinion +
                "\nidProduct=" + idProduct +
                "\nidUser=" + idUser +
                "\nopinionDate='" + opinionDate +
                "\nopinionContent='" + opinionContent +
                "\nrating=" + rating +
                "\nuser=" + user + "\n";
    }



}
