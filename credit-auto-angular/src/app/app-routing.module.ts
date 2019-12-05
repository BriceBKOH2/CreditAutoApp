import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'index',
    pathMatch: 'full'
  },
  {
    path: 'index',
    loadChildren: './catalog/catalog.module#CatalogModule'
  }
];

@NgModule({
  declarations: [],
  imports: [CommonModule]
})
export class AppRoutingModule {}
