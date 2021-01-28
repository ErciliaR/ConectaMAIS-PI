import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-usuario',
  templateUrl: './menu-usuario.component.html',
  styleUrls: ['./menu-usuario.component.css']
})
export class MenuUsuarioComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  
  }

  expandirMenu(event: any){
    let elemento1 = document.querySelector("#sidebar");
    let elemento2 = document.querySelector("#content");
    let elemento3 = document.querySelector(".size-changing")
    elemento1?.classList.toggle("active")
    elemento2?.classList.toggle("active")
    
  }

  

}

