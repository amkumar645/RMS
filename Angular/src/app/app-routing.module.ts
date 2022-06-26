import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplicantAuthGuard } from './auth/applicant-auth-guard.service';
import { AuthGuard } from './auth/auth-guard.service';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
    {
        path:'applicants',
        loadChildren:() => import('./applicants/applicants.module').then(m => m.ApplicantsModule),
        canActivateChild: [ApplicantAuthGuard]  
    },
    {
        path:'admins',
        loadChildren:() => import('./admins/admins.module').then(m => m.AdminsModule),
        canActivateChild: [AuthGuard]  
        
    },
    {
        path:'interviewers',
        loadChildren:() => import('./interviewers/interviewers.module').then(m => m.InterviewersModule),
        canActivateChild: [AuthGuard]  
    },
    {
        path:'auth',
        component: AuthComponent
    },
    {
        path: '',
        component: HomeComponent,
        pathMatch: 'full'
    }     
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}