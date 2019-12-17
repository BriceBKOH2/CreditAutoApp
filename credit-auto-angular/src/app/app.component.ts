import { Component } from '@angular/core';
import { ClientService } from './client-management/service/client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'credit-auto-angular';

  constructor(private clientService: ClientService) {}
}
