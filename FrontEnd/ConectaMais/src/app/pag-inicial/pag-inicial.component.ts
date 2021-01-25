import { Component, OnInit } from '@angular/core';
import { Scroll } from '@angular/router';

@Component({
  selector: 'app-pag-inicial',
  templateUrl: './pag-inicial.component.html',
  styleUrls: ['./pag-inicial.component.css']
})
export class PagInicialComponent implements OnInit {
 
  constructor() { }

  ngOnInit() { 
   window.scroll(0,0)
  
  window.addEventListener('scroll', function (event) {
    var nav = <HTMLElement>document.querySelector('#navbar-changing');
    event.preventDefault();
    if (window.scrollY <= nav.scrollHeight) {
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
}
