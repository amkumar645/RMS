import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { Login } from './auth.component';
import { map,catchError } from 'rxjs/operators' 
import { AuthService } from './auth.service';

@Injectable()
export class ApplicantAuthGuard implements CanActivateChild {
   


    constructor(private router: Router, private http: HttpClient,
        private authService: AuthService) {}

    // Auth Guard for user access to applicant console
    canActivateChild(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> {
        return this.authService.getUserData().pipe(
            map((data)=>{
            if(data && !this.authService.adminAccess(data[0].id)){
                return true;
            }else{
                alert("You cannot access this page without user access!");
                this.router.navigate(['/auth'])
                return false;
            }
        }),
        catchError(err => {
            alert("You cannot access this page without logging in first!");
            this.router.navigate(['/auth']);
            return throwError(err);
        })
        )
        
    }
}