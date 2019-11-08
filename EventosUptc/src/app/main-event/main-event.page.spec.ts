import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainEventPage } from './main-event.page';

describe('MainEventPage', () => {
  let component: MainEventPage;
  let fixture: ComponentFixture<MainEventPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainEventPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainEventPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
