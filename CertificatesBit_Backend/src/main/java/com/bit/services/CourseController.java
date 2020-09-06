package com.bit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.entities.Course;
import com.bit.repositories.CourseRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepositoryDAO;

	@RequestMapping("/createCourse")
	public Course save(@RequestParam long id, @RequestParam String name, @RequestParam String durationHours) {
		Course newCourse = new Course();
		newCourse.setId(id);
		newCourse.setName(name);
		newCourse.setDurationHours(durationHours);
		return courseRepositoryDAO.save(newCourse);
	}

	@RequestMapping("/updateCourse")
	public Course updateCourse(@RequestParam long id, @RequestParam String name, @RequestParam String durationHours) {
		Course courseUpdate = courseRepositoryDAO.findById(id);
		courseUpdate.setName(name);
		courseUpdate.setDurationHours(durationHours);
		return courseRepositoryDAO.save(courseUpdate);
	}

	@RequestMapping("/getAllCourses")
	public List<Course> findAll() {
		return courseRepositoryDAO.findAll();
	}

	@RequestMapping("/deleteCourseById")
	public void deleteById(@RequestParam long id) {
		courseRepositoryDAO.deleteById(id);
	}

	@RequestMapping("/getCourseById")
	public Course findById(@RequestParam long id) {
		return courseRepositoryDAO.findById(id);
	}

	@RequestMapping("/courseExistsById")
	public boolean existsById(@RequestParam Long id) {
		if (courseRepositoryDAO.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
}
