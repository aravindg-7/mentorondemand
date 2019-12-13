import { User } from '../user';

export interface Mentor{
    url:String
    experience:number
    slot:String
    user?:User
}