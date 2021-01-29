import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../model/Postagem';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { PostagemService } from '../service/postagem.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]

  temaSelecionado: string

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel
  
  showMsg1:boolean = false
  showMsg2:boolean = false

  constructor(
    private router: Router,
    private postagemService: PostagemService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }

    this.papelUserIs()
    
    this.getAllPostagens()
  
  }

   papelUserIs(){
    if (this.papelUser == "usuarioInstituicao") {
      this.showMsg1 = true
      this.showMsg2 = false
    } else {
      this.showMsg1 = false
      this.showMsg2 = true
    }
  }

    temaSelect(event: any){
    this.temaSelecionado = event.target.value
  }

  getAllPostagens(){
    this.postagemService.getAllPostagem().subscribe((resp: Postagem[])=>{
      this.listaPostagens = resp
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
}
