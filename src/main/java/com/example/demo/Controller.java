package com.example.demo;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
public class Controller {

    @Autowired
    EmpService empService;

    @GetMapping("/find")
    public Collection<Emp> findAll()
    {
        return empService.getAll();

    }

    @GetMapping("/findbyid")
    public Collection<Emp> findBYId(Integer id)
    {
        return empService.findById(id);
    }

    @PostMapping("/addemp")
    public boolean saveemp(@RequestBody Emp emp)
    {
        return empService.saveemp(emp);
    }

    @PostMapping("/updateemp")
    public List<Emp> update(@RequestParam String empName)
    {
        return empService.updateemp(empName);
    }
}
