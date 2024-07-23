package com.tusaryan.springbootwebtutorial.springbootwebtutorial.services;

import com.tusaryan.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.tusaryan.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.tusaryan.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO  getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

//        to map EmplyeeDTO with EmployeeEntity so that we do not need to use EmployeeEntity directly from controller
//        instead we can use EmployeeDTO. But the below method will be complex
//        if i have lets say 100 entries or more and we'll have to repeat same for other methods
//        so to fix we have use alternative which is model mapper library, there are other alt library   too.
//        below code use to map one entity to other
//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getEmail());

//        ModelMapper mapper = new ModelMapper();
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities  = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
//        to check if user is admin
//        log something
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
}
