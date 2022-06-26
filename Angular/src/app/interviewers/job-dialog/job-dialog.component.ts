import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Job, JobCategory, JobPosition } from 'src/app/applicants/find-jobs/find-jobs.component';

@Component({
  selector: 'app-job-dialog',
  templateUrl: './job-dialog.component.html',
  styleUrls: ['./job-dialog.component.css']
})
export class JobDialogComponent implements OnInit {
  job!: Job;
  position!: JobPosition
  category!: JobCategory;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.job = this.data.job;
    this.position = this.data.position;
    this.category = this.data.category;
  }

}
