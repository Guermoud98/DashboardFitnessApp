import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Importation du module d'animations de Angular
import { MatFormFieldModule } from '@angular/material/form-field'; // Importation du module des champs de formulaire de Angular Material
import { MatInputModule } from '@angular/material/input'; // Importation du module des champs d'entrée de Angular Material
import { MatButtonModule } from '@angular/material/button'; // Importation du module des boutons de Angular Material

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UserTemplateComponent } from './user-template/user-template.component';
import { LoginPageComponent } from './login-page/login-page.component';
import {MatIcon} from "@angular/material/icon";

import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { RegisterPageComponent } from './register-page/register-page.component';


@NgModule({
  declarations: [
    AppComponent,

    UserTemplateComponent,
    LoginPageComponent,
    RegisterPageComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule, // Ajout du module d'animations
    AppRoutingModule,
    MatFormFieldModule, // Ajout du module des champs de formulaire
    MatInputModule, // Ajout du module des champs d'entrée
    MatButtonModule,
    MatIcon,
    // Ajout du module des boutons
  ],
  providers: [], // ici on declare les  services
  bootstrap: [AppComponent]
})
export class AppModule { }
