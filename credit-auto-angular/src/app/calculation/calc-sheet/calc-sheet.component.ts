import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { Observable } from 'rxjs';
import { Loan } from '../class/loan';
import { Category } from '../class/category';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';

@Component({
  selector: 'app-calc-sheet',
  templateUrl: './calc-sheet.component.html',
  styleUrls: ['./calc-sheet.component.scss']
})
export class CalcSheetComponent implements OnInit {
  loan$: Observable<Loan>;
  categories: Category[];
  myForm: string;
  query: string;

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {
    let cat1 = new Category('A');
    let cat2 = new Category('B');
    let cat3 = new Category('C');
    this.categories = [cat1, cat2, cat3];
  }

  loanCalc(form: NgForm) {
    this.simulationService.getRate('YO', 123, 123).subscribe(response => {
      console.log(response);
    });
  }
}
