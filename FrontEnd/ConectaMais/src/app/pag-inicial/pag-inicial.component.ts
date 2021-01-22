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

  }
}
