package dao;

import dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public ProductDAO(){

    }


    public List<ProductDTO> getProduct() {

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<ProductDTO> productList = new ArrayList<>();

        try {

            c = database.connection.getInstance().getConnection();
            ps = c.prepareStatement("select * from product");
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setId(rs.getLong("id"));
                product.setTitle(rs.getString("title"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));




                productList.add(product);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş " + ex.getLocalizedMessage());
            return productList;
        } finally {

            try {
                rs.close();
                ps.close();
                database.connection.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return productList;
    }


    public void insert(ProductDTO product) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into product(title,price,stock)\n ";
        sqlInsert += " values (?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);

            ps.setString(1,product.getTitle());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getStock());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long productId) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM product WHERE id = ?");
            ps.setLong(1,productId);
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

    public void update(ProductDTO product) {

        Connection c = database.connection.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update product set title = ?,price= ?, stock= ? where id =?");

            ps.setString(1,product.getTitle());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getStock());
            ps.setLong(4,product.getId());
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

