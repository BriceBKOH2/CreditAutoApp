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
  client: Client;

  //clientForm$: BehaviorSubject<{client: Client}>;

  clientForm = new FormGroup({
    clientlastname: new FormControl(''),
    clientfirstname: new FormControl(''),
    clientaccount: new FormControl(''),
    clientaddress: new FormControl(''),
    clientbirth: new FormControl(''),
    clientphone: new FormControl('')
  });

  constructor(private clientService: ClientService, router: Router) {}

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
      this.clientForm.value.clientfirstname,
      this.clientForm.value.clientlastname,
      this.clientForm.value.clientbirth,
      this.clientForm.value.clientphone,
      this.clientForm.value.clientaddress,
      this.clientForm.value.clientaccount
    );
    this.clientService.putClient(this.client).subscribe(response => {
      this.client = response;
      console.log(this.client);
    });
  }
}
