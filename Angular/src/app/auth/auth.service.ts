import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './auth.component';

@Injectable()
export class AuthService {
    baseUrl = "http://localhost:8080/api/v1/login";
    email!: string;
    constructor(private http: HttpClient) { }

    getUserData() {
        return this.http.get<Login[]>(this.baseUrl);
    }

    // Checks if you have admin access
    adminAccess(email: string) {
        this.email = email;
        let index = email.indexOf('@');
        let website = email.substring(index + 1);
        if(website == 'riaadvisory.com'){
            return true;
        }
        else {
            return false;
        }
    }

    // Returns email
    getEmail() {
        return this.email;
    }

}