import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminsRoutingModule } from './admins-routing.module';
import { AdminListComponent } from './admin-list/admin-list.component';

import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatDialogModule } from '@angular/material/dialog';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatTabsModule} from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JobFilterPipe } from './job-filter.pipe';
import { RepDialogComponent } from './rep-dialog/rep-dialog.component';
import { AddDialogComponent } from './add-dialog/add-dialog.component';
import { SubmitDialogComponent } from './submit-dialog/submit-dialog.component';
import { EditDialogComponent } from './edit-dialog/edit-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    AdminsRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatRadioModule,
    MatExpansionModule,
    MatDialogModule,
    MatTabsModule,
    MatSelectModule
  ],
  declarations: [AdminListComponent, JobFilterPipe, RepDialogComponent, AddDialogComponent, SubmitDialogComponent, EditDialogComponent]
})
export class AdminsModule { }
