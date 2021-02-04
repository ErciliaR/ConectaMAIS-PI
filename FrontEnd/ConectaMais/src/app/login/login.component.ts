import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { UserLogin } from '../model/UserLogin';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin: UserLogin = new UserLogin()
  value: number

  constructor(
    private auth: AuthService,
    private router: Router,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
  }

  entrar() {
    this.auth.entrar(this.userLogin).subscribe((resp: UserLogin) => {
      this.userLogin = resp

      environment.token = this.userLogin.token
      environment.nome = this.userLogin.nome
      environment.imagemPerfilURL = this.userLogin.imagemPerfilURL
      environment.id = this.userLogin.id
      environment.papel = this.userLogin.papel
      environment.senha = this.userLogin.senha

      this.router.navigate(['/feed/:this.userLogin.id'])

    }, erro => {
      if (erro.status == 500) {
        this.alertas.showAlertDanger('Usuário ou senha está incorreto!')
      }
    })
  }

}
