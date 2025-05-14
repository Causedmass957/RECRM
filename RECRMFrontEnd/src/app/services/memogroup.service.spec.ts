import { TestBed } from '@angular/core/testing';

import { MemogroupService } from './memogroup.service';

describe('MemogroupService', () => {
  let service: MemogroupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MemogroupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
