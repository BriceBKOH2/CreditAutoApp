import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientCreationPageComponent } from './client-creation-page/client-creation-page.component';
import { IsSignedInGuard } from '../authentication/guards/is-signed-in.guard';

const routes: Routes = [
  {
    path: 'clientcreationpage',
    component: ClientCreationPageComponent,
    canActivate: [IsSignedInGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientManagementRoutingModule {}
