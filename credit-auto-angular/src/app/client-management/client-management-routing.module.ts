import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientCreationPageComponent } from './client-creation-page/client-creation-page.component';
import { IsSignedInGuard } from '../guards/is-signed-in.guard';

const routes: Routes = [
  {
    path: '',
    component: ClientCreationPageComponent,
    canActivate: [IsSignedInGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientManagementRoutingModule {}
