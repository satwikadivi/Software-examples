package com.sathya.springbootmvc.employeemodel;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	
	private String empName;
	private String empDOB;
	private String gender;
	private double empBasicSalary;
	private String department;
	private int experience;

}
