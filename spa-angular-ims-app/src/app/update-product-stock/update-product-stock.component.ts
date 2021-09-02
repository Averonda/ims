import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-product-stock',
  templateUrl: './update-product-stock.component.html',
  styleUrls: ['./update-product-stock.component.css']
})
export class UpdateProductStockComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  createNewInvoice(){
    this.router.navigate(['createinvoice']);
  }

}
