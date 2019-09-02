package com.shijna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentImplementation implements StudentService{

    @Autowired
    StudentRepository repository;

    public List<StudentEntity> getAll() {
        return (List<StudentEntity>) repository.findAll();
    }

    public StudentEntity findById(int studentId) {
        Optional<StudentEntity> student= repository.findById(studentId);
        if(student.isPresent())
        {
            return student.get();
        }
        return null;
    }

    public StudentEntity create(StudentEntity studentEntity) {
        return repository.save(studentEntity);
    }

    public void delete(StudentEntity studentEntity) {
        repository.delete(studentEntity);
    }

    public void deleteById(int studentId) {
        repository.deleteById(studentId);
    }

    public StudentEntity update(StudentEntity studentEntity) {
        return repository.save(studentEntity);
    }
}
