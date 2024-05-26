package com.example.demo.controller;
import com.example.demo.entity.Department;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Value("${welcome.msg}")
    private String msg;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    // To save Department
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Saving department {}", department);
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/irai")
    public String result(){
        return msg;
    }

    // To Get Departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // To Get Department using ID
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    // To Delete Department using ID
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return "Deleted Successfully";
    }

    // To Update Department using ID
    @PutMapping("/departments/{id}")
    public String updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        departmentService.updateDepartment(id,department);
        return "Updated Successfully";
    }

    //User Defined Method
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }

}
