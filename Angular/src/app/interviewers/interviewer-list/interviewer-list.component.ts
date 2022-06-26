import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SubmitDialogComponent } from 'src/app/admins/submit-dialog/submit-dialog.component';
import { Job, JobCategory, JobPosition } from 'src/app/applicants/find-jobs/find-jobs.component';
import { Applicant, Application } from 'src/app/applicants/info/info.component';
import { SuccessDialogComponent } from 'src/app/applicants/success-dialog/success-dialog.component';
import { AddProcessComponent } from '../add-process/add-process.component';
import { ApplicationDialogComponent } from '../application-dialog/application-dialog.component';
import { Feedback, FeedbackDialogComponent } from '../feedback-dialog/feedback-dialog.component';
import { JobDialogComponent } from '../job-dialog/job-dialog.component';
import { ProcessDialogComponent } from '../process-dialog/process-dialog.component';
import { RejectDialogComponent } from '../reject-dialog/reject-dialog.component';

@Component({
  selector: 'app-interviewer-list',
  templateUrl: './interviewer-list.component.html',
  styleUrls: ['./interviewer-list.component.css']
})
export class InterviewerListComponent implements OnInit {
  public baseUrl: string = "http://localhost:8080";
  jobs!: Job[];
  jobCategories!: JobCategory[];
  applicants!: Applicant[];
  applications!: Application[];
  jobPositions!: JobPosition[];
  interviews!: Interview[];
  steps!: Step[];
  processes!: Process[];

  constructor(private http: HttpClient, private dialog: MatDialog) { }

