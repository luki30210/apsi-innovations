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

  rateIdea(rating, text, id) {
    this.url = 'api/idea/' + id + '/rating/addRating';
    console.log(this.url);
    const formatedData = '{"value":' + rating + ',"ideaId":' + id + ',"opinion":"' + text + '"}';
    console.log(formatedData);
    const data = JSON.parse(formatedData);
    console.log(data);
    this.http.post(this.url, formatedData, this.httpOptions).subscribe(result =>
    console.log(result));
  }


}
