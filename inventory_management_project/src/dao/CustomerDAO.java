package dao;

import dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public CustomerDAO() {
    }

    public List<CustomerDTO> getCustomer() {


        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<CustomerDTO> customerList = new ArrayList<>();

        try {

            c = database.connection.getInstance().getConnection();
            ps = c.prepareStatement("select * from customer");
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerDTO customer = new CustomerDTO();
                customer.setId(rs.getLong("id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setBirth_date(rs.getDate("birth_date"));
                customer.setPhone(rs.getString("phone"));
                customer.setAdress(rs.getString("address"));

                customerList.add(customer);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş " + ex.getLocalizedMessage());
            return customerList;
        } finally {
            try {
                rs.close();
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return customerList;
    }


    public void insert(CustomerDTO customer) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into customer(first_name,last_name,email,address,birth_date,phone)\n ";
        sqlInsert += " values (?,?,?,?,?,?); \n";

        try {

            ps = c.prepareStatement(sqlInsert);
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAdress());
            ps.setDate(5, new java.sql.Date(customer.getBirth_date().getTime()));
            ps.setString(6, customer.getPhone());


            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long customerId) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {

            ps = c.prepareStatement("DELETE FROM customer WHERE id = ?");
            ps.setLong(1, customerId);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void update(CustomerDTO customer) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {

            ps = c.prepareStatement("update customer set first_name= ?, last_name = ?, email= ?,address= ?, birth_date= ? , phone=?  where id= ?");

            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAdress());
            ps.setDate(5, new java.sql.Date(customer.getBirth_date().getTime()));
            ps.setString(6, customer.getPhone());
            ps.setLong(7, customer.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
