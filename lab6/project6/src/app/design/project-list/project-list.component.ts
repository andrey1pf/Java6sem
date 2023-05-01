import { Component } from '@angular/core';
import { Project } from '../design.service';
import { PROJECTS } from '../mock-project-list';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent {
  projects: Project[] = PROJECTS;

  constructor() {}

  ngOnInit() {
  }
}
