import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  msm: string;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.msm = "Ingrese las credenciales";
  }

  login() {
    this.userService.userExistsByData(this.username, this.password).subscribe(x => {
      if (x) {
        if (x.admin == true) {
          this.router.navigateByUrl('/addStudent');
        } else {
          this.router.navigateByUrl('/certificate');
        }
      } else {
        this.msm = "Error al ingresar, verifique las credenciales";
      }
    });
  }

}
