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

<<<<<<< HEAD

=======
>>>>>>> 80f7351cc8c7c82cd63c96ee6164e855ecbbf44f
  usuario: Usuario = new Usuario()
  confirmarSenha: string
  papelUsuario: string
  nivel: string
  genSelecao: string
  tipoAula: string

  showBlock : boolean = false;

  constructor(
    private authService: AuthService,
    private router: Router

  ) { }

  ngOnInit() {
    window.scroll(0,0);

  }

  papelUser(event: any){
    this.papelUsuario = event.target.value
    

    if(this.papelUsuario == "usuarioInstituicao"){
      this.showBlock = true;    
    } else {
      this.showBlock = false; 
    }
  }

  nivelEscolar(event: any){
    this.nivel = event.target.value
  }
  generoSelect(event:any){
    this.genSelecao = event.target.value
  }

  tipoEnsino(event: any){
    this.tipoAula = event.target.value
  }

  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  cadastrar(){
    this.usuario.papel = this.papelUsuario
    this.usuario.escolaridadeMin = this.nivel
    this.usuario.generoSelecao = this.genSelecao
    this.usuario.tipo = this.tipoAula

    if (this.usuario.imagemPerfilURL == ""){
      this.usuario.imagemPerfilURL = "../assests/img/profile.png"
    }

    if(this.usuario.senha != this.confirmarSenha) {
      alert('As senhas devem ser iguais')
    } else {
      this.authService.cadastrar(this.usuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        this.router.navigate(['/entrar'])
        alert('Usuário cadastrado com sucesso')
      })
    }
  }

}
