import { Component, OnInit } from '@angular/core';
import { CourseService } from 'src/app/services/course/course.service';
import { Course } from 'src/app/model/course';
import { StudentService } from 'src/app/services/student/student.service';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css']
})
export class StudentAddComponent implements OnInit {

  name: string;
  lastName: string;
  cc: string;
  bitCode: string;
  age: number;
  selectedCourse: number;
  courses: Course[];
  constructor(private courseService: CourseService, private studentService: StudentService) { }

  ngOnInit() {
    this.courseService.getAllCourses().subscribe(data => {
      this.courses = data;
    })
  }

  addStudent() {
    if (this.studentService.addStudent(this.name, this.lastName, this.cc, this.bitCode, this.age, this.selectedCourse)) {
      window.alert("Usuario creado!!!");
      window.location.reload();
    } else {
      window.alert("Error al crear usuario!!!");
    }
  }

}
