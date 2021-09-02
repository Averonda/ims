import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-create-new-product',
  templateUrl: './create-new-product.component.html',
  styleUrls: ['./create-new-product.component.css']
})
export class CreateNewProductComponent implements OnInit {

  public _url = 'http://localhost:8080/products';

  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(newProductForm:NgForm) { 
   
    const httpOptions = {
headers: new HttpHeaders({
'Content-Type':  'application/json'})}

this.http.post(this._url,JSON.stringify({
title:newProductForm.value.title,
category:newProductForm.value.category,
manufacturer:newProductForm.value.manufacturer,
minimum_limit:newProductForm.value.minimum_limit,
boh:newProductForm.value.boh}),httpOptions
).subscribe({
 next:(data:any)=>{
   console.log(data)
 }

})
this.router.navigate([''])  //TODO: update with location

}

}
