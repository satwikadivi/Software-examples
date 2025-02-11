package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.employeemodel.EmployeeModel;
import com.sathya.springbootmvc.entity.EmployeeEntity;

import com.sathya.springbootmvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public void saveEmployeeDetails(EmployeeModel employeeModel)
    {
    	
    	double hra;
    	hra=employeeModel.getEmpBasicSalary()*50/100;
    	
    	double da;
    	da=employeeModel.getEmpBasicSalary()*10/100;
    	
    	double pf;
    	pf=employeeModel.getEmpBasicSalary()*12/100;
    	
    	double totalSalary;
    	totalSalary=employeeModel.getEmpBasicSalary()+hra+da+pf;
    	
    	
    	EmployeeEntity employeeEntity=new EmployeeEntity();
    	employeeEntity.setEmpName(employeeModel.getEmpName());
    	employeeEntity.setEmpDOB(employeeModel.getEmpDOB());
    	employeeEntity.setGender(employeeModel.getGender());
    	employeeEntity.setEmpBasicSalary(employeeModel.getEmpBasicSalary());
    	employeeEntity.setDepartment(employeeModel.getDepartment());
    	employeeEntity.setExperience(employeeModel.getExperience());
    	employeeEntity.setHra(hra);
    	employeeEntity.setDa(da);
    	employeeEntity.setPf(pf);
    	employeeEntity.setTotalSalary(totalSalary);
    	
    	employeeRepository.save(employeeEntity);
    }

	public List<EmployeeEntity> getAllEmployees() 
	{
		List<EmployeeEntity> employees = employeeRepository.findAll();
    	return employees;
	}

	public EmployeeEntity searchById(Long id) 
	{
		Optional<EmployeeEntity> optionalData =employeeRepository.findById(id);
		if(optionalData.isPresent())
		{
			EmployeeEntity employee=optionalData.get();
			return employee;
		}
		else
		{
		    return null;
		}
	}

	public void deleteEmployeeById(Long id)
	{
		employeeRepository.deleteById(id);
		
	}

}
