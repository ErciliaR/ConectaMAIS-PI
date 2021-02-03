import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Comentario } from '../model/Comentario';
import { Postagem } from '../model/Postagem';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';
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
  postagemComComentario: Comentario[]
  

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
    private route: ActivatedRoute,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }

    this.findByIdUser()

    this.papelUserIs()
    
    this.getAllPostagens()
  
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
    this.postagemComComentario = []
    this.postagemService.getAllPostagem().subscribe((resp: Postagem[])=>{
      this.listaPostagens = resp
      this.listaPostagens.map((item)=> {
        
        this.comentarioService.getAllComentarioPorPostagem(item.postagemID).subscribe((resp: Comentario[])=>{
         this.postagem = item
         this.postagemComComentario = resp
         console.log(this.postagemComComentario)
        })
        this.postagemComComentario.push(this.comentario)
        this.comentario = new Comentario()
        this.postagem = new Postagem()
      })
      
    })

  }

  // getAllComentariosPorPostagens(postId: number) {
  //   this.comentarioService.getAllComentarioPorPostagem(postId).subscribe((resp: Comentario[])=>{
  //     this.listaMarceloQuer = resp
  //   })
  // }

  publicar(){
    this.postagem.tema = this.temaSelecionado

    this.usuario.usuarioID = this.idUser
    this.postagem.instituicaoObj = this.usuario

    console.log(this.postagem)
    this.postagemService.postPostagem(this.postagem).subscribe((resp: Postagem)=>{
      console.log(this.postagem)
      this.postagem = resp
      this.alertas.showAlertSuccess('Postagem realizada com sucesso!')
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
      console.log(this.comentario)
      this.alertas.showAlertSuccess('Comentário realizada com sucesso!')
      this.comentario = new Comentario()
      this.getAllPostagens()
    })
  }
}
