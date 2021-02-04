import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../model/Postagem';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';
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
  
  key = 'data'
  reverse = true

  constructor(
    private router: Router,
    private postagemService: PostagemService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    window.addEventListener("click", function(event: any) {
    if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
          }
        }
      }
    });

    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }
    
    this.findByIdUser()
  }

  dropdowFunc(){
     let element1 = document.getElementById("myDropdown")
     element1?.classList.toggle("show");
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
    this.postagemService.putPostagem(this.postagem).subscribe((resp: Postagem)=>{
      this.postagem = resp
      console.log(resp)
      this.alertas.showAlertSuccess('Postagem atualizada com sucesso!')
      this.findByIdUser()
      this.findByIdPostagem(this.postagem.postagemID)
    })
  }

  deletar(){
    this.postagemService.deletePostagem(this.postagem.postagemID).subscribe(()=>{
      this.alertas.showAlertSuccess('Postagem apagada com sucesso!')
      this.findByIdUser()
      this.findByIdPostagem(this.postagem.postagemID)
    })
  }
  
}
