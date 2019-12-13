import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { MentordetailsComponent } from './mentordetails/mentordetails.component';
import { AddskillComponent } from './addskill/addskill.component';
import { SearchComponent } from './search/search.component';
import { MentorhomeComponent } from './mentorhome/mentorhome.component';
import { MentorauthguardService } from './mentorauthguard.service';


const routes: Routes = [
  {path: '', redirectTo: 'search', pathMatch: 'full' },
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'mentor',component:MentordetailsComponent},
  {path:'addSkill',component:AddskillComponent},
  {path:'search',component:SearchComponent},
  {path:'home',component:MentorhomeComponent,canActivate:[MentorauthguardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
