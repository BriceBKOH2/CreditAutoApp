import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientManagementRoutingModule } from './client-management-routing.module';
import { ClientCreationPageComponent } from './client-creation-page/client-creation-page.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ClientCreationPageComponent],
  imports: [
    CommonModule,
    ClientManagementRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ClientManagementModule { }
