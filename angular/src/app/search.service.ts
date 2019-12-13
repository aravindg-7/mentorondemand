import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Skill } from './mentordetails/Skill';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  

  constructor(private http: HttpClient) { }

  getmentorBySkill(skill:Skill):Observable<any> {
    return this.http.post<String>("http://localhost:8089/search-service/search",skill);
  }

}
