package com.tusaryan.springbootwebtutorial.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tusaryan.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name of the Employee cannot be Blank")
    @Size(min = 3, max = 10, message = "Number of characters in name should be the Range : [3, 10]")
    private String name;

    @NotBlank(message = "Email of Employee cannot be blank")
    @Email(message = "Invalid Email")
    private String email;

    @NotNull(message = "Age of Employee cannot be Null")
    @Max(value = 80, message = "Age of Employee cannot be greater than 80")
    @Min(value = 18, message = "Age of Employee cannot be less than 18")
    private Integer age;

    @NotBlank(message = "Role of Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of Employee can not be null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary can be in form of xxxxxx.yy")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "dateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
