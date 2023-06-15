package dao;

import com.playdata.todos.config.JdbcConnection;
import dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void insert(User user){
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into users(username,password,nane)" + "values(?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
