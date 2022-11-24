package com.conestoga.api.service;

import com.conestoga.api.persistence.Department;
import com.conestoga.api.persistence.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAll(){
        return this.repository.findAll();
    }

    public Department getById(Long id){
        return this.repository.findById(id).get();
    }

    public Department add(Department department){
        return this.repository.save(department);
    }



}
