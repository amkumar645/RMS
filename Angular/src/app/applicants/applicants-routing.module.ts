import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplicantListComponent } from './applicant-list/applicant-list.component';
import { FindJobsComponent } from './find-jobs/find-jobs.component';
import { InfoComponent } from './info/info.component';

const routes: Routes = [
  {
    path: 'info',
    component: InfoComponent
  },
  {
    path: 'find',
    component: FindJobsComponent
  },
  {
    path:'',
    component: ApplicantListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ApplicantsRoutingModule { }
