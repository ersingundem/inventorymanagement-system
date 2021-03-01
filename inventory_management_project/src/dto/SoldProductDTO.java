package dto;
import java.time.LocalDateTime;
import java.util.Date;


public class SoldProductDTO {
    private Long ID;
    private Long product_id;
    private Long customer_id;
    private Date sold_date;

    public SoldProductDTO() {
    }


    public SoldProductDTO(Long ID, Long product_id, Long customer_id, Date sold_date) {
        this.ID = ID;
        this.product_id = product_id;
        this.customer_id = customer_id;
        this.sold_date = sold_date;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Date getSold_date() {
        return sold_date;
    }

    public void setSold_date(Date sold_date) {
        this.sold_date = sold_date;
    }
    public Object[] getObjects() {
        Object objects[] = {ID, product_id, customer_id, sold_date};

        return objects;
    }
}
