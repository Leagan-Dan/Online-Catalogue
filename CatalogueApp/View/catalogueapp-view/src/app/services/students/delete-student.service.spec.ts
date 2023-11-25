import { TestBed } from '@angular/core/testing';

import { DeleteStudentService } from './delete-student.service';

describe('DeleteStudentService', () => {
  let service: DeleteStudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteStudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
