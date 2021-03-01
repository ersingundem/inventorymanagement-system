package dto;

public class UserDTO {
    private Long id;
    private static String user_name;
    private static String pasword;
    private String name_surname;
    private String phone;
    private String email;
    private String adress;

    public UserDTO()
    {

    }

    public UserDTO(Long id, String user_name, String pasword, String name_surname, String phone, String email, String adress) {
        this.id = id;
        this.user_name = user_name;
        this.pasword = pasword;
        this.name_surname = name_surname;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public static String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
