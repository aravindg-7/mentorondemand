import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AddskillComponent } from './addskill.component';

describe('AddskillComponent', () => {
  let component: AddskillComponent;
  let fixture: ComponentFixture<AddskillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddskillComponent ],
      imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddskillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
