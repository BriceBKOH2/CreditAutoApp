import { Component, OnInit } from '@angular/core';
import { SimulationService } from 'src/app/calculation/service/simulation.service';
import { Rate } from 'src/app/calculation/class/rate';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent implements OnInit {
  rates: Rate[];
  rate: Rate;

  rateForm = new FormGroup({
    rateName: new FormControl(''),
    rateAmount: new FormControl('')
  });

  constructor(private simulationService: SimulationService) {}

  ngOnInit() {
    this.getRates();
  }

  getRates() {
    this.simulationService.getRates().subscribe(rates => {
      this.rates = rates;
    });
  }

  changeSelectedRate(rateDB: Rate) {
    this.rate = rateDB;
  }

  onSubmitRateForm() {
    this.rate.rateAmount = this.rateForm.value.rateAmount;
    this.simulationService.setRate(this.rate).subscribe();
    this.getRates();
  }
}
