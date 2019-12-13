import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Training } from './search/Training';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { environment } from 'src/environments/environment';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  nowuser:User
  constructor(private http:HttpClient,private authservice:AuthService) { }

  addtraining(training:Training):Observable<any>{
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.http.post<void>(environment.baseUrl+"/training-service/training",training,{headers})
  }
  getuser():Observable<any>{
    let uname:String=this.authservice.userId;
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.http.get<User>(environment.baseUrl+"/training-service/training/"+uname,{headers})
  }
  getTraining():Observable<any> {
    let uname:String=this.authservice.userId;
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.http.get<User>(environment.baseUrl+"/training-service/training/get/"+uname,{headers})
  }

  saveStatus(training:Training):Observable<any> {
    const headers = new HttpHeaders({ Authorization: 'Bearer ' +this.authservice.accessToken });
    return this.http.post<any>(environment.baseUrl+"/training-service/training/status",training,{headers})
  }

  usernow():User{
    this.getuser().subscribe(
      (data)=>{
        this.nowuser = data;
      },
      (error)=>{
        console.log(error);
        
      }
    )
    return this.nowuser
  }
}
