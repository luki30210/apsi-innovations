import { Routes } from '@angular/router';

import { InnovationsCreationComponent } from './innovations-creation/innovations-creation.component';
import { InnovationsOverviewComponent } from './innovations-overview/innovations-overview.component';
import {IdeaDetailsComponent} from './idea-details/idea-details.component';

export const ROUTES: Routes = [
  {
    path: 'creation',
    pathMatch: 'full',
    component: InnovationsCreationComponent
  },
  {
    path: '',
    pathMatch: 'full',
    component: InnovationsOverviewComponent
  },
  {
    path: 'idea/:id',
    pathMatch: 'full',
    component: IdeaDetailsComponent
  },
  {
    path: '**',
    redirectTo: '/'
  }
];

export const routeComponents = [
  InnovationsCreationComponent,
  InnovationsOverviewComponent,
  IdeaDetailsComponent
];
