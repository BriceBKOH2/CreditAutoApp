import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientCreationPageComponent } from './client-creation-page/client-creation-page.component';


const routes: Routes = [{ path: 'clientcreationpage', component: ClientCreationPageComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientManagementRoutingModule { }
