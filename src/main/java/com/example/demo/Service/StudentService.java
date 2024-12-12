package com.example.demo.Service;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    //to access the entity we have to access it via the Student repository only
    @Autowired//for dependency injection
    private StudentRepository studentRepository;//we should follow this naming convention

    //first function for adding to a database
    public StudentEntity saveDetails(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);//to save and access we have to use repo
        //save saves our data in our table
    }


    public List<StudentEntity> getAllDetails(){
        return studentRepository.findAll();
    }
}
