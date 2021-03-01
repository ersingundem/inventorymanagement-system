package dao;

import dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean login(UserDTO user){
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = database.connection.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select user_name, pasword from users where user_name= ? and pasword= ? ");
            ps.setString(1, UserDTO.getUser_name());
            ps.setString(2, UserDTO.getPasword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {

                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("hatalı giriş");
            return false;
        } finally {
            database.connection.close(con);
        }
    }

    public List<UserDTO> getUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        List<UserDTO> userList = new ArrayList<>();
        try {

            con = database.connection.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select id, user_name, pasword from users ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                UserDTO user = new UserDTO();
                Long id  = rs.getLong("id");
                String user_name  = rs.getString("user_name");
                String pasword = rs.getString("pasword");
                userList.add(user);

            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return userList;
        } finally {
            database.connection.close(con);
        }


        return userList;
    }
}
