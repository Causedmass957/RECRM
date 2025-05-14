import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Memo } from '../models/memo.model';

@Injectable({
  providedIn: 'root'
})
export class MemoService {

  private baseUrl = 'http://localhost:9015/memo';

  constructor(private http: HttpClient) {}

  getMemo(id: number): Observable<Memo> {
    return this.http.get<Memo>(`${this.baseUrl}/${id}`);
  }

  getAllMemos(username: string): Observable<Memo[]> {
    return this.http.get<Memo[]>(`${this.baseUrl}/all/${username}`);
  }

  getMemosNoGroup(username: string): Observable<Memo[]> {
    return this.http.get<Memo[]>(`${this.baseUrl}/nogroup/${username}`);
  }

  getMemosInGroup(groupId: number): Observable<Memo[]> {
    return this.http.get<Memo[]>(`${this.baseUrl}/group/${groupId}`);
  }

  addMemo(username: string, memo: Memo): Observable<any> {
    return this.http.post(`${this.baseUrl}/${username}`, memo, { responseType: 'text' });
  }

  editMemo(username: string, id: number, memo: Memo): Observable<any> {
    return this.http.put(`${this.baseUrl}/edit/memo/${username}/${id}`, memo, { responseType: 'text' });
  }

  deleteMemo(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
