import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Idea } from '../_model/idea';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const url = './api/idea/';

@Injectable({
  providedIn: 'root'
})
export class IdeaService {
  constructor(private http: HttpClient) { }

  getIdea() {
    return this.http.get<Idea>(url);
  }

  createIdea(idea) {
    const data = JSON.stringify(idea);
    console.log(data);
    return this.http.post(url, data, httpOptions);
  }

  updateIdea(idea) {
    const data = JSON.stringify(idea);
    return this.http.put(url + idea.id, data, httpOptions);
  }
}

export { Idea };
