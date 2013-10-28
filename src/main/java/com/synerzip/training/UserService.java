/**
 * 
 */
package com.synerzip.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author ashutoshk
 * 
 */
public class UserService
{

    public static List<User> getUsers()
    {
        List<User> users = new ArrayList<User>();

        // load db details from properties file
        final Properties properties = new Properties();
        String host = null, username = null, password = null, dbname = null;
        try
        {
            properties.load(UserService.class.getResourceAsStream("db.properties"));
            host = properties.getProperty("host");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            dbname = properties.getProperty("dbname");
        } catch (IOException e1)
        {
            System.out.println("can't find properties file!!!");
            return users;
        }

        // connect to database
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":3306/" + dbname;
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection Established");

            if (con != null)
            {
                PreparedStatement pstmt = con.prepareStatement("select ID, NAME, EMAIL from USER_INFO");
                ResultSet rs = pstmt.executeQuery();
                if (rs != null)
                {
                    while (rs.next())
                    {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String email = rs.getString(3);

                        User user = new User();
                        user.setId(id);
                        user.setName(name);
                        user.setEmail(email);
                        users.add(user);
                    }
                }
            }

        } catch (Exception e)
        {
            System.out.println("Couldnt get connection");
            return users;
        }
        return users;
    }
}
