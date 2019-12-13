import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  formSubmitted: boolean;
  error:string;
  status:boolean=false;
  constructor(private formBuilder:FormBuilder,private route:Router,private userService:UserService) { }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      username : ['',[
        Validators.required,
        this.isUsernameTaken
      ]],
      firstname:['',[
        Validators.required
      ]],
      lastname:['',[
        Validators.required
      ]],
      password:['',[
        Validators.required,Validators.minLength(8)
      ]],
      confirmPassword:['',[
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]],
      role:['',[Validators.required]],
    contactnumber:['',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]],
    })

  }

  get f() { return this.signUpForm.controls; }
  get username() {
    return this.signUpForm.get('username');
  }
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }
  get contactnumber() {
    return this.signUpForm.get('contactnumber');
  }
  get role() {
    return this.signUpForm.get('role')
  }
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
      if (formControl.value === 'admin') {
          return { 'userNameTaken': true };
        } else {
          return null;
        }
      }
   onsubmit(){
    this.formSubmitted = true;

    const newUser:User = { username: this.signUpForm.value['username'], 
                      firstname: this.signUpForm.value['firstname'], 
                      lastname: this.signUpForm.value['lastname'], 
                      password: this.signUpForm.value['password'],
                      contactnumber:this.signUpForm.value['contactnumber'],
                      role:this.signUpForm.value['role']

                     };
                     console.log(newUser)
    
    this.userService.addUser(newUser).subscribe(data => {
        // console.log("new user added: "+data);
        // this.userService.userList.push(newUser);
        // console.log(this.userService.userList);
        this.status=false;
        if(newUser.role=="MENTOR"){
          this.userService.psuedouser=newUser
          window.alert("please add further details")
          this.route.navigate(['mentor'])
        }
        else
        this.route.navigate(['login'])
        // this.userService.psuedouser=data;
    },
    (error)=>{
      
      this.status=true;
      this.error = error.error.message;
        if (error.error.errors != null) {
          this.error = error.error.errors[0];  
        }
    },
    );

  this.signUpForm.reset();
  }

  }
