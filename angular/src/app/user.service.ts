import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { MentorSkill } from './mentordetails/Mentordetails';
import { Skill } from './mentordetails/Skill';
import { Mentor } from './mentordetails/mentor';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  psuedouser:User;
  constructor(private http: HttpClient) { }

  addUser(newUser:User):Observable<String>{
    // this.userList.push(newUser);
    return this.http.post<String>(environment.baseUrl+"/user-service/users",newUser);
  }

  addmentor(mentor:Mentor):Observable<any>{
    let credentials = btoa(this.psuedouser.username+':'+this.psuedouser.password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials)
    let uname:String=this.psuedouser.username
    return this.http.post<String>(environment.baseUrl+"/user-service/mentor/"+uname,mentor,{headers});
  }

  addskill(mentorskill:MentorSkill):Observable<any>{
    let credentials = btoa(this.psuedouser.username+':'+this.psuedouser.password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials)
    let uname:String=this.psuedouser.username
    return this.http.post<String>(environment.baseUrl+"/user-service/skill/"+uname,mentorskill,{headers});
  }

  getskill():Observable<any>{
    return this.http.get<Skill[]>(environment.baseUrl+"/skill-service/skill")
  }
}
