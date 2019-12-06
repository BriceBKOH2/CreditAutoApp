import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { Observable } from 'rxjs';
import { Loan } from '../interface/loan';

@Component({
  selector: 'app-calc-sheet',
  templateUrl: './calc-sheet.component.html',
  styleUrls: ['./calc-sheet.component.scss']
})
export class CalcSheetComponent implements OnInit {
  loan$: Observable<Loan>;

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {}
}
