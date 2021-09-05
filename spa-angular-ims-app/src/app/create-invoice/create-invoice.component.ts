import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { formatCurrency } from '@angular/common';

@Component({
  selector: 'app-create-invoice',
  templateUrl: './create-invoice.component.html',
  styleUrls: ['./create-invoice.component.css']
})
export class CreateInvoiceComponent implements OnInit {

  public url = 'http://localhost:8080/productstock/create';

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(invoiceForm:NgForm){

    const httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})}

    console.log(invoiceForm)

    this.http.post(this.url, JSON.stringify({
      product_id:invoiceForm.value.productId, vendor:invoiceForm.value.vendor, 
      batch_code:invoiceForm.value.batchCode, invoice_number:invoiceForm.value.invoiceNum, 
      quantity:invoiceForm.value.quantity, transaction_type:invoiceForm.value.transactionType
    }), httpOptions
    ).subscribe({
      next: (data) => {
        console.log(data)
      }
    })

    this.router.navigate([""])

    // this.http.post(this.url, JSON.stringify({
    //   product_id:invoiceForm.value.productId, vendor:invoiceForm.value.vendor, 
    //   batch_code:invoiceForm.value.batchCode, invoice_number:invoiceForm.value.invoiceNum,
    //   quantity:invoiceForm.value.quantity, transaction_type:invoiceForm.value.transactionType
    // }), httpOptions).subscribe({
    //   next:(data:any)=>{
    //     console.log(data)
    //   }
    // })

  }

}
