import { Component, OnInit } from '@angular/core';
import { PdfMakeWrapper, Txt } from 'pdfmake-wrapper';
import { StudentService } from 'src/app/services/student/student.service';
import { Course } from 'src/app/model/course';
import { CourseService } from 'src/app/services/course/course.service';

@Component({
  selector: 'app-certificate',
  templateUrl: './certificate.component.html',
  styleUrls: ['./certificate.component.css']
})
export class CertificateComponent implements OnInit {

  cc: string;
  bitCode: string;
  msm: string;
  constructor(private studentService: StudentService, private courseService: CourseService) { }

  ngOnInit() {
    this.msm = "Ingrese sus datos de estudiante";
  }

  generatePDF() {
    this.studentService.studentExistsByData(this.cc, this.bitCode).subscribe(x => {
      if (x) {
        const pdf = new PdfMakeWrapper();
        pdf.add(
          new Txt("El estudiante " + x.name + " " + x.lastname +
            " ha terminado el curso de " + x.course.name + " con exito, con una duracion de " +
            x.course.durationHours + " horas en total").bold().italics().end
        );
        pdf.create().open();
        this.msm = "Ingrese sus datos de estudiante";
        this.bitCode = "";
        this.cc = "";
      } else {
        this.msm = "Estudiante no registrado, verifique los datos ingresados";
      }
    });
  }
}
