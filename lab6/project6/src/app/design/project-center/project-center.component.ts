import {Component, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PROJECTS} from '../mock-project-list';
import {Project, ProjectService} from '../design.service';
import {ProjectListComponent} from '../project-list/project-list.component'

@Component({
  selector: 'app-project-center',
  templateUrl: './project-center.component.html',
  styleUrls: ['./project-center.component.css']
})
export class ProjectCenterComponent {
  @ViewChild(ProjectListComponent) projectListComponent?: ProjectListComponent;
  projectForm: FormGroup | undefined;

  constructor(private fb: FormBuilder, private projectService: ProjectService) {
    this.createForm();
  }

  createForm() {
    this.projectForm = this.fb.group({
      name: ['', Validators.required],
      description: '',
      customer: '',
      price: ['', Validators.required],
      status: 'Новый'
    });
  }

  onSubmit() {
    const newProject: Project = {
      id: 0,
      description: this.projectForm?.value.description,
      customer: this.projectForm?.value.customer,
      price: this.projectForm?.value.price
    };
    this.projectService.addProject(newProject).subscribe(
      (project: Project) => {
        console.log('Project added:', project);
        if (this.projectListComponent){
          this.projectListComponent!.getProjects();
        }
      },
      (error) => {
        console.error(error);
      }
    );
    this.projectForm?.reset();
  }
}
