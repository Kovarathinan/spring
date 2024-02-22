package com.ex.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.demo.model.Student_model;
import com.ex.demo.repo.Student_repo;

@Service
public class Student_service {

	@Autowired 
	private Student_repo repo;
	
	public Student_model creating(Student_model model) {
		return repo.save(model);
	}
	
	public List<Student_model> showing(){
	return repo.findAll();	
	}
	
	public Student_model findingbyid(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Student_model updating(int id, Student_model updatedModel) {
		
        Student_model existingStudent = repo.findById(id).orElse(null);
        if (updatedModel.getName() != null) 
            existingStudent.setName(updatedModel.getName());
        
        if (updatedModel.getDepartment() != null) 
            existingStudent.setDepartment(updatedModel.getDepartment());
        
        if (updatedModel.getCgpa() != 0.0) 
            existingStudent.setCgpa(updatedModel.getCgpa());
        
            return repo.save(existingStudent);
            
        
    }
	
	public boolean deletingbyid(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }

        return false;
    }
	
	
	
	
	
	
	
	
	
	
}
