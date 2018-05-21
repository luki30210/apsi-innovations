import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import {
  // MatAutocompleteModule,
  MatButtonModule,
  // MatButtonToggleModule,
  // MatCardModule,
  // MatCheckboxModule,
  MatChipsModule,
  // MatDatepickerModule,
  // MatDialogModule,
  // MatExpansionModule,
  // MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  // MatMenuModule,
  // MatNativeDateModule,
  // MatPaginatorModule,
  // MatProgressBarModule,
  // MatProgressSpinnerModule,
  // MatRadioModule,
  // MatRippleModule,
  MatSelectModule,
  // MatSidenavModule,
  // MatSliderModule,
  // MatSlideToggleModule,
  // MatSnackBarModule,
  // MatSortModule,
  // MatTableModule,
  // MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  // MatStepperModule,
} from '@angular/material';

const MODULES = [
  // BrowserAnimationsModule,
  // BrowserModule,
  // FormsModule,
  // MatAutocompleteModule,
  MatButtonModule,
  // MatButtonToggleModule,
  // MatCardModule,
  // MatCheckboxModule,
  MatChipsModule,
  // MatDatepickerModule,
  // MatDialogModule,
  // MatExpansionModule,
  // MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  // MatMenuModule,
  // MatNativeDateModule,
  // MatPaginatorModule,
  // MatProgressBarModule,
  // MatProgressSpinnerModule,
  // MatRadioModule,
  // MatRippleModule,
  MatSelectModule,
  // MatSidenavModule,
  // MatSliderModule,
  // MatSlideToggleModule,
  // MatSnackBarModule,
  // MatSortModule,
  // MatTableModule,
  // MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  // MatStepperModule
];

@NgModule({
  imports: MODULES,
  exports: MODULES,
  declarations: []
})
export class MaterialModule {
}
