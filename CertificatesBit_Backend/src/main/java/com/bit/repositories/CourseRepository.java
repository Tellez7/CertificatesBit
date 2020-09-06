package com.bit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bit.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	public Course findById(long id);

	public List<Course> findAll();

}
