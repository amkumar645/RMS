import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { JobPosition } from '../admin-list/admin-list.component';

@Component({
  selector: 'app-edit-dialog',
  templateUrl: './edit-dialog.component.html',
  styleUrls: ['./edit-dialog.component.css']
})
export class EditDialogComponent implements OnInit {
  newJobFormGroup: FormGroup = new FormGroup({});


  constructor(private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  // New Job Form Group with preset values
  ngOnInit(): void {
    let job = this.data.job;
    let position = this.data.positions.filter((position: { id: any; }) => position.id == job.jobPositionId)[0];
    let category = this.data.categories.filter((category: { id: any; }) => category.id == job.jobCategoryId)[0];
    let process = this.data.processes.filter((process: { id: any; }) => process.id == job.processId)[0];

    this.newJobFormGroup = this.formBuilder.group({
      formControl: ['1'],
      positionControl: [position.name, Validators.required],
      jobNameControl: [job.name, Validators.required],
      categoryControl: [category.name,Validators.required],
      idControl: [job.id, [Validators.required, this.numValidator]],
      codeControl: [job.code, Validators.required],
      descriptionControl: [job.description],
      vacanciesControl: [job.noOfVacancies,this.numValidator],
      processControl: [process.name, Validators.required],
      modifier: [''],
      modifiedDate: [''],
    });
  }

  numValidator(control: AbstractControl) {
    if (control == null) {
      return null;
    }
    const num = parseInt(control.value, 10);
    if (num >= 0)
      return null;
    else {
      return { num: {
        min: 0,
      } };
    }
  }

  onSubmit() {
  }
}
