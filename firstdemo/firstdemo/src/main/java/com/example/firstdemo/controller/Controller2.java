package com.example.firstdemo.controller;

import com.example.firstdemo.entity.Student;
import com.example.firstdemo.service.Service2;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller2 {

 private Service2 serv;

    @GetMapping
    public ResponseEntity<List<Student>> GetAllData()
    {

        return serv.Getall();
    }
    @PostMapping("/insert")
    public ResponseEntity<Student>InsertData(@RequestBody Student s)
    {

        return serv.SaveData(s);
    }

    //in this you have to send request like this : api/by?id=2 ...
//    @GetMapping("/getbyid")
//    public ResponseEntity<?> GetById(@RequestParam int id)
//    {
//        return serv.GetDataById(id);
//
//    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> GetById(@PathVariable int id)
    {
        return serv.GetDataById(id);

    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable(name="id") int userid)
    {
        return serv.DeleteDataById(userid);


    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?>UpdateByID(@PathVariable int id,@RequestBody Student ss)
    {


        return serv.UpdateData(id,ss);
    }



}
