package com.example.demo;


import com.example.demo.model.Emp;
import com.example.demo.sql.Dept;
import com.example.demo.sql.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeptService {

    @Autowired
    DeptDao deptDao;

    public boolean adddept(Dept dept)
    {
        return deptDao.adddept(dept);
    }
    public Collection<Dept> getAll()
    {
        return deptDao.findAll();

    }

}
