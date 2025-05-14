import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemoDetailsComponent } from './memo-details.component';

describe('MemoDetailsComponent', () => {
  let component: MemoDetailsComponent;
  let fixture: ComponentFixture<MemoDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MemoDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MemoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
