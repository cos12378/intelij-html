package dao;

import com.playdata.todos.config.JdbcConnection;
import dto.TodoJoinuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    public List<TodoJoinuser> findAll() {
        List<TodoJoinuser> todoJoinUsers = new ArrayList<TodoJoinuser>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select\n" +
                "    t.id,\n" +
                "    t.create_at ,\n" +
                "    t.content,\n" +
                "    t.checked,\n" +
                "    u.name,\n" +
                "    u.id uid\n" +
                "from todos.todos as t\n" +
                "inner join todos.users as u\n" +
                "    on t.user_id = u.id";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                todoJoinUsers.add(
                        new TodoJoinuser(
                                resultSet.getInt("id"),
                                resultSet.getString("content"),
                                resultSet.getString("create_at"),
                                resultSet.getBoolean("checked")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todoJoinUsers;

    }

    public void insert(int uid, String content) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into todos(user_id, content) " +
                "values(?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            //      select * frrom users where id =? "1& 1=1";
            pst.setInt(1, uid);
            pst.setString(2, content);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TodoJoinuser findById(int id) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from todos where id=?";


        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            id = resultSet.getInt("id");
            String user_id = resultSet.getString("user_id");
            String create_at = resultSet.getString("create_at");
            Boolean checked = resultSet.getBoolean("checked");

            return new TodoJoinuser(id, user_id, create_at, checked);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int update(int id, String content) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "update todos set contents =? where id=? ";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, content);
            pst.setInt(2, id);
            return pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
}


