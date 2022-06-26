import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Applicant, Application } from 'src/app/applicants/info/info.component';

@Component({
  selector: 'app-application-dialog',
  templateUrl: './application-dialog.component.html',
  styleUrls: ['./application-dialog.component.css']
})
export class ApplicationDialogComponent implements OnInit {
  applicant!: Applicant;
  application!: Application;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.applicant = this.data.applicant;
    this.application = this.data.application;
  }

}
