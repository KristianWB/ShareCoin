package com.example.sharecoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Database
{

    public static Connection getConnection()
    {

        Connection con = null;
        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lokale", "root", "");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

    public void insertIntoDatabaseUser(String navn,String efternavn, String adresse, String email,String medlemstype,String password,int telefonnumer,String firmanavn)
    {
        try
        {

            String query = " insert into users (navn, efternavn, adresse, email, medlemstype,password,telefonnumer,firmanavn)"
                    + " values (?, ?, ?, ?, ?,?,?,?)";


            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setString(1, navn);
            preparedStmt.setString(2, efternavn);
            preparedStmt.setString(3, adresse);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, medlemstype);
            preparedStmt.setString(6, password);
            preparedStmt.setInt(7, telefonnumer);

            preparedStmt.setString(8, firmanavn);
            preparedStmt.execute();
            getConnection().close();
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }



    }

    public boolean checkUsername(String username)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `users` WHERE `username` =?";

        try {
            ps = Database.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {

        }
        return checkUser;
    }


    public boolean checkPassword(String password)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `users` WHERE `password` =?";

        try {
            ps = Database.getConnection().prepareStatement(query);
            ps.setString(1, password);

            rs = ps.executeQuery();

            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {

        }
        return checkUser;
    }

}
