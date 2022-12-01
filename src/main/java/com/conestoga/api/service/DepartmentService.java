package com.conestoga.api.service;

import com.conestoga.api.persistence.Department;
import com.conestoga.api.persistence.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll(){
        return this.departmentRepository.findAll();
    }

    public Department getById(Long id){
        return this.departmentRepository.findById(id).get();
    }

    public Department add(Department department){
        return this.departmentRepository.save(department);
    }

    public Department update(Long id,Department department){
        Optional<Department> department1 = this.departmentRepository.findById(id);
        if(department1.isPresent()){
            Department dept = department1.get();
            dept.setName(department.getName());
            return this.departmentRepository.save(dept);
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        this.departmentRepository.deleteById(id);
    }
}
