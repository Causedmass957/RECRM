import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from '../models/contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private readonly API_URL = 'http://localhost:9015/contact';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwt');
    return new HttpHeaders({
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json'
    });
  }

  getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(this.API_URL, {
      headers: this.getAuthHeaders()
    });
  }

  getContactById(id: number): Observable<Contact> {
    return this.http.get<Contact>(`${this.API_URL}/${id}`, {
      headers: this.getAuthHeaders()
    });
  }

  addContact(contact: Contact): Observable<string> {
    return this.http.post(`${this.API_URL}/new`, contact, {
      headers: this.getAuthHeaders(),
      responseType: 'text'
    });
  }

  updateContact(id: number, contact: Contact): Observable<string> {
    return this.http.put(`${this.API_URL}/edit/${id}`, contact, {
      headers: this.getAuthHeaders(),
      responseType: 'text'
    });
  }

  deleteContact(id: number): Observable<string> {
    return this.http.delete(`${this.API_URL}/${id}`, {
      headers: this.getAuthHeaders(),
      responseType: 'text'
    });
  }

  getUpcomingBirthdays(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.API_URL}/homepage`, {
      headers: this.getAuthHeaders()
    });
  }

  initMockData(): Observable<string> {
    return this.http.get(`${this.API_URL}/init`, {
      headers: this.getAuthHeaders(),
      responseType: 'text'
    });
  }
}
