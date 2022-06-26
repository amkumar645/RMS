import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { SuccessDialogComponent } from '../success-dialog/success-dialog.component';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  private baseUrl: string = "http://localhost:8080";
  applicantFormGroup: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router,
    private dialog: MatDialog, private authService: AuthService) { }

  // Creates personal info form group
  ngOnInit(): void {
    let email = this.authService.getEmail();
    this.applicantFormGroup = this.formBuilder.group({
      id: ['1'],
      firstNameControl: ['', Validators.required],
      lastNameControl: ['', Validators.required],
      emailControl: [email, [Validators.required, Validators.email]],
      phoneControl: ['', [Validators.required, Validators.pattern("[0-9 ]{10}")]],
      summaryControl: [''],
      documentIds: [''],
    });
    this.http.get<Applicant>(this.baseUrl + "/api/v1/applicants/" + email).subscribe(applicants => {
      let applicant = applicants;
      console.log(applicants);
      this.applicantFormGroup = this.formBuilder.group({
        id: [email],
        firstNameControl: [applicant.firstName, Validators.required],
        lastNameControl: [applicant.lastName, Validators.required],
        emailControl: [email, [Validators.required, Validators.email]],
        phoneControl: [applicant.phone, [Validators.required, Validators.pattern("[0-9 ]{10}")]],
        summaryControl: [applicant.summary],
        documentIds: [applicant.documentIds],
      });
    }, err => {
      this.applicantFormGroup = this.formBuilder.group({
        id: [''],
        firstNameControl: ['', Validators.required],
        lastNameControl: ['', Validators.required],
        emailControl: [email, [Validators.required, Validators.email]],
        phoneControl: ['', [Validators.required, Validators.pattern("[0-9 ]{10}")]],
        summaryControl: [''],
        documentIds: [''],
      });
    })
  }

  // Puts new Applicant and navigates back to applicants page
  onSubmit() {
    let newApplicant = new Applicant();
    newApplicant.id =this.applicantFormGroup.value.emailControl;
    newApplicant.firstName =this.applicantFormGroup.value.firstNameControl;
    newApplicant.lastName =this.applicantFormGroup.value.lastNameControl;
    newApplicant.email =this.applicantFormGroup.value.emailControl;
    newApplicant.phone =this.applicantFormGroup.value.phoneControl;
    newApplicant.summary =this.applicantFormGroup.value.summaryControl;
    newApplicant.documentIds =this.applicantFormGroup.value.documentIds.toString().split(" ");

    this.http.put<Applicant>(this.baseUrl + "/api/v1/applicants", newApplicant).subscribe();

    const dialogRef = this.dialog.open(SuccessDialogComponent, {
      width: '40%',
      data: {
        message: "Personal info successfully updated!"
      }
    });
    dialogRef.afterClosed().subscribe();
    this.router.navigate(['applicants']);
  }
}

export class Applicant {
  id!: string;
  firstName!: string;
  lastName!: string;
  email!: string;
  phone!: string;
  summary?: string;
  documentIds?: string[];
}

export class Application {
  id!: string;
  appliedDate?: string;
  education!: string;
  experience!: string;
  applicantId!: string;
  jobId!: string;
  status!: string[];
}
