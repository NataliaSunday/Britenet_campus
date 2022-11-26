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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", idCategory=" + idCategory +
                ", desc='" + desc + '\'' +
                ", producer='" + producer + '\'' +
                ", howMany=" + howMany +
                '}';
    }

}
