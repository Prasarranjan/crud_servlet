package USERDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MODEL.User;

public class userDao {
    public static Connection getConnection() {

        Connection Con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudweb", "root", "prasar123");
            if (Con != null) {
                System.out.println("database successfully connected");
            } else {
                System.out.println("database connection failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Con;
    }
    public static int saveDetails(User u){
        int result=0;
        Connection con =getConnection();


        try {
            String createUser="insert into details(name,email,country) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(createUser);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getCountry());
            result=ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static List<User> selectUser(){
        ArrayList<User> listitem= new ArrayList<>();
        Connection con = getConnection();
        try {
            String selectUser="select * from details";
            PreparedStatement ps = con.prepareStatement(selectUser);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User User = new User();
                User.setId(rs.getInt("id"));
                User.setName(rs.getString("name"));
                User.setEmail(rs.getString("email"));
                User.setCountry(rs.getString("country"));
                listitem.add(User);
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return listitem;
    }
    public static int deleteUser(int id){
        int result =0;
        Connection con =getConnection();
        try{
            String deleteUser="delete from details where id=?";
            PreparedStatement ps = con.prepareStatement(deleteUser);
            ps.setInt(1,id);
            result =ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static  void updateUser(int id, String name, String email, String country){
        int result =0;
        Connection con = getConnection();
        try{
            String updateUser="update details set name=?,email=?,country=? where id=?";
            PreparedStatement ps =con.prepareStatement(updateUser);
            User User = new User();

        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
    //select User by id
    public static User getUserbyid() {
        Connection con = getConnection();
        User us = null;
        try {
            String selectUserbyID="select * from details where id=?";
            PreparedStatement ps = con.prepareStatement(selectUserbyID);
            User User = new User();
            ps.setString(1, String.valueOf(User.getId()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User Us = new User();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                //User us=new User(name,email,country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }
}
