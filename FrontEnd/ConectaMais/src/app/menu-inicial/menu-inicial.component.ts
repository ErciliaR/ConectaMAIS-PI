import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-inicial',
  templateUrl: './menu-inicial.component.html',
  styleUrls: ['./menu-inicial.component.css']
})
export class MenuInicialComponent implements OnInit {

  constructor(
    private router: Router

  ) { }

  ngOnInit() {
    window.scroll(0,0)

    this.scrollMenu()
  }
  scrollMenu(){
    window.addEventListener('scroll',  (event)=>{
      let nav = <HTMLElement>document.querySelector('#navbar-changing');
      let navScroll = nav.scrollHeight
      
     
      if ( navScroll >  window.scrollY) {
        nav.style.backgroundColor = 'transparent';
      } else {
        nav.style.backgroundColor = '#1B3659';
        nav.style.transition = 'background-color 200ms linear'
      }
    });
    window.addEventListener("hashchange", function () {
      window.scrollTo(window.scrollX, window.scrollY - 100);
    });
  }
    // rotaEntrar() {
    //   this.router.navigate(['/entrar'])
    // }

}
