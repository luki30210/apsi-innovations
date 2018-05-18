import { Routes } from '@angular/router';

import { InnovationListComponent } from './innovation-list/innovation-list.component';
import { InnovationsCreationComponent } from './innovations-creation/innovations-creation.component';
import { InnovationsOverviewComponent } from './innovations-overview/innovations-overview.component';

export const ROUTES: Routes = [
  {
    path: 'creation',
    component: InnovationsCreationComponent
  },
  {
    path: 'overview',
    component: InnovationsOverviewComponent
  },
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
  InnovationListComponent,
  InnovationsCreationComponent,
  InnovationsOverviewComponent
];
