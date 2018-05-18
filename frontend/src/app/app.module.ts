import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { routeComponents, ROUTES } from './app.route';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';

import { IdeaService } from './_service/idea.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    routeComponents
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    MaterialModule,
    RouterModule.forRoot(ROUTES),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [IdeaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
