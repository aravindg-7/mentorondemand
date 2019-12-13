import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class MentorauthguardService implements CanActivate {

  constructor(private authservice:AuthService, private router:Router) { }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.authservice.role == "MENTOR") {
      return true;
    }
    this.router.navigate(["/login"]);
    return false;
  }
}
