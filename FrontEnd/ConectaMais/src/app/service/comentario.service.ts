import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Comentario } from '../model/Comentario';
import { Postagem } from '../model/Postagem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComentarioService {

  constructor(
    private http: HttpClient
  ) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllComentario(): Observable<Comentario[]>{
    return this.http.get<Comentario[]>('http://localhost:8080/comentario', this.token)
  }

  getAllComentarioPorPostagem(postagemID: number): Observable<Comentario[]>{
    return this.http.get<Comentario[]>(`http://localhost:8080/comentario/comentarioPorPostagem/${postagemID}`, this.token)
  }
  
  postComentario(comentario: Comentario): Observable<Comentario>{
    return this.http.post<Comentario>('http://localhost:8080/comentario', comentario, this.token)
  }

}
