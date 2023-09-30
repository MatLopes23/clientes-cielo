import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CriarClienteComponent } from './criar-cliente/criar-cliente.component';
import { ListarClienteComponent } from './listar-cliente/listar-cliente.component';
import { DetalharClienteComponent } from './detalhar-cliente/detalhar-cliente.component';
import { VerificarAtualizacaoGestorComponent } from './verificar-atualizacao-gestor/verificar-atualizacao-gestor.component';

const routes: Routes = [
  {
    path: 'create',
    component: CriarClienteComponent,
  },
  {
    path: 'list',
    component: ListarClienteComponent,
  },
  { path: 'cliente/:id', component: DetalharClienteComponent },
  { path: 'gestor', component: VerificarAtualizacaoGestorComponent },

  { path: '', redirectTo: 'list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