  // Initializes features from backend
  ngOnInit() {
    this.http.get<Job[]>(this.baseUrl  + '/api/v1/jobs/').subscribe(data => {
      this.jobs = data;
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

    this.http.get<Applicant[]>(this.baseUrl  + '/api/v1/applicants/').subscribe(data => {
      this.applicants = data;
    }, err => {
    });

    this.http.get<Interview[]>(this.baseUrl  + '/api/v1/interviews/').subscribe(data => {
      this.interviews = data;
    }, err => {
    });

    this.http.get<Step[]>(this.baseUrl  + '/api/v1/steps/').subscribe(data => {
      this.steps = data;
    }, err => {
    });

    this.http.get<Process[]>(this.baseUrl  + '/api/v1/processes/').subscribe(data => {
      this.processes = data;
    }, err => {
    });

  }

  getApplicant(interview: Interview) {
    let id = interview.applicationId;
    let application = this.applications.filter(app => app.id == id)[0];
    let appId = application.applicantId;
    let applicant = this.applicants.filter(app => app.id == appId)[0];
    return applicant;
  }

  getApplicantName(interview: Interview) {
    let applicant = this.getApplicant(interview);
    return applicant.firstName + " " + applicant.lastName;
  }

  getJob(interview: Interview) {
    let id = interview.jobId;
    let job = this.jobs.filter(j => j.id == id)[0];
    return job;
  }

  getJobPosition(interview: Interview) {
    let job = this.getJob(interview);
    let id = job.jobPositionId;
    return this.jobPositions.filter(jp => jp.id == id)[0];
  }

  getProcess(interview: Interview) {
    let job = this.getJob(interview);
    let process = this.processes.filter(proc => proc.id == job.processId)[0];
    return process;
  }

  getSteps(interview: Interview) {
    let process = this.getProcess(interview);
    let stepIds = process.stepIds;
    let steps: Step[] = [];
    stepIds.forEach(stepId => {
      let step = this.steps.filter(s => s.id == stepId)[0];
      steps.push(step);
    })
    return steps;
  }

  // Opens dialog for Application Details
  openApplicationDialog(interview: Interview) {
    let id = interview.applicationId;
    let application = this.applications.filter(app => app.id == id)[0];
    let applicant = this.getApplicant(interview);
    const dialogRef = this.dialog.open(ApplicationDialogComponent, {
      width: '70%',
      data: {
        applicant: applicant,
        application: application
      }
    });
    dialogRef.afterClosed().subscribe();
  }

  // Opens dialog for Job Details
  openJobDialog(interview: Interview) {
    let job = this.getJob(interview);
    let position = this.getJobPosition(interview);
    let category = this.jobCategories.filter(cat => cat.id == job.jobCategoryId)[0];
    const dialogRef = this.dialog.open(JobDialogComponent, {
      width: '70%',
      data: {
        job: job,
        position: position,
        category: category
      }
    });
    dialogRef.afterClosed().subscribe();
  }

  // Opens dialog for Process Details
  openProcessDialog(interview: Interview) {
    let process = this.getProcess(interview);
    let steps = this.getSteps(interview);
    const dialogRef = this.dialog.open(ProcessDialogComponent, {
      width: '70%',
      data: {
        process: process,
        steps: steps
      }
    });
    dialogRef.afterClosed().subscribe();
  }

  // Rejects interview
  deleteInterview(id: string) {
    const dialogRef = this.dialog.open(RejectDialogComponent, {
      width: '400px',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.http.delete(this.baseUrl + "/api/v1/interviews/" + id).subscribe();
        window.location.reload();
      }
    });
    
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddProcessComponent, {
      width: '70%',
      data: {
        processes: this.processes,
        steps: this.steps
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result && result.formControl == '1') {
        this.http.get(this.baseUrl+'/api/v1/processes/' + result.idControl).subscribe(data => {
          const dialogRef = this.dialog.open(SubmitDialogComponent, {
            width: '400px',
            data: {
              message: "A process with this ID already exists. Try again with a different id!",
              error: true
            }
          });
          dialogRef.afterClosed().subscribe();
      }, err => {
        let newProcess = new Process();
        newProcess.name = result.nameControl;
        newProcess.id = result.idControl;
        newProcess.code = result.codeControl;
        newProcess.description = result.descriptionControl;
        newProcess.stepIds = [];
        let step1 = this.steps.filter(step => step.name == result.step1Control)[0];
        newProcess.stepIds.push(step1.id);
        if (result.step2Control != "" && result.step2Control != "none") {
          let step2 = this.steps.filter(step => step.name == result.step2Control)[0];
          newProcess.stepIds.push(step2.id);
        }
        if (result.step3Control != "" && result.step3Control != "none") {
          let step3 = this.steps.filter(step => step.name == result.step3Control)[0];
          newProcess.stepIds.push(step3.id);
        }
        this.http.put<Process>(this.baseUrl + '/api/v1/processes', newProcess).subscribe((data) => {
          const dialogRef = this.dialog.open(SubmitDialogComponent, {
            width: '400px',
            data: {
              message: "Process successfully created!",
              error: false
            }
          });
          dialogRef.afterClosed().subscribe(() => {
            window.location.reload();
          });
        });
      }) 
      }



      if (result && result.formControl == '2') {
        this.http.get(this.baseUrl+'/api/v1/steps/' + result.idControl).subscribe(data => {
            const dialogRef = this.dialog.open(SubmitDialogComponent, {
              width: '400px',
              data: {
                message: "A step with this ID already exists. Try again with a new ID!",
                error: true
              }
            });
            dialogRef.afterClosed().subscribe();
        }, err => {
          let newStep = new Step();
          newStep.name = result.nameControl;
          newStep.id = result.idControl;
          newStep.code = result.codeControl;
          newStep.description = result.descriptionControl;
          this.http.put<Step>(this.baseUrl + '/api/v1/steps', newStep).subscribe((data) => {
            const dialogRef = this.dialog.open(SubmitDialogComponent, {
              width: '400px',
              data: {
                message: "Step successfully created!",
                error: false
              }
            });
            dialogRef.afterClosed().subscribe(() => {
              window.location.reload();
            });
          });
        }) 
      }
    });
  }


  openFeedbackDialog(id:string) {
    let interview = this.interviews.filter(int => int.id == id)[0];
    const dialogRef = this.dialog.open(FeedbackDialogComponent, {
      width: '70%',
      data: {
        interview: interview,
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      let newFeedback = new Feedback();
      newFeedback.id = result.id;
      newFeedback.date = result.dateControl;
      newFeedback.startTime = result.startTimeControl;
      newFeedback.endTime = result.endTimeControl;
      newFeedback.interviewer = result.interviewerControl;
      newFeedback.comments = result.commentsControl;
      if (result.notesControl) 
        newFeedback.notes =  result.notesControl;
      newFeedback.interviewId = result.interviewId;
      this.http.put(this.baseUrl + "/api/v1/feedbacks/", newFeedback).subscribe(() => {
      });
      window.location.reload();
    });
  }

}
export class Interview {
  id!: string;
  applicationId!: string;
  processId!: string;
  jobId!: string;
}
export class Process {
  id!: string;
  code!: string;
  name!: string;
  description!: string;
  stepIds!: string[];
}
export class Step {
  id!: string;
  code!: string;
  name!: string;
  description!: string;
}

