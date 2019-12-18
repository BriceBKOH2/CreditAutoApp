import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { BehaviorSubject } from 'rxjs';
import { Contract } from '../class/contract';
import { Category } from '../class/category';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Rate } from '../class/rate';

@Component({
  selector: 'app-calc-sheet',
  templateUrl: './calc-sheet.component.html',
  styleUrls: ['./calc-sheet.component.scss']
})
export class CalcSheetComponent implements OnInit {
  contract: Contract;
  categories: Category[];
  myForm: string;
  query: string;
  rate$: Rate[];
  rateLoan: Rate;
  showButonSendContract = false;
  date: Date;

  contractForm$: BehaviorSubject<{ vehicleCat: string }>;

  contractForm = new FormGroup({
    vehiclePrice: new FormControl(''),
    vehicleCat: new FormControl(''),
    loanDuration: new FormControl(''),
    loanAmount: new FormControl('')
  });

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {
    this.contract = new Contract(
      undefined,
      undefined,
      undefined,
      new Category('A')
    );
    this.date = new Date();
    this.simulationService.getCategories().subscribe(response => {
      this.categories = response;
    });
    this.contract.client = window.history.state.client;

    this.contractForm$ = new BehaviorSubject({
      vehicleCat: this.contractForm.get('vehicleCat').value
    });

    this.showRates();
    console.log(this.contract);
  }

  showRates() {
    this.simulationService.getRates().subscribe(response => {
      this.rate$ = response;
    });
  }

  loanCalculation() {
    this.contract.vehiclePrice = this.contractForm.value.vehiclePrice;
    this.contract.loanAmount = this.contractForm.value.loanAmount;
    this.contract.loanDuration = this.contractForm.value.loanDuration;
    this.contract.vehicleCategory = this.contractForm.value.vehicleCat;

    this.simulationService.getRateForLoan(this.contract).subscribe(response => {
      this.contract.rate = response.rateAmount;
      this.rateLoan = response;
      this.rate$ = [this.rateLoan];
      this.amountCalculation();
    });
  }

  amountCalculation() {
    this.simulationService.gettotalAmount(this.contract).subscribe(response => {
      this.contract = response;
      this.contract.creationDate = this.date;
    });
  }

  onSubmitForm() {
    this.loanCalculation();
    this.showButonSendContract = true;
  }

  onCreateContract() {
    this.simulationService.putContract(this.contract).subscribe(response => {
      this.contract = response;
      console.log(this.contract);
    });
  }
}
