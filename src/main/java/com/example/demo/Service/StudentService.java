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


    //get all details
    public List<StudentEntity> getAllDetails(){
        return studentRepository.findAll();
    }

    //fetch data by id
    //we are using here entity itself cause we are returning a row itself , cause it is also an object of student hence we are returning so
    public StudentEntity getAllDetailsById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    //we write logic for updating here
    //the whole json data for update data will come here in the variable student , we are gonna only take the value id from student
    public StudentEntity updateAllDetail(StudentEntity studentEntity){
        StudentEntity updateStudent = studentRepository.findById(studentEntity.getId()).orElse(null);//incase if the id is not present then we sent null
        if(updateStudent != null)
        {
            updateStudent.setMark(studentEntity.getMark());
            updateStudent.setName(studentEntity.getName());
            studentRepository.save(updateStudent);
            return updateStudent;
        }
        return null;
    }

    public boolean deleteStudentById(int id ){
        studentRepository.deleteById(id);//we cant studentEnitity type , cause it will not return that after deletion
        return true;
    }
}
