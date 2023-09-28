import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CriarClienteComponent } from './criar-cliente/criar-cliente.component';
import { ListarClienteComponent } from './listar-cliente/listar-cliente.component';

const routes: Routes = [
  {
    path: 'create',
    component: CriarClienteComponent,
  },
  {
    path: 'list',
    component: ListarClienteComponent,
  },
  { path: '', redirectTo: 'list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
