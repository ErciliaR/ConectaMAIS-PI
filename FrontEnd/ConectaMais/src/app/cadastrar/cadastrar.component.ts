import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';
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
  nivel: string
  genSelecao: string
  tipoAula: string

  remainingTextNome: number
  remainingTextEmail: number
  remainingTextDescricao: number
  remainingTextCidade: number
  remainingTextImagem: number
  remainingTextSenha: number
  remainingTextConfSenha: number
  

  showBlock : boolean = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private alertas: AlertasService

  ) { }

  ngOnInit() {
    window.scroll(0,0);

  }

  papelUser(event: any){
    this.papelUsuario = event.target.value
    

    if(this.papelUsuario == "Instituição"){
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

  tipoEnsino(event: any) {
    this.tipoAula = event.target.value
  }

  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
    this.remainingTextSenha = 10 - this.confirmarSenha.length
  }

  valueChangeNome() {
    this.remainingTextNome = 20 - this.usuario.nome.length
  }

  valueChangeEmail(){
    this.remainingTextEmail = 255 - this.usuario.email.length
  }

  valueChangeDescricao(){
    this.remainingTextDescricao = 500 - this.usuario.descricao.length
  }

  valueChangeCidade(){
    this.remainingTextCidade = 255 - this.usuario.cidade.length
  }

  valueChangeImagem(){
    this.remainingTextImagem = 500 - this.usuario.imagemPerfilURL.length
  }

  valueChangeConfSenha(){
    this.remainingTextConfSenha = 10 - this.usuario.senha.length
  }

  cadastrar(){
    this.usuario.papel = this.papelUsuario
    this.usuario.escolaridadeMin = this.nivel
    this.usuario.generoSelecao = this.genSelecao
    this.usuario.tipo = this.tipoAula
    
    if(this.usuario.senha != this.confirmarSenha) {
      this.alertas.showAlertDanger('As senhas devem ser iguais')
    } else {
      this.authService.cadastrar(this.usuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        this.router.navigate(['/entrar'])
        this.alertas.showAlertSuccess('Usuário cadastrado com sucesso')
      }, err => {
        this.alertas.showAlertDanger('Verifique se todos os campos obrigatórios* estão preenchidos!');
      })
    }
  }

}
