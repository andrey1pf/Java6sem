import { Component } from '@angular/core';
import { Project, ProjectService } from '../design.service';
import { PROJECTS } from '../mock-project-list';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent {
  projects: Project[] = [];

  constructor(private projectService: ProjectService) {}

  ngOnInit() {
    this.getProjects();
  }

  getProjects(): void {
    this.projectService.getAllProjects().subscribe(
      (projects: Project[]) => {
        this.projects = projects;
        console.log(this.projects);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
