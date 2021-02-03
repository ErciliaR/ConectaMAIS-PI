import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
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
  senhaUser : string

  confirmarSenha: string
  papelUsuario: string
  nivel: string
  genSelecao: string
  tipoAula: string
  

  showBlock : boolean = false;

  constructor(
    private router: Router,
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    if(environment.token == ''){
      this.router.navigate(['/entrar'])
    }

    this.findByIdUser(this.idUser)

    this.papelUserIs()
  }

  findByIdUser(id: number){
    this.authService.getByIdUser(id).subscribe((resp: Usuario)=>{
      this.usuario = resp
      
    })
  }

  papelUserIs(){
    if (this.papelUser == "Instituição") {
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

  atualizar(){
    this.usuario.papel = this.papelUser

     if (this.usuario.senha != this.confirmarSenha) {
       alert('As senhas não são iguais')
     } else {
       this.authService.cadastrar(this.usuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        alert('Usuário atualizado com sucesso, faça o login novamente.')
        environment.token = ''
        environment.nome = ''
        environment.imagemPerfilURL = ''
        environment.id = 0
        this.router.navigate(['/entrar'])
      })
    }
  }

}
