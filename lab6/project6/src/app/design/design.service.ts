import {Injectable} from '@angular/core';
import {PROJECTS} from "./mock-project-list";

export interface Project {
  id: number;
  customer: string;
  description: string;
  price: number;
}

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  constructor() {
  }

  getProjects(): Project[] {
    return PROJECTS;
  }

  getProject(id: number): Project | undefined {
    return this.getProjects().find(project => project.id === id);
  }
}

