export class User {
  id: number;
  firstName: string;
  lastName: string;
  login: string;
  password: string;
  mail: string;

  constructor(username: string, password: string) {
    this.login = username;
    this.password = password;
  }
}
