import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AuthService } from 'src/app/auth/auth.service';
import { ErrorDialogComponent } from '../error-dialog/error-dialog.component';
import { Applicant } from '../info/info.component';

@Component({
  selector: 'app-apply-dialog',
  templateUrl: './apply-dialog.component.html',
  styleUrls: ['./apply-dialog.component.css']
})
export class ApplyDialogComponent implements OnInit {
  private baseUrl: string = "http://localhost:8080";
  applicationFormGroup: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private http: HttpClient,
    @Inject(MAT_DIALOG_DATA) public data: any, private authService: AuthService,
    private dialog: MatDialog) { }

  // Apply form group with preset values if available
  ngOnInit(): void {
    console.log(this.data);
    this.applicationFormGroup = this.formBuilder.group({
      id: ['Hi'],
      educationControl: ['', Validators.required],
      experienceControl: ['', Validators.required],
      applicationDate: ['', Validators.required],
      applicantIdControl: [''],
      jobIdControl: [''],
      statusControl: ['Pending'],
      saveControl: ['']
    });
    this.http.get<Applicant>(this.baseUrl + "/api/v1/applicants/" + this.authService.getEmail()).subscribe(applicants => {
      let applicant = applicants;
      let pos = this.data.position[0];
      let job = this.data.job[0];
      let application = this.data.application;
      if (application == [] || application == undefined) {
        this.applicationFormGroup = this.formBuilder.group({
          id: [applicant.id + "-" + job.id],
          educationControl: ['', Validators.required],
          experienceControl: ['', Validators.required],
          applicationDate: ['', Validators.required],
          applicantIdControl: [applicant.id],
          jobIdControl: [pos.id],
          statusControl: ['Pending'],
          saveControl: ['']
        });
      }
      else {
        this.applicationFormGroup = this.formBuilder.group({
          id: [applicant.id + "-" + job.id],
          educationControl: [application.education, Validators.required],
          experienceControl: [application.experience, Validators.required],
          applicationDate: [application.appliedDate, Validators.required],
          applicationIdControl: [applicant.id],
          jobIdControl: [pos.id],
          statusControl: ['Pending'],
          saveControl: ['']
        });
      }
      
    }, err => {
      const dialogRef = this.dialog.open(ErrorDialogComponent, {
        width: '400px',
        data: {}
      });
      dialogRef.afterClosed().subscribe(() => {
        this.dialog.closeAll();
      });
    })
  }

  // Submission of form with save/submit buttons
  onSubmit(save: string) {
    if (save == '1') {
      this.applicationFormGroup.patchValue({
        saveControl: 'Save'
      });
    }
    else {
      this.applicationFormGroup.patchValue({
        saveControl: 'Submit'
      });
    }

    return this.applicationFormGroup.value;
  }


}
