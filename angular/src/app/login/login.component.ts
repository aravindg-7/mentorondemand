import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup
  constructor(private formBuild:FormBuilder,private router:Router,private authService:AuthService) { }

  ngOnInit() {

    this.loginForm = this.formBuild.group({
      username: ['',[
        Validators.required
      ]],
      password: ['',[
        Validators.required ,Validators.maxLength(15),
        Validators.minLength(3)
      ]]
    })
  }
  get username(){
    return this.loginForm.get('username');
  }
  get password(){
    return this.loginForm.get('password');
  }
  toSignup() {
    this.router.navigate(['signup'])
  }

}
