import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CalculationRoutingModule } from './calculation-routing.module';
import { CalcSheetComponent } from './calc-sheet/calc-sheet.component';


@NgModule({
  declarations: [CalcSheetComponent],
  imports: [
    CommonModule,
    CalculationRoutingModule
  ]
})
export class CalculationModule { }
