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

  user: Usuario = new Usuario
  confirmarPassword: string 
  papelUser: string

  constructor(
    private router: Router,
    private authService: AuthService 
  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }

  confirmarSenha(event: any) {
    this.confirmarPassword = event.target.value
  }

  papelUsuario(event: any){
    this.papelUser = event.target.value
    
    if(this.papelUser == "usuarioInstituicao"){
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
    this.user.papel = this.papelUser

    if(this.user.senha != this.confirmarPassword) {
      alert('A senha e confirmar senha devem ser iguais')
    } else {
      this.authService.cadastrar(this.user).subscribe((resp: Usuario) => {
        this.user = resp
        alert('Usuário cadastrado com sucesso')
      })
    }
  }

}
