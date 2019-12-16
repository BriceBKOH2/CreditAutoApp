import { Component, OnInit } from '@angular/core';
import { ClientService } from '../service/client.service';
import { Observable, BehaviorSubject } from 'rxjs';
import { Contract } from 'src/app/calculation/class/contract';
import { Category } from 'src/app/calculation/class/category';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Rate } from 'src/app/calculation/class/rate';
import { Client } from 'src/app/calculation/class/client';
import { map } from 'rxjs/operators';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-client-creation-page',
  templateUrl: './client-creation-page.component.html',
  styleUrls: ['./client-creation-page.component.scss']
})
export class ClientCreationPageComponent implements OnInit {

    client: Client;

    

    clientForm = new FormGroup({
      clientlastname: new FormControl(''),
      clientfirstname: new FormControl(''),
      clientaccount: new FormControl(''),
      clientaddress: new FormControl(''),
      clientbirth: new FormControl(''),
      clientphone: new FormControl(''),
      });

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    
  }

  onSubmitForm(){
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
    })
  }
}
