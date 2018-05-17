import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { RouterModule } from '@angular/router';

import { routeComponents, ROUTES } from './app.route';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { InnovationsOverviewComponent } from './innovations-overview/innovations-overview.component';
import { InnovationsCreationComponent } from './innovations-creation/innovations-creation.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {IdeasService} from './innovations-creation/IdeasService';
import {MatInputModule, MatSelectModule, MatChipsModule} from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    InnovationsOverviewComponent,
    InnovationsCreationComponent,
    routeComponents
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    MaterialModule,
    MatInputModule,
    MatSelectModule,
    MatChipsModule,
    RouterModule.forRoot(ROUTES),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [IdeasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
