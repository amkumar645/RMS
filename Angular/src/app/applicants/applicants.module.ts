import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ApplicantsRoutingModule } from './applicants-routing.module';
import { ApplicantListComponent } from './applicant-list/applicant-list.component';
import { InfoComponent } from './info/info.component';
import { FindJobsComponent } from './find-jobs/find-jobs.component'; 

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
import { JobFilterPipe } from './job-filter.pipe';
import { ApplyDialogComponent } from './apply-dialog/apply-dialog.component';
import { ErrorDialogComponent } from './error-dialog/error-dialog.component';
import { SuccessDialogComponent } from './success-dialog/success-dialog.component';


@NgModule({
  imports: [
    CommonModule,
    ApplicantsRoutingModule,
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
  declarations: [ApplicantListComponent, InfoComponent, FindJobsComponent, JobFilterPipe, ApplyDialogComponent, ErrorDialogComponent, SuccessDialogComponent]
})
export class ApplicantsModule { }
