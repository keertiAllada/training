package com.example.demo;


import com.example.demo.model.Emp;
import com.example.demo.sql.EmpDao;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    EmpDao empDao;

    public Collection<Emp> getAll()
    {
        return empDao.FindAll();

    }

    public  Collection<Emp> findById(Integer id)
    {
        return empDao.FindById(id);

    }
    public  boolean saveemp(Emp emp)
    {
        return empDao.saveEmp(emp);
    }


}
