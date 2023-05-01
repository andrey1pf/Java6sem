import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectCenterComponent } from './project-center/project-center.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { AppRoutingModule } from './design-routing.module';

@NgModule({
  declarations: [
    ProjectCenterComponent,
    ProjectListComponent,
    ProjectDetailsComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ]
})
export class DesignModule { }
