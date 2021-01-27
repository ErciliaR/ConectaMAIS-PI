import { Component } from '@angular/core';
import { Router, Event, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ConectaMais';

  routeShow : boolean = false;

  constructor(
    public router: Router
    ){    
      
  }

  ngOnInit() {

    this.router.events.subscribe( (e) => {
      if (e instanceof NavigationStart) {
        if (e.url.includes("/entrar") || e.url.includes("/cadastrar")) {
            this.routeShow = false;
        } else {
          this.routeShow = true;
        }
      }
    });

  }

}
