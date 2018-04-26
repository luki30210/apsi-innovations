import { Routes } from '@angular/router';

import { InnovationListComponent } from './innovation-list/innovation-list.component';

export const ROUTES: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: InnovationListComponent
  },
  {
    path: '**',
    redirectTo: '/'
  }
];

export const routeComponents = [
  InnovationListComponent
];
