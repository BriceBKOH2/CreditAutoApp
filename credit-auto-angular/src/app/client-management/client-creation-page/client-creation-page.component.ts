import { Component, OnInit } from '@angular/core';
import { ClientService } from '../service/client.service';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Client } from 'src/app/calculation/class/client';

@Component({
  selector: 'app-client-creation-page',
  templateUrl: './client-creation-page.component.html',
  styleUrls: ['./client-creation-page.component.scss']
})
export class ClientCreationPageComponent implements OnInit {
  client: Client;

  // clientForm$: BehaviorSubject<{client: Client}>;

  clientForm = new FormGroup({
    clientLastName: new FormControl('', Validators.required),
    clientFirstName: new FormControl('', Validators.required),
    clientAccount: new FormControl('', Validators.required),
    clientAddress: new FormControl('', Validators.required),
    clientBirthDate: new FormControl('', Validators.required),
    clientPhoneNumber: new FormControl('', Validators.required)
  });

  constructor(private clientService: ClientService) {}

  ngOnInit() {
    this.client = new Client(
      undefined,
      undefined,
      undefined,
      undefined,
      undefined,
      undefined
    );

    this.clientService.getNewAccountNumber().subscribe(response => {
      this.client.accountNumber = response;
      this.clientForm.get('clientAccount').setValue(this.client.accountNumber);
    });
  }

  onSubmitForm() {
    this.client = new Client(
      this.clientForm.value.clientFirstName,
      this.clientForm.value.clientLastName,
      this.clientForm.value.clientBirthDate,
      this.clientForm.value.clientPhoneNumber,
      this.clientForm.value.clientAddress,
      this.clientForm.value.clientAccount
    );
    this.clientService.putClient(this.client).subscribe(response => {
      this.client = response;
      console.log(this.client);
    });
  }
}
