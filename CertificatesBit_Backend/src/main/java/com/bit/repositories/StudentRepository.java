package com.bit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bit.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	public Student findById(long id);

	public List<Student> findAll();
}
