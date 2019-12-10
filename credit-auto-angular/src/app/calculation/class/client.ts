import { Contract } from './contract';

export class Client {
  id: number;
  firstName: string;
  lastName: string;
  dateOfBirth: string;
  phoneNumber: string;
  address: string;
  isActive: boolean;
  accountNumber: number;
  contract: Contract;

  constructor(
    firstName: string,
    lastName: string,
    dateOfBirth: string,
    phoneNumber: string,
    address: string,
    isActive?: boolean,
    accountNumber?: number
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.isActive = isActive;
    this.accountNumber = accountNumber;
  }
}
