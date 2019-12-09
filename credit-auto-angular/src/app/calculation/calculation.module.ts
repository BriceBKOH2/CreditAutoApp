import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CalculationRoutingModule } from './calculation-routing.module';
import { CalcSheetComponent } from './calc-sheet/calc-sheet.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [CalcSheetComponent],
  imports: [
    CommonModule,
    CalculationRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CalculationModule {}
