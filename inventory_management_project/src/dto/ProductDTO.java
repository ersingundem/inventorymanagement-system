package dto;
import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {
    private Long id;
    private String title;
    private Double price;
    private int stock;

    public ProductDTO() {

    }

    public ProductDTO(Long id, String title, Double price, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Object[] getObjects() {
        Object objects[] = { id,title,price,stock };

        return objects;
    }
}


