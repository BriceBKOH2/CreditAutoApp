import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { BehaviorSubject } from 'rxjs';
import { Contract } from '../class/contract';
import { Category } from '../class/category';
import { FormGroup, FormControl } from '@angular/forms';
import { Rate } from '../class/rate';
import { Client } from '../class/client';

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
    this.simulationService.getCategories().subscribe(response => {
      console.log('component ts');
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
      console.log('component ts showRates');
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
      console.log('component ts LoanCalculation');
      console.log(this.rateLoan);
    });
  }

  amountCalculation() {
    const contract: Contract = new Contract(
      this.contractForm.value.vehiclePrice,
      this.contractForm.value.loanAmount,
      this.contractForm.value.loanDuration,
      this.contractForm.value.vehicleCat
    );

    this.simulationService.gettotalAmount(contract).subscribe(response => {
      this.contract = response;
      console.log('component ts LoanCalculation');
      console.log(this.contract);
    });
  }

  onSubmitForm() {
    console.log(this.contractForm.value);
    this.loanCalculation();
    console.log('component ts onSubmitForm');
    console.log(this.loanCalculation());
    this.amountCalculation();

    // this.client = new Client(
    //   'Jade',
    //   'Paul',
    //   '1987-04-12',
    //   '0605040302',
    //   '03 diginamic street 34000 Montpellier',
    //   true,
    //   1234567896
    // );

    // this.simulationService.putClient(this.client).subscribe(response => {
    //   this.client = response;
    //   console.log(this.client);
    // });
  }
}
