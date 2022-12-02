package pl.britenet.campus_api.model;
import java.math.BigDecimal;
public class Product {

    private  String name;
    private int id;
    private double price;
    private int idCategory;
    private  String desc;
    private String producer;
    private int howMany;

    private Category category;

    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return
                "\nname='" + name +
                "\nid=" + id +
                "\nidCategory=" + idCategory +
                "\ncategory='" + category +
                "\nprice=" + price +
                "\ndesc='" + desc +
                "\nproducer='" + producer +
                "\nhowMany=" + howMany + "\n" ;
    }

}
