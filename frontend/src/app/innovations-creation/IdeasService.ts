import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {IdeaInterface} from './ideaInterface';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const createIdea = '/api/idea/';
const apiRoot = 'localhost:8080';

@Injectable()
export class IdeasService {

  constructor(private http: HttpClient) {}

  getIdea() {
    return this.http.get<IdeaInterface>(apiRoot + createIdea);
  }

  createIdea(idea) {
    const data = JSON.stringify(idea);
    console.log(data);
    return this.http.post(apiRoot + createIdea, data, httpOptions);
  }

  updateIdea(idea) {
    const data = JSON.stringify(idea);
    return this.http.put(apiRoot + createIdea + idea.id , data, httpOptions);
  }
}

