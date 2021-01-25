import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario()
  confirmarSenha: string
  papelUsuario: string

  constructor(
    private authService: AuthService,
    private router: Router

  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }
  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  papelUser(event: any){
    this.papelUsuario = event.target.value
    
    if(this.papelUsuario == "usuarioInstituicao"){
      for (let i = 0; i < 7; i++){
        document.getElementsByClassName("Instituicao")[i].style.display = 'block';
      }      
    } else {
      for (let i = 0; i < 7; i++){
        document.getElementsByClassName("Instituicao")[i].style.display = 'none';
      } 
    }
  }

  cadastrar(){
    this.usuario.papel = this.papelUsuario

    if(this.usuario.senha != this.confirmarSenha) {
      alert('A senha e confirmar senha devem ser iguais')
    } else {
      this.authService.cadastrar(this.usuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        alert('Usuário cadastrado com sucesso')
      })
    }
  }

}
