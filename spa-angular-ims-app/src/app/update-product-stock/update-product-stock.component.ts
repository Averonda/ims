import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-update-product-stock',
  templateUrl: './update-product-stock.component.html',
  styleUrls: ['./update-product-stock.component.css']
})
export class UpdateProductStockComponent implements OnInit {

  public url='http://localhost:8080/productstock/invoices';

  invoices:any = [];

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch();
  }

  createNewInvoice(){
    this.router.navigate(['createinvoice']);
  }

  fetch(){
    const httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json'})}

    this.http.get(this.url, httpOptions).subscribe(data=>{
      this.invoices= data;
      console.log(data)
    })
   }

}
