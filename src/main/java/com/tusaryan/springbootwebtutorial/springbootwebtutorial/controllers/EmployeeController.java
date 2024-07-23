package com.tusaryan.springbootwebtutorial.springbootwebtutorial.controllers;

import com.tusaryan.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.tusaryan.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.tusaryan.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
//import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {so
//        return "Secret message : asd$#FGff123";
//    }
//remember it is a bad practice to define repository or entity inside your controller class. Never do this.
// Here  we have done just to show implementation for now.
// So always deal with DTO at the controller layer.

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "")
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }

    @PostMapping()
    public EmployeeDTO  createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee );
    }

    @PutMapping String updateEmployeeById() {
        return "Hello form PUT";
    }

    @DeleteMapping String deleteEmployeeById() {
        return "Hello form DELETE";
    }

    @PatchMapping String patchEmployeeById() {
        return "Hello form PATCH";
    }

}
