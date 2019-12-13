import { TestBed } from '@angular/core/testing';

import { IdentifiyingService } from './identifiying.service';

describe('IdentifiyingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IdentifiyingService = TestBed.get(IdentifiyingService);
    expect(service).toBeTruthy();
  });
});
