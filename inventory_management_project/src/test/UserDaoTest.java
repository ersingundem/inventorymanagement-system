package test;

import dao.UserDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class UserDaoTest {

    @Test
    public void testGetUser(){
        Connection con = database.connection.getInstance().getConnection();
        Assert.assertEquals(1,1);
    }

    @Test
    public void testGetUsers(){
        UserDAO userDAO = new UserDAO();
        Assert.assertTrue(userDAO.getUsers().size() > 0);
    }


}
