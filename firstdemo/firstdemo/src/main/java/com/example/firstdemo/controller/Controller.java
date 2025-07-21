package com.example.firstdemo.controller;

import com.example.firstdemo.entity.Student;
import com.example.firstdemo.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private Service ser;

// all without status code.
    @GetMapping("/get")
    public List<Student> hello() {
        return ser.getalldata();
    }

    @GetMapping("/all")
    public String hello2() {
        return "hello from server";
    }


    @PostMapping("/del/{id}")
    public String dele(@PathVariable int id)
    {
        return ser.delete(id);
    }

    @PostMapping("/insert")
    public String inser(@RequestBody Student s)
    {

        return ser.insertdata(s);
    }

    @GetMapping("/got/{id}")
    public Student getby(@PathVariable int id)
    {

        return ser.getbyid(id);


    }

    @PostMapping("/update/{id}")
    public String Update(@PathVariable int id,@RequestBody Student st)
    {
        return ser.Updatadate(id,st);

    }

    //Now RestApis with Status code




}
