import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  loginFormGroup: FormGroup = new FormGroup({});
  loggedIn = false;
  adminAccess = false;
  constructor(private router: Router, private formBuilder: FormBuilder,
    private http: HttpClient) { }

  email!: string;
  password!: string;
  baseUrl = "http://localhost:8080/api/v1/login"
  
  // Login form
  ngOnInit() {
    this.loginFormGroup = this.formBuilder.group({
      emailControl: ['', [Validators.required, Validators.email]],
      passwordControl: ['', Validators.required],
    })
    this.http.get<Login[]>(this.baseUrl).subscribe(data => {
      this.loggedIn = true;
      this.email = data[0].id;
      this.password = data[0].password;
      let index = this.email.indexOf('@');
      let website = this.email.substring(index + 1);
      if (website == 'riaadvisory.com')
        this.adminAccess = true;
    }, err => {
      this.loggedIn = false;
    })
    
  }
  
  // Logs in through backend
  login() : void {
    this.email = this.loginFormGroup.value.emailControl;
    this.password = this.loginFormGroup.value.passwordControl;
    let login = new Login();
    login.id = this.email;
    login.password = this.password;
    this.http.put<Login>(this.baseUrl, login).subscribe();
    window.location.reload();
  }

  // Logs out
  logout() {
    this.http.delete(this.baseUrl + "/" + this.email).subscribe();
    window.location.reload();

  }
}
export class Login {
  id!: string;
  password!: string;
}
