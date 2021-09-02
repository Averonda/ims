import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProductStockComponent } from './update-product-stock.component';

describe('UpdateProductStockComponent', () => {
  let component: UpdateProductStockComponent;
  let fixture: ComponentFixture<UpdateProductStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProductStockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProductStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
