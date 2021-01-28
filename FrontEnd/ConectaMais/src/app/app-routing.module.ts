import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PagInicialComponent } from './pag-inicial/pag-inicial.component';
import { ConhecaInstComponent } from './conheca-inst/conheca-inst.component';
import { ApoieComponent } from './apoie/apoie.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';

import { MenuUsuarioComponent } from './menu-usuario/menu-usuario.component';
import { FeedComponent } from './feed/feed.component';
import { MinhasPostagensComponent } from './minhas-postagens/minhas-postagens.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: PagInicialComponent},
  {path: 'entrar', component: LoginComponent},
  {path: 'conheca', component: ConhecaInstComponent},
  {path: 'apoie', component: ApoieComponent},
  {path: 'cadastrar', component: CadastrarComponent},
  {path: 'feed', component: MenuUsuarioComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
