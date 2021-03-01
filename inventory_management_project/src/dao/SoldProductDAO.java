package dao;

import dto.SoldProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoldProductDAO {
    public SoldProductDAO() {
    }


    public List<SoldProductDTO> getSoldProduct(){


        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<SoldProductDTO> soldProductList = new ArrayList<>();

        try {

            c = database.connection.getInstance().getConnection();
            ps = c.prepareStatement("select * from sold_product");
            rs = ps.executeQuery();
            while (rs.next())
            {
                SoldProductDTO soldProduct = new SoldProductDTO();
                soldProduct.setID(rs.getLong("ID"));
                soldProduct.setProduct_id(rs.getLong("product_id"));
                soldProduct.setCustomer_id(rs.getLong("customer_id"));
                soldProduct.setSold_date(rs.getDate("sold_date"));

                soldProductList.add(soldProduct);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return soldProductList;
        } finally {
            try {
                rs.close();
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return  soldProductList;
    }


    public void insert(SoldProductDTO soldProduct) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps;

        String sqlInsert = "insert into sold_product(product_id , customer_id , sold_date)\n ";
        sqlInsert += " values (?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);
            ps.setLong(1,soldProduct.getProduct_id());
            ps.setLong(2,soldProduct.getCustomer_id());
            ps.setDate(3, new java.sql.Date(soldProduct.getSold_date().getTime()));



            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long soldProductId) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM sold_product WHERE id = ?");
            ps.setLong(1,soldProductId);
            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void update(SoldProductDTO soldProduct) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update sold_product set product_id= ? ,customer_id = ?,sold_date= ? where id= ?");

            ps.setLong(1,soldProduct.getProduct_id());
            ps.setLong(2,soldProduct.getCustomer_id());
            ps.setDate(3, new java.sql.Date(soldProduct.getSold_date().getTime()));
            ps.setLong(4, soldProduct.getID());
            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
