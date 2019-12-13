import { TestBed } from '@angular/core/testing';

import { SearchService } from './search.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('SearchService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]
  }));

  it('should be created', () => {
    const service: SearchService = TestBed.get(SearchService);
    expect(service).toBeTruthy();
  });
});
