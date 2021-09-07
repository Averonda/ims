import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestockproductComponent } from './restockproduct.component';

describe('RestockproductComponent', () => {
  let component: RestockproductComponent;
  let fixture: ComponentFixture<RestockproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestockproductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestockproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
