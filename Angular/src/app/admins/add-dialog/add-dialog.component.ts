import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent implements OnInit {
  newJobFormGroup: FormGroup = new FormGroup({});
  newPositionFormGroup: FormGroup = new FormGroup({});
  newCategoryFormGroup: FormGroup = new FormGroup({});
  constructor(private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  // Creates form groups for add job form
  ngOnInit(): void {
    this.newJobFormGroup = this.formBuilder.group({
      formControl: ['1'],
      positionControl: ['', Validators.required],
      jobNameControl: ['', Validators.required],
      categoryControl: ['', Validators.required],
      idControl: ['', [Validators.required, this.numValidator]],
      codeControl: ['', Validators.required],
      descriptionControl: [''],
      vacanciesControl: ['',this.numValidator],
      processControl: ['',Validators.required],
      creator: [''],
      creationDate: [''],
    });

    this.newPositionFormGroup = this.formBuilder.group({
      formControl: ['2'],
      nameControl: ['', Validators.required],
      idControl: ['', [Validators.required, this.numValidator]],
      codeControl: ['', Validators.required],
      descriptionControl: ['']
    });

    this.newCategoryFormGroup = this.formBuilder.group({
      formControl: ['3'],
      nameControl: ['', Validators.required],
      idControl: ['', [Validators.required, this.numValidator]],
      codeControl: ['', Validators.required],
      descriptionControl: ['']
    });
  }

  // Validates number inputs
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
