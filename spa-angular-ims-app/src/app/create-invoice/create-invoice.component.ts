import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.css']
})
export class CreateInvoiceComponent implements OnInit {

  products : any = [];
  displayedColumns: string[] = ['id', 'title', 'category', 'manufacturer', 'min', 'boh'];
  dataSource :any;

  public postUrl = 'http://localhost:8080/productstock/create';
  public getUrl = 'http://localhost:8080/products/all';

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch()
  }

  onSubmit(invoiceForm:NgForm){

    const httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})}


    this.http.post(this.postUrl, JSON.stringify({
      productId:invoiceForm.value.productId, vendor:invoiceForm.value.vendor, 
      batchCode:invoiceForm.value.batchCode, invoiceNumber:invoiceForm.value.invoiceNum, 
      quantity:invoiceForm.value.quantity, transactionType:invoiceForm.value.transactionType
    }), httpOptions
    ).subscribe({
      next: (data) => {
      }
    })
  }

  refreshTable(){
    this.fetch();
  }

  home(){
    this.router.navigate(['']);
  }

  fetch(){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    this.http.get(this.getUrl, httpOptions).subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource(this.products);
    })
   }

}
