package com.example.demo.Controller;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    //first we have to create an object of the service class
    private StudentService studentService;

    @PostMapping("/addStudent")
    public String postDetails(@RequestBody StudentEntity studentEntity){

        System.out.println("Student entity received: "+ studentEntity);
        //we are gonna access the save details function via the service class
        studentService.saveDetails(studentEntity);
        return "ADDED TO TABLE SUCCESSFULLY";
    }


    @GetMapping("/getStudent")
    public List<StudentEntity> getDetails(){
        return studentService.getAllDetails();
    }
}
