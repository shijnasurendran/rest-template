package com.shijna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    ClassClient client;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAll()
    {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentEntity> findById(@PathVariable ("id") int studentId)
    {
        StudentEntity student= service.findById(studentId);
        if(student==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> registering(@RequestBody StudentEntity studentEntity)
    {
        String course=studentEntity.getCourse();
        ClassEntity entity= client.getByCourse(course);
        if(entity!=null)
        {
            return new ResponseEntity<>(service.create(studentEntity), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public void delete(StudentEntity studentEntity)
    {
        service.delete(studentEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ("id") int studentId)
    {
        service.deleteById(studentId);
    }

    @PutMapping
    public ResponseEntity<StudentEntity> update(@RequestBody StudentEntity studentEntity)
    {
        StudentEntity s=service.create(studentEntity);
        return ResponseEntity.status(200).body(s);
        //return new ResponseEntity<>(service.create(studentEntity), HttpStatus.OK);
    }

}
