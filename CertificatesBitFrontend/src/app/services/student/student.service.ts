import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Student } from 'src/app/model/student';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  addStudent(name: string, lastName: string, cc: string, bitCode: string, age: number, idCourse: number) {
    const body = new HttpParams().set('id', "0").set('name', name).set('lastname', lastName)
      .set('cc', cc).set('bitCode', bitCode).set('age', age.toString()).set('course', idCourse.toString());
    return this.http.post(environment.urlAddStudent, body).subscribe();
  }

  studentExistsByData(cc: string, bitCode: string) {
    return this.http.get<Student>(environment.urlStudentExistsByData, {
      params: {
        'cc': cc,
        'bitCode': bitCode
      }
    });
  }
}
