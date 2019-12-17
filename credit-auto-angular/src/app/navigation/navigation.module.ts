import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from '../app-routing.module';

@NgModule({
  declarations: [NavbarComponent],
  exports: [NavbarComponent],
  imports: [AppRoutingModule, CommonModule]
})
export class NavigationModule {}
