import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CalcSheetComponent } from './calc-sheet/calc-sheet.component';
import { IsSignedInGuard } from '../guards/is-signed-in.guard';

const routes: Routes = [
  {
    path: '',
    component: CalcSheetComponent,
    canActivate: [IsSignedInGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CalculationRoutingModule {}
