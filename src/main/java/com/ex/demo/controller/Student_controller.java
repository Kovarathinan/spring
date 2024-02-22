package com.ex.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.demo.model.Student_model;
import com.ex.demo.service.Student_service;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class Student_controller {

	@Autowired
	private Student_service service;
	
	@PostMapping("/create")
	public Student_model create(@RequestBody Student_model model) {
		return service.creating(model);
	}
	
	@GetMapping("/showall")
	public List<Student_model> show(){
		return service.showing();
	}
	
	@GetMapping("/showbyid/{id}")
	public Student_model showbyid(@PathVariable("id") int id) {
		return service.findingbyid(id);
		
	}
	@PutMapping("/update/{id}")
    public Student_model update(@PathVariable("id") int id, @RequestBody Student_model updatedModel) {
        return service.updating(id, updatedModel);
    }
	
	
	@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean deleted = service.deletingbyid(id);

        if (deleted) {
            return "Student with ID " + id + " deleted successfully.";
        } else {
            return "Student with ID " + id + " not found.";
        }
    }
}
