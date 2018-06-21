import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { routeComponents, ROUTES } from './app.route';
import { EventClickStopPropagationDirective } from './_shared/event-click-stop-propagation.directive';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';

import { IdeaService } from './_service/idea.service';
import {PagingService} from './_service/PagingService';
import {DialogContentComponent, RatingModalComponent} from './rating-modal/rating-modal.component';
import {MatDialogModule} from '@angular/material';
import { IdeaDetailsComponent } from './idea-details/idea-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    routeComponents,
    RatingModalComponent,
    DialogContentComponent,
    IdeaDetailsComponent,
    EventClickStopPropagationDirective
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    MaterialModule,
    RouterModule.forRoot(ROUTES),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatDialogModule
  ],
  providers: [IdeaService, PagingService],
  bootstrap: [AppComponent],
  entryComponents: [DialogContentComponent]
})
export class AppModule { }
