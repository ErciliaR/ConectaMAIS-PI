import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Comentario } from '../model/Comentario';
import { Postagem } from '../model/Postagem';
import { UserLogin } from '../model/UserLogin';
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
  forumPostagem: Postagem = new Postagem()
  listaPostagens: Postagem[]
  tituloPesquisa: string

  comentario: Comentario = new Comentario()
  listaComentarios: Comentario[]

  postagemComComentario: Comentario[]

  temaSelecionado: string

  userLogin: UserLogin = new UserLogin()
  user: Usuario = new Usuario()

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel

  showMsg1: boolean = false
  showMsg2: boolean = false

  nomeUser: string

  testeP: Postagem = new Postagem()
  testeU: Usuario = new Usuario()

  key = 'data'
  reverse = true

  constructor(
    private router: Router,
    private postagemService: PostagemService,
    private comentarioService: ComentarioService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0, 0)

    if (environment.token == '') {
      this.alertas.showAlertInfo('Antes de começar, faça o login!')
      this.router.navigate(['/entrar'])
    }

    this.papelUserIs()

    this.getAllPostagens()
    this.getAllComentarios()

  }

  papelUserIs() {
    if (this.papelUser == "Instituição") {
      this.showMsg1 = true
      this.showMsg2 = false
    } else {
      this.showMsg1 = false
      this.showMsg2 = true
    }
  }

  findByIdUsuario() {
    this.authService.getByIdUser(this.idUser).subscribe((resp: Usuario) => {
      this.usuario = resp
    })
  }

  findByIdPostagem(postagemID: number) {
    this.postagemService.getByIdPostagem(postagemID).subscribe((resp: Postagem) => {
      this.postagem = resp
    })
  }

  findByIdComentario(comentarioID: number) {
    this.comentarioService.getByIdComentario(comentarioID).subscribe((resp: Comentario) => {
      this.comentario = resp
    })
  }

  findByTituloPostagem() {
    if (this.tituloPesquisa == '' || this.tituloPesquisa == null) {
      this.getAllPostagens()
    } else {
      this.postagemService.getByTituloPostagem(this.tituloPesquisa).subscribe((resp: Postagem[]) => {
        this.listaPostagens = resp
      })
    }
  }

  temaSelect(event: any) {
    this.temaSelecionado = event.target.value
  }

  getAllPostagens() {
    this.postagemService.getAllPostagem().subscribe((resp: Postagem[]) => {
      this.listaPostagens = resp
    })

  }

  getAllComentarios() {
    this.comentarioService.getAllComentario().subscribe((resp: Comentario[]) => {
      this.listaComentarios = resp
    })

  }

  publicar() {
    this.postagem.tema = this.temaSelecionado
    this.usuario.usuarioID = this.idUser
    this.postagem.instituicaoObj = this.usuario
    this.postagemService.postPostagem(this.postagem).subscribe((resp: Postagem) => {
      this.postagem = resp
      this.alertas.showAlertSuccess('Postagem realizada com sucesso!')
      this.postagem = new Postagem()

      let teminha = <HTMLSelectElement>document.getElementById("tema")
      teminha.value = ""

      this.getAllPostagens()
    }, err => {
      alert(`Erro ao inserir a dúvida: ${err.status}`);
    });
  }

  comentar(id: number) {
    this.postagem.postagemID = id
    this.comentario.postagemObj = this.postagem

    this.usuario.usuarioID = this.idUser
    this.comentario.usuarioObj = this.usuario

    this.comentarioService.postComentario(this.comentario).subscribe((resp: Comentario) => {
      this.comentario = resp
      this.alertas.showAlertSuccess('Comentário realizada com sucesso!')
      this.comentario = new Comentario()
      this.getAllPostagens()
    }, err => {
      alert(`Erro ao inserir o comentário: ${err.status}`);
    })
  }

  deletarComentario() {
    this.comentarioService.deleteComentario(this.comentario.comentarioID).subscribe(() => {
     this.alertas.showAlertSuccess('Comentário apagada com sucesso!')
      // this.findByIdUsuario()
      // this.findByIdComentario(this.comentario.comentarioID)
      this.comentario = new Comentario()
      this.getAllPostagens()
    })
  }

  atualizarComentario() {
    this.comentarioService.putComentario(this.comentario).subscribe((resp: Comentario) => {
      this.comentario = resp
      this.alertas.showAlertSuccess('Comentário atualizada com sucesso!')
      // this.findByIdUsuario()
      // this.findByIdComentario(this.comentario.comentarioID)
      this.comentario = new Comentario()
      this.getAllPostagens()
    })

  }


}
