package com.sathya.springbootmvc.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String empName;
 	private String empDOB;
 	private String gender;
 	private double empBasicSalary;
 	private String department;
 	private int experience;
 	private double hra;
 	private double da;
 	private double pf;
 	private double totalSalary;
}
