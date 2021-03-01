package dto;
import java.time.LocalDateTime;
import java.util.Date;

public class CustomerDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String adress;
    private Date birth_date;
    private String phone;


    public CustomerDTO() {

    }

    public CustomerDTO(Long id, String first_name, String last_name, String email, String adress, Date birth_date, String phone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.adress = adress;
        this.birth_date = birth_date;
        this.phone = phone;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object[] getObjects() {
        Object objects[] = {id, first_name, last_name, email, adress, birth_date, phone};

        return objects;
    }
}
