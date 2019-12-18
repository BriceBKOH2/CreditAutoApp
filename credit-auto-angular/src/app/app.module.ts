import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { CalculationModule } from './calculation/calculation.module';
import { NavigationModule } from './navigation/navigation.module';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationModule } from './authentication/authentication.module';
import { ClientManagementModule } from './client-management/client-management.module';
import { LocalstorageService } from './service/localstorage.service';
import { AdminDataModule } from './admin-data/admin-data.module';
import { LocationModule } from './location/location.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CalculationModule,
    NavigationModule,
    LocationModule,
    HttpClientModule,
    AuthenticationModule,
    ClientManagementModule,
    ReactiveFormsModule,
    AdminDataModule
  ],
  providers: [LocalstorageService],
  bootstrap: [AppComponent]
})
export class AppModule {}
