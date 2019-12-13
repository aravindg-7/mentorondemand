import { TestBed } from '@angular/core/testing';

import { MentorauthguardService } from './mentorauthguard.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('MentorauthguardService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]
  }));

  it('should be created', () => {
    const service: MentorauthguardService = TestBed.get(MentorauthguardService);
    expect(service).toBeTruthy();
  });
});
