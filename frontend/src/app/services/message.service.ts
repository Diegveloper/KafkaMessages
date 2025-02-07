import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  sendMessage(data: any): Observable<any>{
    return this.http.post<any>(`${this.apiUrl}/api/messages`,data);
  }
}
