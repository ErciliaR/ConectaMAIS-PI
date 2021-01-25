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

  showBlock : boolean = false;

  constructor(
    private authService: AuthService,
    private router: Router

  ) { }

  ngOnInit() {
    window.scroll(0,0);

    this.papelUsuario;
  }
  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  papelUser(event: any){
    this.papelUsuario = event.target.value
    

    if(this.papelUsuario == "usuarioInstituicao"){
      this.showBlock = true;    
    } else {
      this.showBlock = false; 
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
