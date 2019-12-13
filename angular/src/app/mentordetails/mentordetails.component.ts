import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { MentorSkill } from './Mentordetails';
import { Mentor } from './mentor';

@Component({
  selector: 'app-mentordetails',
  templateUrl: './mentordetails.component.html',
  styleUrls: ['./mentordetails.component.css']
})
export class MentordetailsComponent implements OnInit {

  constructor(private fb:FormBuilder,private router:Router,private userservice:UserService) { }
  signupForm:FormGroup;


  ngOnInit() {this.signupForm=this.fb.group({
    linkedinURL:["",[Validators.required]],
    yearsOfExperience:["",[Validators.required]],
    timeslot:["",[Validators.required]]
    
  });
}
get linkedinURL() {
  return this.signupForm.get('linkedinURL');
}
get yearsOfExperience() {
  return this.signupForm.get('yearsOfExperience');
}
get timeslot() {
  return this.signupForm.get('timeslot');
}

addMentor(mentor:Mentor){
  mentor.url=this.signupForm.value['linkedinURL'];
  mentor.slot=this.signupForm.value['timeslot'];
  mentor.experience=this.signupForm.value['yearsOfExperience'];
  this.userservice.addmentor(mentor).subscribe(data=>{
    alert("Click okay to add Skills");
    this.router.navigate(['addSkill'])
  })

}



}
