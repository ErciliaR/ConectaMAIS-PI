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
    elemento1?.classList.toggle("active")
  }

}

