import { Component, OnInit } from '@angular/core';
import { Contract } from 'src/app/calculation/class/contract';
import { ContractService } from 'src/app/service/contract.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-location-page',
  templateUrl: './location-page.component.html',
  styleUrls: ['./location-page.component.scss']
})
export class LocationPageComponent implements OnInit {

  contractSelectionForm = new FormGroup({
    contractId: new FormControl()
  });

  contract: Contract;

  constructor(private contractService: ContractService) { }

  ngOnInit() {}

  searchContract() {
    this.contractService.searchById(this.contractSelectionForm.value.contractId).subscribe(response => this.contract = response);
  }

}
