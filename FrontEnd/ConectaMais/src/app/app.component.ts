import { Component } from '@angular/core';
import { Router, Event, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ConectaMais';

  routeHidden : boolean = false;

  constructor(
    public router: Router
    ){    
  
  
  }

  ngOnInit() {

    this.router.events.subscribe( (e) => {
      if (e instanceof NavigationStart) {
        if (e.url == "" || e.url == "/home" || e.url == "/home#inicio" || e.url == "/home#quemSomos" || 
        e.url == "/home#facaParte" || e.url == "/home#conexoes" || e.url == "/home#rodape" || 
        e.url == "/conheca" || e.url == "/apoie") {
            this.routeHidden = true;
        } 
      }
    });

  }

}
