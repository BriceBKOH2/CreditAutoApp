import { TestBed } from '@angular/core/testing';

import { NavbarDisplayService } from './navbar-display.service';

describe('NavbarDisplayService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NavbarDisplayService = TestBed.get(NavbarDisplayService);
    expect(service).toBeTruthy();
  });
});
