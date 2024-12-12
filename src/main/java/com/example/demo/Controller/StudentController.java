package com.example.demo.Controller;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getStudent/{id}")
    public StudentEntity getDetailsById(@PathVariable int id){
        return studentService.getAllDetailsById(id);
    }


    //here we call the logic for updating
    @PostMapping("/updateStudent")
    public StudentEntity updateDetails(@RequestBody StudentEntity studentEntity){

        return studentService.updateAllDetail(studentEntity);
    }


    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        if(studentService.deleteStudentById(id))
            return "Deleted Successfullly";
        else {
            return "Cant Delete";
        }
    }
}
