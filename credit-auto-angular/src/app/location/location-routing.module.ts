import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocationPageComponent } from './location-page/location-page.component';
import { IsSignedInGuard } from '../guards/is-signed-in.guard';


const routes: Routes = [
{
  path: '',
  component: LocationPageComponent,
  canActivate: [IsSignedInGuard]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LocationRoutingModule { }
