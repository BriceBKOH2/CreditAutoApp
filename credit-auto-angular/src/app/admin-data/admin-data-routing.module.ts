import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { IsSignedInGuard } from '../guards/is-signed-in.guard';

const routes: Routes = [
  {
    path: '',
    component: AdminPageComponent,
    canActivate: [IsSignedInGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminDataRoutingModule {}
