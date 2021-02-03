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

  getByIdComentario(comentarioID: number): Observable<Comentario>{
    return this.http.get<Comentario>(`http://localhost:8080/comentario/${comentarioID}`, this.token)
  }

  getAllComentarioPorPostagem(postagemID: number): Observable<Comentario[]>{
    return this.http.get<Comentario[]>(`http://localhost:8080/comentario/comentarioPorPostagem/${postagemID}`, this.token)
  }
  
  postComentario(comentario: Comentario): Observable<Comentario>{
    return this.http.post<Comentario>('http://localhost:8080/comentario', comentario, this.token)
  }

  putComentario(comentario: Comentario):Observable<Comentario>{
    return this.http.put<Comentario>('http://localhost:8080/comentario', comentario, this.token)
  }

  deleteComentario(comentarioID: number){
    return this.http.delete(`http://localhost:8080/comentario/${comentarioID}`, this.token)
  }

}
