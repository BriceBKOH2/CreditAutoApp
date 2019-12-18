import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminDataRoutingModule } from './admin-data-routing.module';
import { AdminPageComponent } from './admin-page/admin-page.component';


@NgModule({
  declarations: [AdminPageComponent],
  imports: [
    CommonModule,
    AdminDataRoutingModule
  ]
})
export class AdminDataModule { }
