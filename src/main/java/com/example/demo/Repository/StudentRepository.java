package com.example.demo.Repository;

import com.example.demo.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//we have to extend it since it is a interface
//so as argument we have to specify our enitity class name and the primary keys datatype
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{
}
