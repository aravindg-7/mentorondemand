import { User } from '../user';
import { Mentor } from '../mentordetails/mentor';
import { Skill } from '../mentordetails/Skill';


export interface Training{
    id?:number;
    user:User;
    mentor:Mentor;
    skill:Skill;
    status:string;
	progress:number;
	rating:number;
	startdate:Date;
	enddate:Date;
}