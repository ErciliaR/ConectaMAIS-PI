import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Comentario } from '../model/Comentario';
import { Postagem } from '../model/Postagem';
import { UserLogin } from '../model/UserLogin';
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
  forumPostagem: Postagem = new Postagem()
  listaPostagens: Postagem[]
  



  comentario: Comentario = new Comentario()
  listaComentarios: Comentario[]

  userLogin: UserLogin = new UserLogin()
  user: Usuario = new Usuario()

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel



  temaSelecionado: string
  nomeUser: string

  testeP:Postagem = new Postagem()
  testeU:Usuario = new Usuario()

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
      alert('Antes de começar, faça o login!')
      this.router.navigate(['/entrar'])
    }

    this.papelUserIs()
    
    this.getAllPostagens()

    this. getAllComentarios()
  
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

  findByIdUser(id: any) {
    console.log(id)
    this.nomeUser = ""
    if(id == {} && id !== null){
      this.nomeUser = this.postagem.instituicaoObj.nome
      console.log(this.nomeUser)
    } else{
      this.authService.getByIdUser(id).subscribe((resp: Usuario)=>{
      this.nomeUser = resp.nome
      console.log(this.nomeUser)
    })
    }    
  }

  findByIdUsuario(){
    this.authService.getByIdUser(this.idUser).subscribe((resp: Usuario)=>{
      this.usuario = resp
    })
  }

  findByIdPostagem(id: number) {
    this.postagemService.getByIdPostagem(id).subscribe((resp: Postagem)=>{
      console.log(resp)
      return resp;
    })
  }

  findByIdComentario(comentarioID: number){
    this.comentarioService.getByIdComentario(comentarioID).subscribe((resp: Comentario)=>{
      this.comentario = resp
    })
  }

  temaSelect(event: any){
    this.temaSelecionado = event.target.value
  }

  getAllPostagens(){
    this.postagemService.getAllPostagem().subscribe((resp: Postagem[]) => {
      this.listaPostagens = resp
      this.findByIdUser
    })

  }

  getAllComentarios(){
    this.comentarioService.getAllComentario().subscribe((resp: Comentario[]) => {
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
      this.temaSelecionado = ""
      this.getAllPostagens()
    }, err => {
      alert(`Erro ao inserir a dúvida: ${err.status}`);
    });
  }

  comentar(id:number){
    this.postagem.postagemID = id
    this.comentario.postagemObj = this.postagem

    this.usuario.usuarioID = this.idUser
    this.comentario.usuarioObj = this.usuario

    this.comentarioService.postComentario(this.comentario).subscribe((resp: Comentario)=>{
      this.comentario = resp
      alert('Comentário realizada com sucesso!')
      this.comentario = new Comentario()
      this.getAllPostagens()
    }, err => {
      alert(`Erro ao inserir o comentário: ${err.status}`);
    })
  }


 deletarComentario(){
    this.comentarioService.deleteComentario(this.comentario.comentarioID).subscribe(()=>{
      alert('Postagem apagada com sucesso!')
      this.findByIdUsuario()
      this.findByIdComentario(this.comentario.comentarioID)
    })
  }

  atualizarComentario(){
    this.comentarioService.putComentario(this.comentario).subscribe((resp: Comentario)=>{
      this.comentario = resp
      alert('Postagem atualizada com sucesso!')
      this.findByIdUsuario()
      this.findByIdComentario(this.comentario.comentarioID)
    })

  }


}
