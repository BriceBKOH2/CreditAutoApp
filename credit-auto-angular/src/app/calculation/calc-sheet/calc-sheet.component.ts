import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { Observable } from 'rxjs';
import { Contract } from '../class/contract';
import { Category } from '../class/category';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Rate } from '../class/rate';

@Component({
  selector: 'app-calc-sheet',
  templateUrl: './calc-sheet.component.html',
  styleUrls: ['./calc-sheet.component.scss']
})
export class CalcSheetComponent implements OnInit {
  loan$: Observable<Contract>;
  categories: Category[];
  myForm: string;
  query: string;
  rate$: Rate[];
  rateLoan: Rate;

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {
    let cat1 = new Category('A', 1);
    let cat2 = new Category('B', 2);
    let cat3 = new Category('C', 3);
    this.categories = [cat1, cat2, cat3];
  }

  showRates() {
    this.simulationService.getRates().subscribe(response => {
      this.rate$ = response;
      console.log(this.rate$);
    });
  }

  loanCalculation() {
    console.log(this.simulationService.getRateForLoan());
    this.simulationService.getRateForLoan().subscribe(response => {
      this.rateLoan = response;
      this.rate$ = [this.rateLoan];
      console.log(this.rateLoan);
    });
  }
}
