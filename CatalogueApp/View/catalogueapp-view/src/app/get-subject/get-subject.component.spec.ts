import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetSubjectComponent } from './get-subject.component';

describe('GetSubjectComponent', () => {
  let component: GetSubjectComponent;
  let fixture: ComponentFixture<GetSubjectComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetSubjectComponent]
    });
    fixture = TestBed.createComponent(GetSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
