import { Component, OnInit } from '@angular/core';
import { ClientService } from '../service/client.service';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Client } from 'src/app/calculation/class/client';
import { Router } from '@angular/router';
import { Contract } from 'src/app/calculation/class/contract';

@Component({
  selector: 'app-client-creation-page',
  templateUrl: './client-creation-page.component.html',
  styleUrls: ['./client-creation-page.component.scss']
})
export class ClientCreationPageComponent implements OnInit {
  client: Client;
  contract: Contract;

  clientForm = new FormGroup({
    clientLastName: new FormControl('', Validators.required),
    clientFirstName: new FormControl('', Validators.required),
    clientAccountNumber: new FormControl('', Validators.required),
    clientAddress: new FormControl('', Validators.required),
    clientBirthDate: new FormControl('', Validators.required),
    clientPhoneNumber: new FormControl('', Validators.required)
  });

  constructor(private clientService: ClientService, private router: Router) {
    this.client = new Client(
      undefined,
      undefined,
      undefined,
      undefined,
      undefined,
      undefined
    );

    this.contract = undefined;
  }

  ngOnInit() {
    this.contract = window.history.state.contract;
    this.clientService.getNewAccountNumber().subscribe(response => {
      this.client.accountNumber = response;
      this.clientForm
        .get('clientAccountNumber')
        .setValue(this.client.accountNumber);
    });
  }

  onSubmitForm() {
    this.client.firstName = this.clientForm.value.clientFirstName;
    this.client.lastName = this.clientForm.value.clientLastName;
    this.client.dateOfBirth = this.clientForm.value.clientBirthDate;
    this.client.phoneNumber = this.clientForm.value.clientPhoneNumber;
    this.client.address = this.clientForm.value.clientAddress;
    this.client.accountNumber = this.clientForm.value.clientAccountNumber;
  }

  sendClientToDatabase() {
    this.client.firstName = this.clientForm.value.clientFirstName;
    this.client.lastName = this.clientForm.value.clientLastName;
    this.client.dateOfBirth = this.clientForm.value.clientBirthDate;
    this.client.phoneNumber = this.clientForm.value.clientPhoneNumber;
    this.client.address = this.clientForm.value.clientAddress;
    this.client.accountNumber = this.clientForm.value.clientAccountNumber;

    this.clientService.putClient(this.client).subscribe(response => {
      this.client = response;
      console.log(this.client);
    });
  }

  sendClientToContract() {
    this.client.firstName = this.clientForm.value.clientFirstName;
    this.client.lastName = this.clientForm.value.clientLastName;
    this.client.dateOfBirth = this.clientForm.value.clientBirthDate;
    this.client.phoneNumber = this.clientForm.value.clientPhoneNumber;
    this.client.address = this.clientForm.value.clientAddress;
    this.client.accountNumber = this.clientForm.value.clientAccountNumber;

    this.router.navigateByUrl('/simulPage', {
      state: { client: this.client, contract: this.contract }
    });
  }
}
