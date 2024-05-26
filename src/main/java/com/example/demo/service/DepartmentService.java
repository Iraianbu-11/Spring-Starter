package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public void deleteDepartment(Long id);

    public void updateDepartment(Long id, Department department);

    public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    public Department getDepartmentByName(String name);
}
