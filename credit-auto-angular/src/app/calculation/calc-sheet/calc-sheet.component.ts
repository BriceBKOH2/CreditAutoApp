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

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {
    this.date = new Date();
    this.simulationService.getCategories().subscribe(response => {
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
    });
  }

  loanCalculation() {
    this.contract = new Contract(
      this.contractForm.value.vehiclePrice,
      this.contractForm.value.loanAmount,
      this.contractForm.value.loanDuration,
      this.contractForm.value.vehicleCat
    );

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
    this.simulationService.putContract(this.contract).subscribe(response => {
      this.contract = response;
      console.log(this.contract);
      this.showButtonAttachClient = true;
    });
  }

  onAttachClient(){
    this.simulationService.findClient(20).subscribe(response => {
      this.contract.client = response;
      console.log(this.contract.client);
    });

    this.simulationService.putUpdateContract(this.contract.id).subscribe(response => {
        this.contract = response;
        console.log(this.contract);
    });
  }
}
