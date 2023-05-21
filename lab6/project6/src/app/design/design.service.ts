import {Injectable} from '@angular/core';
import {PROJECTS} from "./mock-project-list";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

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

  getProjects(): Project[] {
    return PROJECTS;
  }

  getProject(id: number): Project | undefined {
    return this.getProjects().find(project => project.id === id);
  }

  private apiUrl = 'http://localhost:8080/api/projects';

  constructor(private http: HttpClient) {}

  getAllProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(this.apiUrl);
  }

  getProjectById(id: number): Observable<Project> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Project>(url);
  }

  addProject(project: Project): Observable<Project> {
    return this.http.post<Project>(this.apiUrl, project);
  }

  deleteProject(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}

