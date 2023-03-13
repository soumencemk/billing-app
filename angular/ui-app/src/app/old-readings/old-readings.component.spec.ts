import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OldReadingsComponent } from './old-readings.component';

describe('OldReadingsComponent', () => {
  let component: OldReadingsComponent;
  let fixture: ComponentFixture<OldReadingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OldReadingsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OldReadingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
