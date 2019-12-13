import { Skill } from './Skill';
import { Mentor } from './mentor';

export interface MentorSkill{
    rating:number
    experience:number
    skillId:Skill
    mentorId?:Mentor
}