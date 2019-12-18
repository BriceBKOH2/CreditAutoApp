import { Component, OnInit } from '@angular/core';
import { ClientService } from '../service/client.service';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Client } from 'src/app/calculation/class/client';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-creation-page',
  templateUrl: './client-creation-page.component.html',
  styleUrls: ['./client-creation-page.component.scss']
})
export class ClientCreationPageComponent implements OnInit {
  clients: Client[];
  client: Client;
  displayClientForm: boolean;

  clientCreationForm = new FormGroup({
    clientFirstName: new FormControl('', Validators.required),
    clientLastName: new FormControl('', Validators.required),
    clientAccountNumber: new FormControl('', Validators.required),
    clientAddress: new FormControl('', Validators.required),
    clientBirthDate: new FormControl('', Validators.required),
    clientPhoneNumber: new FormControl('', Validators.required)
  });

  clientSelectionForm = new FormGroup({
    clientId: new FormControl(),
    clientFirstName: new FormControl(''),
    clientLastName: new FormControl('')
  });

  constructor(private clientService: ClientService, private router: Router) {
    this.clients = new Array<Client>();
    this.client = new Client(
      undefined,
      undefined,
      undefined,
      undefined,
      undefined,
      undefined
    );
    this.displayClientForm = true;
  }

  ngOnInit() {
    this.clientService.getNewAccountNumber().subscribe(response => {
      this.client.accountNumber = response;
      this.clientCreationForm
        .get('clientAccountNumber')
        .setValue(this.client.accountNumber);
    });
  }

  displayCreationMenu() {
    this.displayClientForm = true;
  }

  displaySelectionMenu() {
    this.displayClientForm = false;
  }

  onSubmitCreationForm() {
    this.client.firstName = this.clientCreationForm.value.clientFirstName;
    this.client.lastName = this.clientCreationForm.value.clientLastName;
    this.client.dateOfBirth = this.clientCreationForm.value.clientBirthDate;
    this.client.phoneNumber = this.clientCreationForm.value.clientPhoneNumber;
    this.client.address = this.clientCreationForm.value.clientAddress;
    this.client.accountNumber = this.clientCreationForm.value.clientAccountNumber;
  }

  onSubmitSelectionForm() {
    if (this.clientSelectionForm.value.clientId) {
      console.log(this.clientSelectionForm.value.clientId);
      this.clientService
        .findClient(this.clientSelectionForm.value.clientId)
        .subscribe(client => {
          this.clients = new Array<Client>();
          this.clients.push(client);
          console.log(client);
          console.log(this.clients);
        });
    } else if (
      this.clientSelectionForm.value.clientFirstName &&
      this.clientSelectionForm.value.clientLastName
    ) {
      this.clientService
        .findClientByNames(
          this.clientSelectionForm.value.clientFirstName,
          this.clientSelectionForm.value.clientLastName
        )
        .subscribe(clients => {
          this.clients = clients;
          console.log(this.clients);
        });
    }
  }

  sendClientToDatabase() {
    this.client.firstName = this.clientCreationForm.value.clientFirstName;
    this.client.lastName = this.clientCreationForm.value.clientLastName;
    this.client.dateOfBirth = this.clientCreationForm.value.clientBirthDate;
    this.client.phoneNumber = this.clientCreationForm.value.clientPhoneNumber;
    this.client.address = this.clientCreationForm.value.clientAddress;
    this.client.accountNumber = this.clientCreationForm.value.clientAccountNumber;

    this.clientService.putClient(this.client).subscribe(response => {
      this.client = response;
    });
  }

  sendClientToContract() {
    this.client.firstName = this.clientCreationForm.value.clientFirstName;
    this.client.lastName = this.clientCreationForm.value.clientLastName;
    this.client.dateOfBirth = this.clientCreationForm.value.clientBirthDate;
    this.client.phoneNumber = this.clientCreationForm.value.clientPhoneNumber;
    this.client.address = this.clientCreationForm.value.clientAddress;
    this.client.accountNumber = this.clientCreationForm.value.clientAccountNumber;

    this.router.navigateByUrl('/simulPage', {
      state: { client: this.client }
    });
  }

  sendSelectedClientToContract(clientSelected: Client) {
    this.router.navigateByUrl('/simulPage', {
      state: { client: clientSelected }
    });
  }
}
