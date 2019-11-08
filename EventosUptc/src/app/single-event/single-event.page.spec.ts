import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleEventPage } from './single-event.page';

describe('SingleEventPage', () => {
  let component: SingleEventPage;
  let fixture: ComponentFixture<SingleEventPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleEventPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleEventPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
