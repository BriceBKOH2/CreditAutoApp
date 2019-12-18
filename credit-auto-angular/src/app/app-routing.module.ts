import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'loginPage',
    pathMatch: 'full'
  },
  {
    path: 'loginPage',
    loadChildren: './authentication/authentication.module#AuthenticationModule'
  },
  {
    path: 'simulPage',
    loadChildren: './calculation/calculation.module#CalculationModule'
  },
  {
    path: 'locationPage',
    loadChildren: './location/location.module#LocationModule'
  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule {}
