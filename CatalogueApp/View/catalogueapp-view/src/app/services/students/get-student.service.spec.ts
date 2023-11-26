import { TestBed } from '@angular/core/testing';

import { GetStudentService } from './get-student.service';

describe('GetStudentService', () => {
  let service: GetStudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetStudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
