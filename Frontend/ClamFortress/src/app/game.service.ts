import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private endpoint = 'http://localhost:8080/game'
  constructor(private http:HttpClient) { }

  getGame(){
    return this.http.get(this.endpoint)
  }
}
