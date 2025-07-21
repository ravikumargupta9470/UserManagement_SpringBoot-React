package com.example.firstdemo.service;


import com.example.firstdemo.dao.Dao;
import com.example.firstdemo.entity.Student;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Service2 {

Dao dao;
    public ResponseEntity<List<Student>> Getall() {

        List<Student> ss = dao.findAll();

        // Always return ResponseEntity, even if list is empty
        return ResponseEntity.ok(ss);
    }


    public ResponseEntity<Student> SaveData(Student s) {

        Student st=dao.save(s);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }
//    public ResponseEntity<Student> GetDataById(int id) {
//
//        Optional<Student> ss=dao.findById(id);
//        if(ss.isPresent())
//        {
//            Student st=ss.get();
//            return new ResponseEntity<>(st,HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
//        }
//    }
    //best method :
//here <?> measn anything can send , so same do in controller

    public ResponseEntity<?> GetDataById(int id) {
        Optional<Student> ss = dao.findById(id);

        if (ss.isPresent()) {
            return new ResponseEntity<>(ss.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> DeleteDataById(int id) {

        Optional<Student>ss=dao.findById(id);
        if(ss.isPresent())
        {

            dao.deleteById(id);

            return  ResponseEntity.ok(ss.get());
        }
        else {
            return new ResponseEntity<>("Data not Found",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> UpdateData(int id, Student ss) {

        Optional<Student>st=dao.findById(id);
        if(st.isPresent())
        {
            Student stud=st.get();
            stud.setName(ss.getName());
            stud.setPhone(ss.getPhone());
         dao.save(stud);

         return ResponseEntity.ok(stud);
        }
        else {
            return new ResponseEntity<>("Data id not found",HttpStatus.BAD_REQUEST);
        }

    }
}
