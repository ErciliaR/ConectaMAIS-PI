import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../model/Postagem';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';
import { PostagemService } from '../service/postagem.service';

@Component({
  selector: 'app-minhas-postagens',
  templateUrl: './minhas-postagens.component.html',
  styleUrls: ['./minhas-postagens.component.css']
})
export class MinhasPostagensComponent implements OnInit {

  postagem: Postagem = new Postagem()
  listaPostagens: Postagem[]
  temaSelecionado: string

  usuario: Usuario = new Usuario()
  idUser = environment.id
  

  constructor(
    private router: Router,
    private postagemService: PostagemService,
    private authService: AuthService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    window.scroll(0,0)
    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }
    this.findByIdUser()
  }

  temaSelect(event: any){
    this.temaSelecionado = event.target.value
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

  atualizar(){

  }
  
}
