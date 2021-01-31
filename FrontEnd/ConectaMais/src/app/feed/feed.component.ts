import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Comentario } from '../model/Comentario';
import { Postagem } from '../model/Postagem';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { ComentarioService } from '../service/comentario.service';
import { PostagemService } from '../service/postagem.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]


  comentario: Comentario = new Comentario()
  listaComentarios: Comentario[]

  temaSelecionado: string
  

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel



  
  showMsg1:boolean = false
  showMsg2:boolean = false

  constructor(
    private router: Router,
    private postagemService: PostagemService,
    private comentarioService: ComentarioService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }

    this.findByIdUser()

    this.papelUserIs()
    
    this.getAllPostagens()

    this.getAllComentarios()
  
  }

   papelUserIs(){
    if (this.papelUser == "Instituição") {
      this.showMsg1 = true
      this.showMsg2 = false
    } else {
      this.showMsg1 = false
      this.showMsg2 = true
    }
  }

  findByIdUser(){
    this.authService.getByIdUser(this.idUser).subscribe((resp: Usuario)=>{
      this.usuario = resp
    })
  }

  findByIdPostagem(postagemID: number){
    this.postagemService.getByIdPostagem(postagemID).subscribe((resp: Postagem)=>{
      this.postagem = resp
    })
  }

  temaSelect(event: any){
    this.temaSelecionado = event.target.value
  }

  getAllPostagens(){
    this.postagemService.getAllPostagem().subscribe((resp: Postagem[])=>{
      this.listaPostagens = resp
    })
  }

  getAllComentarios(){
    this.comentarioService.getAllComentario().subscribe((resp: Comentario[])=>{
      this.listaComentarios = resp
    })
  }

  publicar(){
    this.postagem.tema = this.temaSelecionado

    this.usuario.usuarioID = this.idUser
    this.postagem.instituicaoObj = this.usuario

    this.postagemService.postPostagem(this.postagem).subscribe((resp: Postagem)=>{
      this.postagem = resp
      alert('Postagem realizada com sucesso!')
      this.postagem = new Postagem()
      this.getAllPostagens()
    })
  }

  comentar(){
    this.usuario.usuarioID = this.idUser
    
    this.comentario.postagemObj = this.postagem
    this.comentario.usuarioObj = this.usuario

    console.log(this.comentario)
    this.comentarioService.postComentario(this.comentario).subscribe((resp: Comentario)=>{
      this.comentario = resp

      alert('Comentário realizada com sucesso!')
      this.comentario = new Comentario()
      this.getAllPostagens()
      this.getAllComentarios()
    })
  }
}
