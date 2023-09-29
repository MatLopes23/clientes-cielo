import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { AppRoutingModule } from './app-routing.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListarClienteComponent } from './listar-cliente/listar-cliente.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { CriarClienteComponent } from './criar-cliente/criar-cliente.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ExcluirClienteDialogComponent } from './excluir-cliente-dialog/excluir-cliente-dialog.component';

@NgModule({
  declarations: [AppComponent, ListarClienteComponent, CriarClienteComponent, ExcluirClienteDialogComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    CommonModule,
    MatButtonModule,
    MatTableModule,
    MatDialogModule,
    MatCardModule,
    MatIconModule,
    MatTooltipModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule,
    ReactiveFormsModule,

    MatSlideToggleModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
