import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetStudentComponent } from './get-student.component';

describe('GetStudentComponent', () => {
  let component: GetStudentComponent;
  let fixture: ComponentFixture<GetStudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetStudentComponent]
    });
    fixture = TestBed.createComponent(GetStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
