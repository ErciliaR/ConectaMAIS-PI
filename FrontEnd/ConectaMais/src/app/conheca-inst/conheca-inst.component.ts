import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-conheca-inst',
  templateUrl: './conheca-inst.component.html',
  styleUrls: ['./conheca-inst.component.css']
})
export class ConhecaInstComponent implements OnInit {

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
  }

}
