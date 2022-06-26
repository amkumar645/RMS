import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatCardModule} from '@angular/material/card';  
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatDialogModule } from '@angular/material/dialog';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatTabsModule} from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { InterviewersRoutingModule } from './interviewers-routing.module';
import { InterviewerListComponent } from './interviewer-list/interviewer-list.component';
import { ApplicationDialogComponent } from './application-dialog/application-dialog.component';
import { JobDialogComponent } from './job-dialog/job-dialog.component';
import { AddProcessComponent } from './add-process/add-process.component';
import { ProcessDialogComponent } from './process-dialog/process-dialog.component';
import { FeedbackDialogComponent } from './feedback-dialog/feedback-dialog.component';
import { RejectDialogComponent } from './reject-dialog/reject-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    InterviewersRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatRadioModule,
    MatExpansionModule,
    MatDialogModule,
    MatTabsModule,
    MatSelectModule
  ],
  declarations: [InterviewerListComponent, ApplicationDialogComponent, JobDialogComponent, AddProcessComponent, ProcessDialogComponent, FeedbackDialogComponent, RejectDialogComponent]
})
export class InterviewersModule { }
