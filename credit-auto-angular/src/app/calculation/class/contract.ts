import { Category } from './category';
import { Client } from './client';

export class Contract {
  id: number;
  vehiclePrice: number;
  loanAmount: number;
  amountDue: number;
  loanDuration: number;
  rate: number;
  rentRight: boolean;
  creationDate: Date;
  isActive: boolean;
  client: Client;
  vehicleCategory: Category;

  constructor(
    vehiclePrice: number,
    loanAmount: number,
    loanDuration: number,
    vehicleCategory?: Category,
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
    this.vehicleCategory = vehicleCategory;
  }
}
