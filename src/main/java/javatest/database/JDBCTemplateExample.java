package javatest.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javatest.testBeans.User;

public class JDBCTemplateExample {

    JdbcTemplate jdbcTemplate;

    public JDBCTemplateExample() {
        super();
        String url = "jdbc:postgresql://localhost:5432/TestData";
        String schema = "springhibernatedata";
        String username = "usrsrc";
        String password = "tomtom";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
        // dataSource.setSchema(schema);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        JDBCTemplateExample example = new JDBCTemplateExample();
        User user = new User(1, "abc", "abc123");
        // example.insert(user);
        List<User> ls = example.getAllUsers();
        ls.forEach(u -> System.out.println("user :" + u.getUserid() + "," + u.getName() + ", " + u.getPassword()));
    }

    RowMapper<User> userRowMapper = new RowMapper<User>() {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getInt("userid"), rs.getString("name"), rs.getString("address"));
        }
    };

    private List<User> getAllUsers() {
        List<User> ls = new ArrayList<>();
        String selectQuery = "select * from user";
        try {
            ls = jdbcTemplate.query(selectQuery, userRowMapper);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ls;
    }

    private boolean insert(User user) {
        String insertQuery = "INSERT INTO springhibernatedata.user(name, address) VALUES (?, ?)";
        int numb = 0;
        try {
            numb = this.jdbcTemplate.update(insertQuery, user.getName(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println("number of rows inserted : " + numb);
        return false;
    }

}
