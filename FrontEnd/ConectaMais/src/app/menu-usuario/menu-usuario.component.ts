import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-menu-usuario',
  templateUrl: './menu-usuario.component.html',
  styleUrls: ['./menu-usuario.component.css']
})
export class MenuUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario()
  idUser = environment.id
  papelUser = environment.papel
  nomeUser = environment.nome
  imagemUser = environment.imagemPerfilURL


  showFeed: boolean = true
  showMyPost: boolean = false
  showMyProfile: boolean = false

  showBtn1:boolean = false

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    window.scroll(0,0)
    
    this.findByIdUser()

    if (this.imagemUser == null || this.imagemUser == ''){
      this.imagemUser = "/assets/img/profile01.png"
    }

    this.papelUserIs()
  
  }

    papelUserIs(){
    if (this.papelUser == "Instituição") {
      this.showBtn1 = true
    } else {
      this.showBtn1 = false
    }
  }

  expandirMenu(){
    let elemento1 = document.querySelector("#sidebar");
    let elemento2 = document.querySelector("#content");

    elemento1?.classList.toggle("active")
    elemento2?.classList.toggle("active")
    

  }

  findByIdUser(){
    this.authService.getByIdUser(this.idUser).subscribe((resp: Usuario)=>{
      this.usuario = resp
    })
  }

  irMinhasPost() {
    this.showFeed = false
    this.showMyPost = true
    this.showMyProfile = false
  }

  irFeed() {
    this.showFeed = true
    this.showMyPost = false
    this.showMyProfile = false
  }

  irMeuPerfil(){
    this.showFeed = false
    this.showMyPost = false
    this.showMyProfile = true
  }

}

