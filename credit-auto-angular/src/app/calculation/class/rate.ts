export class Rate {
  id: number;
  name: string;
  rateAmount: number;

  constructor(name: string, rateAmount: number, id?: number) {
    this.id = id;
    this.name = name;
    this.rateAmount = rateAmount;
  }
}
