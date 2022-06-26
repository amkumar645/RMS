import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-feedback-dialog',
  templateUrl: './feedback-dialog.component.html',
  styleUrls: ['./feedback-dialog.component.css']
})
export class FeedbackDialogComponent implements OnInit {
  newFeedbackForm: FormGroup = new FormGroup({});
  private baseUrl: string = "http://localhost:8080";

  
  constructor(private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any, private http: HttpClient) { }

  // Feedback form group
  ngOnInit(): void {
    let interview = this.data.interview;
    this.newFeedbackForm = this.formBuilder.group({
      id: [interview.id],
      dateControl: ['', Validators.required],
      startTimeControl: ['', Validators.required],
      endTimeControl: ['', Validators.required],
      interviewerControl: ['', Validators.required],
      commentsControl: ['', Validators.required],
      notesControl: [''],
      interviewIdControl: [interview.id],
    });
    this.http.get<Feedback>(this.baseUrl + "/api/v1/feedbacks/" + interview.id).subscribe((feedback) => {
      this.newFeedbackForm = this.formBuilder.group({
        id: [feedback.id],
        dateControl: [feedback.date, Validators.required],
        startTimeControl: [feedback.startTime, Validators.required],
        endTimeControl: [feedback.endTime, Validators.required],
        interviewerControl: [feedback.interviewer, Validators.required],
        commentsControl: [feedback.comments, Validators.required],
        notesControl: [feedback.notes],
        interviewIdControl: [feedback.interviewId],
      });
    }, err => {
      this.newFeedbackForm = this.formBuilder.group({
        id: [interview.id],
        dateControl: ['', Validators.required],
        startTimeControl: ['', Validators.required],
        endTimeControl: ['', Validators.required],
        interviewerControl: ['', Validators.required],
        commentsControl: ['', Validators.required],
        notesControl: [''],
        interviewIdControl: [interview.id],
      });
    }
    )
  }

  onSubmit() {
    
  }

}
export class Feedback {
  id!: string;
  date!: string;
  startTime!: string;
  endTime!: string;
  interviewer!: string;
  comments!: string;
  notes?: string;
  interviewId!: string;
}
