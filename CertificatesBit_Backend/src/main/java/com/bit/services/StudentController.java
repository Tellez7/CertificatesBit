package com.bit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.entities.Course;
import com.bit.entities.Student;
import com.bit.repositories.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepositoryDAO;

	@RequestMapping("/createStudent")
	public Student save(@RequestParam long id, @RequestParam String name, @RequestParam String lastname,
			@RequestParam String cc, @RequestParam String bitCode, @RequestParam String edad,
			@RequestParam Course course) {
		Student newStudent = new Student();
		newStudent.setId(id);
		newStudent.setName(name);
		newStudent.setLastname(lastname);
		newStudent.setCc(cc);
		newStudent.setBitCode(bitCode);
		newStudent.setEdad(edad);
		newStudent.setCourse(course);
		return studentRepositoryDAO.save(newStudent);
	}

	@RequestMapping("/updateStudent")
	public Student updateStudent(@RequestParam long id, @RequestParam String name, @RequestParam String lastname,
			@RequestParam String cc, @RequestParam String bitCode, @RequestParam String edad,
			@RequestParam Course course) {
		Student studentUpdate = studentRepositoryDAO.findById(id);
		studentUpdate.setName(name);
		studentUpdate.setLastname(lastname);
		studentUpdate.setCc(cc);
		studentUpdate.setBitCode(bitCode);
		studentUpdate.setEdad(edad);
		studentUpdate.setCourse(course);
		return studentRepositoryDAO.save(studentUpdate);
	}

	@RequestMapping("/getAllStudents")
	public List<Student> findAll() {
		return studentRepositoryDAO.findAll();
	}

	@RequestMapping("/deleteStudentById")
	public void deleteById(@RequestParam long id) {
		studentRepositoryDAO.deleteById(id);
	}

	@RequestMapping("/getStudentById")
	public Student findById(@RequestParam long id) {
		return studentRepositoryDAO.findById(id);
	}

	@RequestMapping("/studentExistsById")
	public boolean existsById(@RequestParam Long id) {
		if (studentRepositoryDAO.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
}
