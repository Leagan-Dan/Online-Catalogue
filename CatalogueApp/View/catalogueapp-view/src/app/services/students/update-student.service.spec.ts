import { TestBed } from '@angular/core/testing';

import { UpdateStudentService } from './update-student.service';

describe('UpdateStudentService', () => {
  let service: UpdateStudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateStudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
