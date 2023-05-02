import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PROJECTS} from '../mock-project-list';
import {Project} from '../design.service';

@Component({
  selector: 'app-project-center',
  templateUrl: './project-center.component.html',
  styleUrls: ['./project-center.component.css']
})
export class ProjectCenterComponent {
  projectForm: FormGroup | undefined;

  constructor(private fb: FormBuilder) {
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
      id: PROJECTS.length + 1,
      description: this.projectForm?.value.description,
      customer: this.projectForm?.value.customer,
      price: this.projectForm?.value.price
    };
    PROJECTS.push(newProject);
    this.projectForm?.reset();
  }
}
