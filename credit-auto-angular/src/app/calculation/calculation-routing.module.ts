import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CalcSheetComponent } from './calc-sheet/calc-sheet.component';

const routes: Routes = [
  {
    path: 'simulPage',
    component: CalcSheetComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CalculationRoutingModule {}
