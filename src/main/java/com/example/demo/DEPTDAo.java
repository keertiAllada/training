package com.example.demo;


import com.example.demo.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DeptDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean adddept(Dept dept) {
        String insert = "insert into dept values(?,?,?)";
        int result = jdbcTemplate.update(insert, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, dept.getDeptId());
                preparedStatement.setString(2, dept.getDeptName());
                preparedStatement.setInt(3, dept.getStrength());
            }
        });

        if (result > 0)
            return true;

        return false;
    }

    public Collection<Dept> findAll() {


        List<Dept> empList = new ArrayList<>();
        empList = jdbcTemplate.query("select * from dept", new RowMapper<Dept>() {


            @Override
            public Dept mapRow(ResultSet resultSet, int i) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptId(resultSet.getInt("dept_id"));
                dept.setDeptName(resultSet.getString("dept_name"));
                dept.setStrength(resultSet.getInt("salary"));
                return dept;

            }

        });

        return empList;

    }
}


