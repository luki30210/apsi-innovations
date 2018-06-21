import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RatingService {
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  private url = './api/idea/1/rating/addRating';

  constructor(private http: HttpClient) { }

  createIdea(rating, text, id) {
    const formatedData = '{"value":' + rating + ',"ideaId":' + id + ',"opinion":"' + text + '"}';
    const data = JSON.parse(formatedData);
    console.log(data);
    return this.http.post(this.url, formatedData, this.httpOptions);
  }


}
