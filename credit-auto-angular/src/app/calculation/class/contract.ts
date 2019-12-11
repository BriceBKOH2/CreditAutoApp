import { Category } from './category';
import { Client } from './client';

export class Contract {
  vehicleCat: Category;
  vehiclePrice: number;
  loanAmount: number;
  loanDuration: number;
  rate: number;
  amountDue: number;
  id: number;
  isActive: boolean;
  client: Client;

  constructor(
    vehiclePrice: number,
    loanAmount: number,
    loanDuration: number,
    vehicleCat?: Category,
    rate?: number,
    amountDue?: number,
    isActive?: boolean,
    client?: Client,
    id?: number
  ) {
    this.id = id;
    this.vehiclePrice = vehiclePrice;
    this.loanAmount = loanAmount;
    this.loanDuration = loanDuration;
    this.rate = rate;
    this.amountDue = amountDue;
    this.isActive = isActive;
    this.client = client;
    this.vehicleCat = vehicleCat;
  }
}
