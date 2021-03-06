package com.example.demo;
import com.example.demo.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmpDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Collection<Emp> FindAll() {

        List<Emp> empList = new ArrayList<>();
        empList = jdbcTemplate.query("select * from emp", new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setEmpId(resultSet.getInt("emp_id"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setSalary(resultSet.getString("salary"));
                return emp;

            }


        });
        return empList;
    }


    public Collection<Emp> FindById(Integer id) {
        List<Emp> empList = new ArrayList<>();
        empList = jdbcTemplate.query("select * from emp where emp_id=" + id, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setEmpId(resultSet.getInt("emp_id"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setSalary(resultSet.getString("salary"));
                return emp;

            }


        });
        return empList;
    }

    public boolean saveEmp(Emp emp) {
        String insert = "insert into emp values(?,?,?)";
        int result = jdbcTemplate.update(insert, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, emp.getEmpId());
                preparedStatement.setString(2, emp.getEmpName());
                preparedStatement.setString(3, emp.getSalary());
            }
        });

        if (result > 0)
            return true;

        return false;
    }




}
