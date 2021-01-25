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
        if (e.url.includes("/entrar") || e.url.includes("/cadastrar")) {
            this.routeHidden = false;
        } else {
          this.routeHidden = true;
        }
      }
    });

  }

}
