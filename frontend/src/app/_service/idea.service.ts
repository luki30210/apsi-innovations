import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Idea } from '../_model/idea';

@Injectable({
  providedIn: 'root'
})
export class IdeaService {
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  private url = './api/idea';

  constructor(private http: HttpClient) { }

  getIdeas(pageNumber: number, ideasPerPage: number): Observable<Idea[]> {
    const url = this.url + '?p=' + pageNumber + '&l=' + ideasPerPage;
    return this.http.get<Idea[]>(url, this.httpOptions);
  }

  getIdeasCount(): Observable<number> {
    const url = this.url + '/count';
    return this.http.get<number>(url, this.httpOptions);
  }

  createIdea(idea) {
    const data = JSON.stringify(idea);
    console.log(data);
    return this.http.post(this.url, data, this.httpOptions);
  }

  updateIdea(idea) {
    const data = JSON.stringify(idea);
    return this.http.put(this.url + idea.id, data, this.httpOptions);
  }
}

export { Idea };
