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

  getIdeas(pageNumber: number, ideasPerPage: number, sortBy: string= '', sortDir: string= ''): Observable<Idea[]> {
    let url = this.url + '?page=' + pageNumber + '&size=' + ideasPerPage;
    if (sortBy !== '') { url += '&sort=' + sortBy + ',' + sortDir;
    }
    console.log(url);
    return this.http.get<Idea[]>(url, this.httpOptions);
  }

  getIdeasWithDetails(pageNumber: number, ideasPerPage: number, sortBy: string= '', sortDir: string= ''): Observable<Idea[]> {
    let url = this.url + '/with-details?page=' + pageNumber + '&size=' + ideasPerPage;
    if (sortBy !== '') { url += '&sort=' + sortBy + ',' + sortDir;
    }
    console.log(url);
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

  getMeanRating(idea) {
    const url = this.url + '/' + idea.id + '/rating/mean';
    return this.http.get<number>(url, this.httpOptions);
  }

  getIdea(ideaId) {
    const url = this.url + '/' + ideaId;
    return this.http.get<Idea>(url, this.httpOptions);
  }
}

export { Idea };
