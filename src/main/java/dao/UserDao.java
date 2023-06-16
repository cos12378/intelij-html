package dao;

import com.playdata.todos.config.JdbcConnection;
import dto.User;
import org.apache.catalina.tribes.tipis.AbstractReplicatedMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
 feautre/login
    List<User> users = new ArrayList<User>();

    public static void insert(User user) {

    public static User me;

    public void insert(User user){
 dev
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into users(username,password,name)" + "values(?,?,?)";


        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean login(String id, String password) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select id, username, name, create_at" + "from user" + "where username=? and password =?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, password);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                users.add(makseUser(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
 feautre/login

     if (users.size() !=0){
            me =users.get(0);
        return true;
        }
 dev
        return false;
    }

    private User makseUser(ResultSet resultSet) {

            Integer id;
            String password, username, name, createAt;
            try {
                id = resultSet.getInt("id");
            } catch (SQLException e) {
                id = null;
            }
            try {
                password = resultSet.getString("password");
            } catch (SQLException e) {
                password = null;
            }
            try {
                username = resultSet.getString("username");
            } catch (SQLException e) {
                username = null;
            }
            try {
                name = resultSet.getString("name");
            } catch (SQLException e) {
                name = null;
            }
            try {
                createAt = resultSet.getString("createAt");
            } catch (SQLException e) {
                createAt = null;
            }
            return new User(id, username, password, name, createAt);
        }
}
