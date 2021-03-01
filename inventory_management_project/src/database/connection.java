package database;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Properties;


public class connection {
    public String url = "jdbc:postgresql://localhost:5432/ims";
    public String user = "postgres";
    public String password = "root";

    public static connection getInstance() {
        return new connection();
    }


    public  Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            //HashMap<String, String> dbBilgileri = getDbBilgileri();

            Connection con = DriverManager.getConnection(url,user,password);
            return con;
        } catch (Exception ex) {
            System.out.println("database.connection.getConnection() HATASI" + ex.getMessage());
            return null;
        }
    }


    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

/*
    public HashMap<String, String> getDbBilgileri()  {
        InputStream inputStream = null;
        HashMap<String, String> dbBilgileri = new HashMap<>();
        try {
            Properties prop = new Properties();
            String propFileName = "project-config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            String url = prop.getProperty("db.url");
            dbBilgileri.put("url", url);
            String user = prop.getProperty("db.user");
            dbBilgileri.put("user", user);
            String password = prop.getProperty("db.password");
            dbBilgileri.put("password", password);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dbBilgileri;
    }

 */
}
