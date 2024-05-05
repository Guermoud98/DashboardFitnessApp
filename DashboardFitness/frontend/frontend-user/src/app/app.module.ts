import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Importation du module d'animations de Angular
import { MatFormFieldModule } from '@angular/material/form-field'; // Importation du module des champs de formulaire de Angular Material
import { MatInputModule } from '@angular/material/input'; // Importation du module des champs d'entrée de Angular Material
import { MatButtonModule } from '@angular/material/button'; // Importation du module des boutons de Angular Material

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { LoginPageComponent } from './login-page/login-page.component';
import {MatIcon} from "@angular/material/icon";

import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { RegisterPageComponent } from './register-page/register-page.component';
import {FormsModule} from "@angular/forms";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {MatCalendar, MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import {MatProgressSpinner} from "@angular/material/progress-spinner";
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormField} from "@angular/material/form-field";
import {MatNativeDateModule} from "@angular/material/core";

import {Component} from '@angular/core';

import {MatCardModule} from '@angular/material/card';
import {provideNativeDateAdapter} from '@angular/material/core';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegisterPageComponent,
    DashboardPageComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule, // Ajout du module d'animations
    AppRoutingModule,
    MatFormFieldModule, // Ajout du module des champs de formulaire
    MatInputModule, // Ajout du module des champs d'entrée
    MatButtonModule,
    MatIcon,
    FormsModule,
    MatOption,
    MatSelect,
    MatCard,
    MatToolbar,
    MatDatepickerModule,
    MatFormField,
    MatNativeDateModule,
    MatInputModule,




    // Ajout du module des boutons
  ],
  providers: [], // ici on declare les  services
  bootstrap: [AppComponent]
})
export class AppModule { }
