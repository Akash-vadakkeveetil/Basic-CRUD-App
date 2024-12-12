package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data//if we use this we dont have to set getters and setters , constructors and all manually
@Table(name = "STUDENT")
//@NoArgsConstructor//instead of creating an empty constructor
//@AllArgsConstructor//instead of creating constructors
public class StudentEntity {

    @Id
    //@Column(name = "ID")
    @GeneratedValue
    // if we give this then it is fine no need even the stratergy thing, if here give statergy it gives error
    private int id;

    private int mark;
    private String name;

    public StudentEntity() {
    }

    public StudentEntity(int id, int mark, String name) {
        this.id = id;
        this.mark = mark;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
