import { Routes } from '@angular/router';
import { Purchases } from './purchases/purchases';

export const routes: Routes = [
    {
        path: 'purchases',
        component: Purchases
    },
    {
        path: '',
        redirectTo: 'purchases',
        pathMatch: 'full'
    },
    {
        path: '**',
        redirectTo: 'purchases'
    }
];
