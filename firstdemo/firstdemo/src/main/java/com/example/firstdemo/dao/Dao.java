package com.example.firstdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.firstdemo.entity.Student;

@Repository
public interface Dao extends JpaRepository<Student,Integer> {
}
