import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupMemosComponent } from './group-memos.component';

describe('GroupMemosComponent', () => {
  let component: GroupMemosComponent;
  let fixture: ComponentFixture<GroupMemosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GroupMemosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroupMemosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
