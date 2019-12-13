export interface User{

    username:string;
    firstname:string;
    lastname:String ;
    contactnumber:number;
    role:string;
    password:string;
    regCode?:string;
    active?:boolean;
    confirmedSignup?:boolean;
    resetPassword?:boolean;
    resetPasswordDate?:Date;
}
