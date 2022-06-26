import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-process',
  templateUrl: './add-process.component.html',
  styleUrls: ['./add-process.component.css']
})
export class AddProcessComponent implements OnInit {
  newProcessFormGroup: FormGroup = new FormGroup({});
  newStepFormGroup: FormGroup = new FormGroup({});
  step2 = false;
  step3 = false;
  currentStep = 2;

  constructor(private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  // Add Process/Step Form Groups
  ngOnInit(): void {
    this.newProcessFormGroup = this.formBuilder.group({
      formControl: ['1'],
      nameControl: ['', Validators.required],
      idControl: ['', [Validators.required, this.numValidator]],
      codeControl: ['', Validators.required],
      descriptionControl: [''],
      step1Control: ['', Validators.required],
      step2Control: ['none'],
      step3Control: ['none'],
    });

    this.newStepFormGroup = this.formBuilder.group({
      formControl: ['2'],
      nameControl: ['', Validators.required],
      idControl: ['', [Validators.required, this.numValidator]],
      codeControl: ['', Validators.required],
      descriptionControl: ['']
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

  // Sets max step value at 3
  checkAdd() {
    if (this.currentStep > 3)
      return false;
    return true;
  }

  // Adds step on process form
  onAddStep() {
    if (this.currentStep == 2) {
      this.step2 = true;
      this.currentStep += 1;
    }
    else if (this.currentStep == 3) {
      this.step3 = true;
      this.currentStep += 1;
    }
  }

  // Deletes step on process form 
  onDeleteStep(num: Number) {
    if (num == 2 && this.currentStep == 4) {
      this.step3 = false;
      this.newProcessFormGroup.patchValue({
        step2Control: this.newProcessFormGroup.value.step3Control
      });
      this.currentStep = 3;
    }
    else if (num == 2 && this.currentStep == 3) {
      this.step2 = false;
      this.newProcessFormGroup.patchValue({
        step2Control: ''
      });
      this.currentStep = 2;
    }

    else if (num == 3) {
      this.step3 = false;
      this.newProcessFormGroup.patchValue({
        step3Control: ''
      });
      this.currentStep = 3;
    }
  }

  getControls() {
    return (<FormArray>this.newProcessFormGroup.get('stepControl')).controls;
  }

  onSubmit() {
  }

}
