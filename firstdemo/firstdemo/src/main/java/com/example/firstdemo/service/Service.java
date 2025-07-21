package com.example.firstdemo.service;

import com.example.firstdemo.dao.Dao;
import com.example.firstdemo.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

Dao daoget;
    public List<Student> getalldata()
    {

        return  daoget.findAll();

    }

    public ResponseEntity<Student> saved(Student stud) {

        try{

            Student ss=daoget.save(stud);
            return new ResponseEntity<>(ss, HttpStatus.OK);
        }
        catch (Exception e)
        {
          Student ss = new Student();
          ss.setName("garbad hai");
            return new ResponseEntity<>(ss,HttpStatus.BAD_REQUEST);
        }

    }

    public String delete(int id) {
        daoget.deleteById(id);
        return "Deleted";
    }

    public String insertdata(Student s) {


        daoget.saveAndFlush(s);
        return "Data inserted";
    }

    public Student getbyid(int id) {
       return daoget.findById(id).orElse(null);



    }

    public String Updatadate(int id,Student s) {
Optional<Student> ex=daoget.findById(id);
if(ex.isPresent())
{

    Student ss=ex.get();
    ss.setName(s.getName());
    ss.setPhone(s.getPhone());

    daoget.save(ss);
    return "Data updated";
}
else {
    return "Not updated or not found";
}


    }
}
