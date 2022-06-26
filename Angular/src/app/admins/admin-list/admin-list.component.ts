import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, NumberValueAccessor } from '@angular/forms';
import { MatAccordion } from '@angular/material/expansion';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { RepDialogComponent } from '../rep-dialog/rep-dialog.component';
import { AddDialogComponent } from '../add-dialog/add-dialog.component';
import { SubmitDialogComponent } from '../submit-dialog/submit-dialog.component';
import { EditDialogComponent } from '../edit-dialog/edit-dialog.component';
import { Process } from 'src/app/interviewers/interviewer-list/interviewer-list.component';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {
  private baseUrl: string = "http://localhost:8080";
  jobs!: Job[];
  jobCategories!: JobCategory[];
  jobPositions!: JobPosition[];
  processes!: Process[];
  jobsShowing = false;
  value!: string;
  filterVal = "1";
  searchVal = "";
  searchControl = new FormControl();
  @ViewChild(MatAccordion) accordion!: MatAccordion;
  constructor(private http: HttpClient,private dialog: MatDialog) { }

  // Initializes different features from backend
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

    this.http.get<Process[]>(this.baseUrl  + '/api/v1/processes/').subscribe(data => {
      this.processes = data;
    }, err => {
    });

  }

  // Searches by filter value
  onSubmit() {
    this.searchVal = this.searchControl.value;
    console.log("filter value: " + this.filterVal);
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
  findProcess(id: string) {
    let process = this.processes.filter(proc => proc.id == id)[0];
    return process.name;
  }

  // Opens rep dialog
  openRepDialog(id: string) {
    const dialogRef = this.dialog.open(RepDialogComponent, {
      width: '400px',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.http.delete(this.baseUrl + '/api/v1/jobs/' + id).subscribe();
        window.location.reload();
      }
    });
  }

  // Opens add job dialog
  openAddDialog() {
    const dialogRef = this.dialog.open(AddDialogComponent, {
      width: '70%',
      data: {
        positions: this.jobPositions,
        categories: this.jobCategories,
        processes: this.processes
      }
    });
    // Takes form result and displays either error message or adds to backend
    dialogRef.afterClosed().subscribe(result => {
      // New Job
      if (result && result.formControl == '1') {
        let newJob = new Job();
        this.http.get(this.baseUrl+'/api/v1/jobs/' + result.idControl).subscribe(data => {
            const dialogRef = this.dialog.open(SubmitDialogComponent, {
              width: '400px',
              data: {
                message: "A job with this ID already exists. To update, go to the job listing below.",
                error: true
              }
            });
            dialogRef.afterClosed().subscribe();
        }, err => {
          this.http.get<JobPosition[]>(this.baseUrl+'/api/v1/jobPositions/name/' + result.positionControl).subscribe(value => {
            this.http.get<JobCategory[]>(this.baseUrl+'/api/v1/jobCategories/name/' + result.categoryControl).subscribe(category => {
              newJob.id = result.idControl;
              newJob.code = result.codeControl;
              newJob.name = result.jobNameControl;
              newJob.description = result.descriptionControl;
              newJob.noOfVacancies = result.vacanciesControl;
              newJob.jobCategoryId = category[0].id;
              newJob.jobPositionId = value[0].id;
              newJob.processId = this.processes.filter(pro => pro.name == result.processControl)[0].id;
              newJob.createdBy = result.creator;
              newJob.createdAt = result.creationDate;
              this.http.put<Job>(this.baseUrl + '/api/v1/jobs', newJob).subscribe((data) => {
                const dialogRef = this.dialog.open(SubmitDialogComponent, {
                  width: '400px',
                  data: {
                    message: "Job successfully created!",
                    error: false
                  }
                });
                dialogRef.afterClosed().subscribe(() => {
                  window.location.reload();
                });
                
              });
            },
            err => {
            })
          },
          err => {
          })
        }) 
      }
      // New Job Position
      if (result && result.formControl == '2') {
        let newPosition = new JobPosition();
        this.http.get<JobPosition[]>(this.baseUrl+'/api/v1/jobPositions/' + result.idControl).subscribe(data => {
          const dialogRef = this.dialog.open(SubmitDialogComponent, {
            width: '400px',
            data: {
              message: "A position with this ID already exists. There is currently no way to update it, so just increment your ID and try again.",
              error: true
            }
          });
          dialogRef.afterClosed().subscribe();        
        }, err => {
            newPosition.id = result.idControl;
            newPosition.code = result.codeControl;
            newPosition.name = result.nameControl;
            newPosition.description = result.descriptionControl;
            this.http.post<JobPosition>(this.baseUrl + '/api/v1/jobPositions', newPosition).subscribe((data) => {
              const dialogRef = this.dialog.open(SubmitDialogComponent, {
                width: '400px',
                data: {
                  message: "Job position successfully created!",
                  error: false
                }
              });
              dialogRef.afterClosed().subscribe(() =>{
                window.location.reload();
              });
            });
        })
      }
      // New Job Category
      if (result && result.formControl == '3') {
        let newCategory = new JobCategory();
        this.http.get<JobCategory[]>(this.baseUrl+'/api/v1/jobPositions/' + result.idControl).subscribe(data => {
          const dialogRef = this.dialog.open(SubmitDialogComponent, {
            width: '400px',
            data: {
              message: "A category with this ID already exists. There is currently no way to update it, so just increment your ID and try again.",
              error: true
            }
          });
          dialogRef.afterClosed().subscribe(() =>{
            window.location.reload();
          });
        }, err => {
            newCategory.id = result.idControl;
            newCategory.code = result.codeControl;
            newCategory.name = result.nameControl;
            newCategory.description = result.descriptionControl;
            this.http.post<JobCategory>(this.baseUrl + '/api/v1/jobCategories', newCategory).subscribe((data) => {
              const dialogRef = this.dialog.open(SubmitDialogComponent, {
                width: '400px',
                data: {
                  message: "Job category successfully created!",
                  error: false
                }
              });
              dialogRef.afterClosed().subscribe(() =>{
                window.location.reload();
              });
              
            });
        })
      }
    })
  }

  // Open Edit Dialog
  openEditDialog(id: string) {
    let job = this.jobs.filter(job => job.id == id)[0];
    const dialogRef = this.dialog.open(EditDialogComponent, {
      width: '70%',
      data: {
        positions: this.jobPositions,
        categories: this.jobCategories,
        job: job,
        processes: this.processes
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      // Edits and puts new Job
      if (result && result.formControl == '1') {
        let newJob = new Job();
        this.http.get(this.baseUrl+'/api/v1/jobs/' + result.idControl).subscribe(data => {
          this.http.get<JobPosition[]>(this.baseUrl+'/api/v1/jobPositions/name/' + result.positionControl).subscribe(value => {
            this.http.get<JobCategory[]>(this.baseUrl+'/api/v1/jobCategories/name/' + result.categoryControl).subscribe(category => {
              newJob.id = result.idControl;
              newJob.code = result.codeControl;
              newJob.name = result.jobNameControl;
              newJob.description = result.descriptionControl;
              newJob.noOfVacancies = result.vacanciesControl;
              newJob.jobCategoryId = category[0].id;
              newJob.jobPositionId = value[0].id;
              newJob.processId = this.processes.filter(pro => pro.name == result.processControl)[0].id;
              newJob.modifiedBy = result.modifier;
              newJob.modifiedAt = result.modifiedDate;
              this.http.put<Job>(this.baseUrl + '/api/v1/jobs', newJob).subscribe((data) => {
                const dialogRef = this.dialog.open(SubmitDialogComponent, {
                  width: '400px',
                  data: {
                    message: "Job successfully updated!",
                    error: false
                  }
                });
                dialogRef.afterClosed().subscribe(() => {
                  window.location.reload();
                });
                
              });
            },
            err => {
            })
          },
          err => {
          })
        }, err => {
        }) 
      }
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
  jobCategoryId!: string;
  processId!: string;
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
