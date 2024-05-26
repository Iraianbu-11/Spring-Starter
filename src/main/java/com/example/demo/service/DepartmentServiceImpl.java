package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department oldDepartment = departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())) {
            oldDepartment.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())) {
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCount())) {
            oldDepartment.setDepartmentCount(department.getDepartmentCount());
        }

        departmentRepository.save(oldDepartment);
    }


    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(!optionalDepartment.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return optionalDepartment.get();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

}
