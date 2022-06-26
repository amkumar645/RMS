import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatAccordion } from '@angular/material/expansion';
import { AuthService } from 'src/app/auth/auth.service';
import { Interview } from 'src/app/interviewers/interviewer-list/interviewer-list.component';
import { ApplyDialogComponent } from '../apply-dialog/apply-dialog.component';
import { Application } from '../info/info.component';
import { SuccessDialogComponent } from '../success-dialog/success-dialog.component';

@Component({
  selector: 'app-find-jobs',
  templateUrl: './find-jobs.component.html',
  styleUrls: ['./find-jobs.component.css']
})
export class FindJobsComponent implements OnInit {
  public baseUrl: string = "http://localhost:8080";
  jobs!: Job[];
  jobCategories!: JobCategory[];
  applications!: Application[];
  jobPositions!: JobPosition[];
  interviews!: Interview[];
  jobsShowing = false;
  value!: string;
  filterVal = "1";
  searchVal = "";
  searchControl = new FormControl();
  @ViewChild(MatAccordion) accordion!: MatAccordion;
  constructor(private http: HttpClient,private dialog: MatDialog,
    private authService: AuthService) { }

  // Initializes features from backend 
  ngOnInit() {
    this.http.get<Job[]>(this.baseUrl  + '/api/v1/jobs/').subscribe(data => {
      this.jobs = data;
      this.jobsShowing = true;
    }, err => {
    });

    this.http.get<JobCategory[]>(this.baseUrl  + '/api/v1/jobCategories/').subscribe(data => {
      this.jobCategories = data;
    }, err => {
    });

    this.http.get<JobPosition[]>(this.baseUrl  + '/api/v1/jobPositions/').subscribe(data => {
      this.jobPositions = data;
    }, err => {
    });
    this.http.get<Application[]>(this.baseUrl  + '/api/v1/applications/').subscribe(data => {
      this.applications = data;
    }, err => {
      this.applications = [];
    });

    this.http.get<Interview[]>(this.baseUrl  + '/api/v1/interviews/').subscribe(data => {
      this.interviews = data;
    }, err => {
      this.interviews = [];
    });
  }

  onSubmit() {
    this.searchVal = this.searchControl.value;
  }

  updateFilter(value: string) {
      this.filterVal = value;
  }

  findJobPosition(id: string) {
    let position = this.jobPositions.filter(position => position.id == id)[0];
    return position.name;
  }

  findJobCategory(id: string) {
    let category = this.jobCategories.filter(cat => cat.id == id)[0];
    return category.name;
  }

  getApplicationDate(id:string) {
    let email = this.authService.getEmail();
    let appId = email + "-" + id;
    let application = this.applications.filter(app => app.id == appId)[0];
    return application.appliedDate;
  }

  applied(id: string) {
    let email = this.authService.getEmail();
    let appId = email + "-" + id;
    let application = this.applications.filter(app => app.id == appId)[0];
    if (application == undefined)
      return false;
    if (application.appliedDate != null)
      return true;
    return false;
  }

  rejected(id: string) {
    let email = this.authService.getEmail();
    let appId = email + "-" + id;
    if (this.interviews.length == 0)
      return true;
    let interview = this.interviews.filter(int => int.id == appId)[0];
    if (interview == undefined)
      return true;
    return false;
  }


  // Opens apply dialog
  openApplyDialog(id: string) {
    let email = this.authService.getEmail();
    let job = this.jobs.filter(job => job.id == id);
    let position = this.jobPositions.filter(pos => pos.id == job[0].jobPositionId);
    this.http.get<Application>(this.baseUrl + '/api/v1/applications/' + email + "-" + job[0].id).subscribe(data => {
      console.log(data);
      const dialogRef = this.dialog.open(ApplyDialogComponent, {
        width: '70%',
        data: {
          job: job,
          position: position,
          application: data
        }
      });
      // Updates/Puts Application 
      dialogRef.afterClosed().subscribe(result => {
        let application = new Application();
        application.id = result.id;
        // If submitted, set applied date, otherwise don't
        if (result.saveControl == 'Submit')
          application.appliedDate = result.applicationDate;
        application.education = result.educationControl;
        application.experience = result.experienceControl;
        application.applicantId = result.applicationIdControl;
        application.jobId = result.jobIdControl;
        application.status = result.statusControl;

        // Puts interview based on application as well
        this.http.put<Application>(this.baseUrl + '/api/v1/applications/', application).subscribe(() => {
          if (application.appliedDate != null) {
            let interview = new Interview();
            let ids = result.id.split("-");
            interview.id = application.id;
            interview.applicationId = application.id;
            interview.jobId = ids[1];
            let job = this.jobs.filter(job => job.id == ids[1]);
            if (job[0].processId)
              interview.processId = job[0].processId;
            this.http.put<Interview>(this.baseUrl + "/api/v1/interviews", interview).subscribe();
          }
          window.location.reload();
        });
      });
    }, err => {
      // Does the same if no application has been filled out before
      const dialogRef = this.dialog.open(ApplyDialogComponent, {
        width: '70%',
        data: {
          job: job,
          position: position,
          application: []
        }
      });
      dialogRef.afterClosed().subscribe(result => {
        let application = new Application();
        application.id = result.id;
        if (result.saveControl == 'Submit')
          application.appliedDate = result.applicationDate;
        application.education = result.educationControl;
        application.experience = result.experienceControl;
        application.applicantId = result.applicationIdControl;
        application.jobId = result.jobIdControl;
        application.status = result.statusControl;
  
        this.http.put<Application>(this.baseUrl + '/api/v1/applications/', application).subscribe(() => {
          if (application.appliedDate != null) {
            let interview = new Interview();
            let ids = result.id.split("-");
            interview.id = application.id;
            interview.applicationId = application.id;
            interview.jobId = ids[1];
            let job = this.jobs.filter(job => job.id == ids[1]);
            if (job[0].processId)
              interview.processId = job[0].processId;
            this.http.put<Interview>(this.baseUrl + "/api/v1/interviews", interview).subscribe();
          }
          window.location.reload();
        });
      });
    });
    
  }

}

export class Job {
  createdAt?: string;
  modifiedAt?: string;
  createdBy?: string;
  modifiedBy?: string;
  id!: string;
  code!: string;
  name!: string;
  description?: string;
  noOfVacancies?: number;
  jobCategoryId?: string;
  processId?: string;
  jobPositionId!: string;
}
export class JobCategory {
  createdAt?: string;
  modifiedAt?: string;
  createdBy?: string;
  modifiedBy?: string;
  id!: string;
  code!: string;
  name!: string;
  description?: string;
}
export class JobPosition {
  createdAt?: string;
  modifiedAt?: string;
  createdBy?: string;
  modifiedBy?: string;
  id!: string;
  code!: string;
  name!: string;
  description?: string;
}

