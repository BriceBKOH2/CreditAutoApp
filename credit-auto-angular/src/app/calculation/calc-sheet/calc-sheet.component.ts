import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../service/simulation.service';
import { BehaviorSubject, Subscription } from 'rxjs';
import { Contract } from '../class/contract';
import { Category } from '../class/category';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Rate } from '../class/rate';
import { Router } from '@angular/router';

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
  showButtonAttachClient = false;
  date: Date;

  contractForm$: BehaviorSubject<{ vehicleCat: string }>;

  contractForm = new FormGroup({
    vehiclePrice: new FormControl(''),
    vehicleCat: new FormControl(''),
    loanDuration: new FormControl(''),
    loanAmount: new FormControl('')
  });

  constructor(private simulationService: SimulationService, private router: Router) {
    if(window.history.state.contract === undefined) {
      this.contract = new Contract(
        undefined,
        undefined,
        undefined,
        new Category('A')
    );
    } else {
      this.contract = window.history.state.contract;
      console.log(this.contract);
      this.contractForm.get('vehiclePrice').setValue(this.contract.vehiclePrice);
      this.contractForm.get('loanAmount').setValue(this.contract.loanAmount);
      this.contractForm.get('loanDuration').setValue(this.contract.loanDuration);
      this.contractForm.get('vehicleCat').setValue(this.contract.vehicleCategory);

    }
      }
  ngOnInit() {
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
      console.log(this.contract);
    });
  }

  onSubmitForm() {
    this.loanCalculation();
    this.showButonSendContract = true;
  }

  onCreateContract() {
    console.log('le contract');
    console.log(this.contract);
    this.simulationService.putContract(this.contract).subscribe(response => {
      this.contract = response;
      console.log(this.contract);
      this.showButtonAttachClient = true;
    });
  }

  sendContractToClient(){
    this.router.navigateByUrl('/clientcreationpage', {
      state: { contract: this.contract}
    });
    }
}
