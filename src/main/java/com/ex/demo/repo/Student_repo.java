package com.ex.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ex.demo.model.Student_model;

@Repository
public interface Student_repo extends JpaRepository<Student_model, Integer> {

}
