import { Component } from '@angular/core';
import { Router, Event, NavigationStart } from '@angular/router';
import { AuthService } from './service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ConectaMais';

  routeShow : boolean = false;

  constructor(
    public router: Router,
    public auth: AuthService  //esta sendo chamado para permitir acesso no app.component.html
    ){    
      
  }

  ngOnInit() {

    this.router.events.subscribe( (e) => {
      if (e instanceof NavigationStart) {
        if (e.url.includes("/entrar") || e.url.includes("/cadastrar") || e.url.includes("/feed") || e.url.includes("/minhas-postagens")) {
            this.routeShow = false;
        } else {
          this.routeShow = true;
        }
      }
    });

  }

}
