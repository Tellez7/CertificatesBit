import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from 'src/app/model/course';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  getAllCourses() {
    return this.http.get<Course[]>(environment.urlGetAllCourses);
  }

  findCourseById(id:number) {
    return this.http.get<Course>(environment.urlGetCourseById, {
      params: {
        'id': id.toString(),
      }
    });
  }
}
