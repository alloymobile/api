package com.conestoga.api.resource;

import com.conestoga.api.persistence.Department;
import com.conestoga.api.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentResource {
    private DepartmentService service;

    public DepartmentResource(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(value = "/departments")
    public List<Department> getAll(){
        return this.service.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getById(@PathVariable Long id){
        return this.service.getById(id);
    }

    @PostMapping(value = "/departments")
    public Department add(@RequestBody Department department){
        return this.service.add(department);
    }
}
