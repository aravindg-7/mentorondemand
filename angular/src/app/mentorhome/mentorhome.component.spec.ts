import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { MentorhomeComponent } from './mentorhome.component';

describe('MentorhomeComponent', () => {
  let component: MentorhomeComponent;
  let fixture: ComponentFixture<MentorhomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorhomeComponent ],
      imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
