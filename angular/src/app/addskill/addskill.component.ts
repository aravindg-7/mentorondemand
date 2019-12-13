import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Skill } from '../mentordetails/Skill';
import { MentorSkill } from '../mentordetails/Mentordetails';

@Component({
  selector: 'app-addskill',
  templateUrl: './addskill.component.html',
  styleUrls: ['./addskill.component.css']
})
export class AddskillComponent implements OnInit {

  constructor(private fb:FormBuilder,private router:Router,private userservice:UserService) { }
  signupForm:FormGroup;
  skillList:Skill[];

  ngOnInit() {
    this.buildsignupForm()
    this.userservice.getskill().subscribe(data=>{
      console.log(data)
      this.skillList=data;
    })
  }

  buildsignupForm(){
    this.signupForm = this.fb.group({
      skill:['',[
        Validators.required
      ]],
      selfRating:['',[
        Validators.required,
        Validators.max(10)]],
      yearsOfExperience: ['', [
        Validators.required]],
    })
  }
  get skill() {
    return this.signupForm.get('skill');
  }
  get selfRating() {
    return this.signupForm.get('selfRating');
  }
  get yearsOfExperience() {
    return this.signupForm.get('yearsOfExperience');
  }

  addSkill(mentorskill:MentorSkill){
    mentorskill.experience=this.signupForm.value['yearsOfExperience']
    mentorskill.rating=this.signupForm.value['selfRating']
    this.skillList.forEach(data =>{
      if(this.signupForm.value['skill']==data.name)
      mentorskill.skillId=data
    })
    this.userservice.addskill(mentorskill).subscribe(data =>{
      this.router.navigate(['login'])
    })
  }
  onclick(mentorskill:MentorSkill){
    mentorskill.experience=this.signupForm.value['yearsOfExperience']
    mentorskill.rating=this.signupForm.value['selfRating']
    this.skillList.forEach(data =>{
      if(this.signupForm.value['skill']==data.name)
      mentorskill.skillId=data
    })
    this.userservice.addskill(mentorskill).subscribe(data =>{
      this.signupForm.reset();
      this.router.navigate(['addSkill'])
    })
  }

}
