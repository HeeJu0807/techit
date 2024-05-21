package org.example.springjdbc06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public class UserDao {

    @Autowired
    // 쿼리문이 NamedParameterJdbcTemplate 에 맞게 적혀있음
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private Properties sqlqueries;

    public void insertUser(User user) {
        String sql = sqlqueries.getProperty("INSERT_USER");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName());
        params.addValue("email", user.getEmail());
        jdbcTemplate.update(sql, params);
    }
}
