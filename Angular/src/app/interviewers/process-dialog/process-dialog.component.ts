import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Process, Step } from '../interviewer-list/interviewer-list.component';

@Component({
  selector: 'app-process-dialog',
  templateUrl: './process-dialog.component.html',
  styleUrls: ['./process-dialog.component.css']
})
export class ProcessDialogComponent implements OnInit {
  process!: Process;
  steps!: Step[];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.process = this.data.process;
    this.steps = this.data.steps;
  }

}
