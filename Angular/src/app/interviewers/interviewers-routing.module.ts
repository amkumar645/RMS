import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InterviewerListComponent } from './interviewer-list/interviewer-list.component';

const routes: Routes = [
  {
    path:'',
    component: InterviewerListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InterviewersRoutingModule { }
