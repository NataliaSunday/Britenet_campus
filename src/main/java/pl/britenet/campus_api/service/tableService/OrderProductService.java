package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.builder.OrderBuilder;
import pl.britenet.campus_api.model.builder.OrderProductBuilder;
import pl.britenet.campus_api.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderProductService {

    private final DatabaseService databaseService;

    public OrderProductService(DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<OrderProduct> getOrderProductAll(){
        String dql ="SELECT op.id_order_product,op.id_product,op.id_order,op.how_many,op.price, o.id_order, o.id_user, o.order_date, o.country, o.city, o.home_number, o.zip_code, o.phone_number, o.e_mail, o.order_status, o.is_paid, o.total_price, o.discount,p.id_product,p.id_category,p.name,p.producer, p.description, p.price, p.how_many FROM order_product op INNER JOIN orders o ON op.id_order = o.id_order INNER JOIN product p ON op.id_product = p.id_product;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<OrderProduct> orderProductList = new ArrayList<>();
                while (resultSet.next()){
                    Product product = new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .getProduct();
                    Order order = new OrderBuilder()
                            .setIdOrder(resultSet.getInt("o.id_order"))
                            .setIdUser(resultSet.getInt("o.id_user"))
                            .setOrderDate(resultSet.getString("o.order_date"))
                            .setCountry(resultSet.getString("o.country"))
                            .setCity(resultSet.getString("o.city"))
                            .setHomeNumber(resultSet.getString("o.home_number"))
                            .setZipCode(resultSet.getString("o.zip_code"))
                            .setPhoneNumber(resultSet.getString("o.phone_number"))
                            .seteMail(resultSet.getString("o.e_mail"))
                            .setOrderStatus(resultSet.getString("o.order_status"))
                            .setIsPaid(resultSet.getBoolean("o.is_paid"))
                            .setTotalPrice(resultSet.getDouble("o.total_price"))
                            .setDiscount(resultSet.getDouble("o.discount"))
                            .getOrder();
                    orderProductList.add(new OrderProductBuilder()
                            .setIdOrderProduct(resultSet.getInt("op.id_order_product"))
                            .setIdProduct(resultSet.getInt("op.id_product"))
                            .setIdOrder(resultSet.getInt("op.id_order"))
                            .setHowMany(resultSet.getInt("op.how_many"))
                            .setPrice(resultSet.getDouble("op.price"))
                            .setProduct(product)
                            .setOrder(order)
                            .getOrderProduct());
                }
                return orderProductList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }
    public OrderProduct getOrderProductOne(int id){
        String dql =String.format("SELECT op.id_order_product,op.id_product,op.id_order,op.how_many,op.price, o.id_order, o.id_user, o.order_date, o.country, o.city, o.home_number, o.zip_code, o.phone_number, o.e_mail, o.order_status, o.is_paid, o.total_price, o.discount,p.id_product,p.id_category,p.name,p.producer, p.description, p.price, p.how_many FROM order_product op INNER JOIN orders o ON op.id_order = o.id_order INNER JOIN product p ON op.id_product = p.id_product WHERE id_order_product=%d",id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    Product product = new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .getProduct();
                    Order order = new OrderBuilder()
                            .setIdOrder(resultSet.getInt("o.id_order"))
                            .setIdUser(resultSet.getInt("o.id_user"))
                            .setOrderDate(resultSet.getString("o.order_date"))
                            .setCountry(resultSet.getString("o.country"))
                            .setCity(resultSet.getString("o.city"))
                            .setHomeNumber(resultSet.getString("o.home_number"))
                            .setZipCode(resultSet.getString("o.zip_code"))
                            .setPhoneNumber(resultSet.getString("o.phone_number"))
                            .seteMail(resultSet.getString("o.e_mail"))
                            .setOrderStatus(resultSet.getString("o.order_status"))
                            .setIsPaid(resultSet.getBoolean("o.is_paid"))
                            .setTotalPrice(resultSet.getDouble("o.total_price"))
                            .setDiscount(resultSet.getDouble("o.discount"))
                            .getOrder();
                    new OrderProductBuilder()
                            .setIdOrderProduct(resultSet.getInt("id_order_product"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdOrder(resultSet.getInt("id_order"))
                            .setHowMany(resultSet.getInt("how_many"))
                            .setPrice(resultSet.getDouble("price"))
                            .setProduct(product)
                            .setOrder(order)
                            .getOrderProduct();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertOrderProduct(OrderProduct orderProduct){
        String dml = String.format(Locale.US, "INSERT INTO order_product(id_product, id_order, how_many, price) VALUES ( %d, %d, %d, %f);", orderProduct.getIdProduct(),orderProduct.getIdOrder(), orderProduct.getHowMany(), orderProduct.getPrice());
        this.databaseService.performDML(dml);
    }

    public void updateOrderProduct(int id, String col, String newContent) {

        if (col.equalsIgnoreCase("id_product") || col.equalsIgnoreCase("id_order") || col.equalsIgnoreCase("how_many")){
            int parseNewContent = Integer.parseInt(newContent);
            String dml = String.format("UPDATE order_product SET %S = %d WHERE id_order_product= %d", col, parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else if ( col.equalsIgnoreCase("price")){
            double parseNewContent = Double.parseDouble(newContent);
            String dml = String.format("UPDATE  order_product  SET %S = %d WHERE id_order_product= %d", col, parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else {
            throw new NullPointerException();
        }
    }

    public void delOrderProduct(int id) {
        String dml = String.format("DELETE FROM order_product WHERE id_order_product=%d", id);
        this.databaseService.performDML(dml);
    };
}
