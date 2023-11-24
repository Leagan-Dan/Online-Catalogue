import { TestBed } from '@angular/core/testing';

import { PostStudentService } from './post-student.service';

describe('PostStudentService', () => {
  let service: PostStudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PostStudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
