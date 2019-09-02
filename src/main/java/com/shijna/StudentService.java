package com.shijna;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAll();
    StudentEntity findById(int studentId);
    StudentEntity create(StudentEntity studentEntity);
    void delete(StudentEntity studentEntity);
    void deleteById(int studentId);
    StudentEntity update(StudentEntity studentEntity);
}
