import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MesaService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:9000/api/mesas';

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    
    if (token && token !== 'null' && token !== 'undefined') {
      return new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      });
    }
    
    return new HttpHeaders({
      'Content-Type': 'application/json'
    });
  }

  listarMesas(): Observable<any[]> {
    return this.http.get<any>(this.apiUrl, { headers: this.getHeaders() }).pipe(
      map(data => Array.isArray(data) ? data : (data ? [data] : [])),
      catchError(error => {
        console.error('Error en listarMesas:', error);
        return throwError(() => error);
      })
    );
  }

  crearMesa(mesa: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, mesa, { headers: this.getHeaders() }).pipe(
      catchError(error => {
        console.error('Error al crear mesa:', error);
        return throwError(() => error);
      })
    );
  }
}