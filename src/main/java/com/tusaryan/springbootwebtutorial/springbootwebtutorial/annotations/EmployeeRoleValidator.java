package com.tusaryan.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

<<<<<<< HEAD
public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {
=======
public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String>{
>>>>>>> a5ce28f (Files added)
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        if (inputRole == null) return false;
        List<String> roles = List.of("USER", "ADMIN");
        return roles.contains(inputRole);
    }
}
