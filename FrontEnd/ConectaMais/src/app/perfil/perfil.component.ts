import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel

  confirmarSenha: string
  papelUsuario: string
  nivel: string
  genSelecao: string
  tipoAula: string
  flagSenha: boolean

  remainingTextNome: number
  remainingTextEmail: number
  remainingTextDescricao: number
  remainingTextCidade: number
  remainingTextImagem: number
  remainingTextSenha: number
  remainingTextConfSenha: number

  showBlock: boolean = false;

  constructor(
    private router: Router,
    private authService: AuthService,
    private route: ActivatedRoute,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0, 0)

    if (environment.token == '') {
      this.router.navigate(['/entrar'])
    }

    this.findByIdUser(this.idUser)

    this.flagSenha = false
    this.papelUserIs()
  }

  findByIdUser(id: number) {
    this.authService.getByIdUser(id).subscribe((resp: Usuario) => {
      this.usuario = resp

    })
  }

  papelUserIs() {
    if (this.papelUser == "Instituição") {
      this.showBlock = true;
    } else {
      this.showBlock = false;
    }
  }

  nivelEscolar(event: any) {
    this.nivel = event.target.value
  }
  generoSelect(event: any) {
    this.genSelecao = event.target.value
  }

  tipoEnsino(event: any) {
    this.tipoAula = event.target.value
  }

  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
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

  atualizar() {
    this.usuario.papel = this.papelUser

    if (this.flagSenha == false) {
      this.usuario.senha = environment.senha
    }

    this.authService.cadastrar(this.usuario).subscribe((resp: Usuario) => {
      this.usuario = resp
      this.alertas.showAlertSuccess('Usuário atualizado com sucesso, faça o login novamente.')
      environment.token = ''
      environment.nome = ''
      environment.imagemPerfilURL = ''
      environment.id = 0
      this.router.navigate(['/entrar'])
    })

  }

  alterarSenha() {
    if (this.usuario.senha != this.confirmarSenha) {
      this.alertas.showAlertDanger('As senhas não são iguais')
    } else {
      this.flagSenha = true
    }
  }

  deletarPerfil() {
    this.authService.deleteUser(this.idUser).subscribe(() => {
      this.alertas.showAlertSuccess('Perfil apagado com sucesso!')
    this.router.navigate(['/entrar'])
    })
  }

}
