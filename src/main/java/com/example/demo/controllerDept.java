package com.example.demo;

import com.example.demo.model.Emp;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DeptController {


    @Autowired
    DeptService deptService;

    @PostMapping("/adddept")
    public boolean addDept(@RequestBody Dept dept)
    {
        return  deptService.adddept(dept);
    }


}
