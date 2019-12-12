import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { Observable, BehaviorSubject } from 'rxjs';
import { Contract } from '../class/contract';
import { Category } from '../class/category';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Rate } from '../class/rate';
import { Client } from '../class/client';
import { map } from 'rxjs/operators';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-calc-sheet',
  templateUrl: './calc-sheet.component.html',
  styleUrls: ['./calc-sheet.component.scss']
})
export class CalcSheetComponent implements OnInit {
  contract: Contract = new Contract(
    undefined,
    undefined,
    undefined,
    new Category('A')
  );
  categories: Category[];
  myForm: string;
  query: string;
  rate$: Rate[];
  rateLoan: Rate;
  client: Client;

  contractForm$: BehaviorSubject<{ vehicleCat: string }>;

  contractForm = new FormGroup({
    vehiclePrice: new FormControl(''),
    vehicleCat: new FormControl(''),
    loanDuration: new FormControl(''),
    loanAmount: new FormControl('')
  });

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {
    /*let cat1 = new Category('A', 1);
    let cat2 = new Category('B', 2);
    let cat3 = new Category('C', 3);
    this.categories = [cat1, cat2, cat3];*/

    this.simulationService.getCategories().subscribe(response => {
      console.log(response);
      this.categories = response;
    });

    this.contractForm$ = new BehaviorSubject({
      vehicleCat: this.contractForm.get('vehicleCat').value
    });

    this.showRates();
  }

  showRates() {
    this.simulationService.getRates().subscribe(response => {
      this.rate$ = response;
      console.log(this.rate$);
    });
  }

  loanCalculation() {
    const contract: Contract = new Contract(
      this.contractForm.value.vehiclePrice,
      this.contractForm.value.loanAmount,
      this.contractForm.value.loanDuration,
      this.contractForm.value.vehicleCat
    );

    this.simulationService.getRateForLoan(contract).subscribe(response => {
      this.rateLoan = response;
      this.rate$ = [this.rateLoan];
      console.log(this.rateLoan);
    });
  }

  onSubmitForm() {
    console.log(this.contractForm.value);
    this.loanCalculation();

    this.client = new Client(
      'Jade',
      'Paul',
      '1987-04-12',
      '0605040302',
      '03 diginamic street 34000 Montpellier',
      true,
      1234567890
    );

    this.simulationService.putClient(this.client).subscribe(response => {
      this.client = response;
      console.log(this.client);
    });
  }
}
