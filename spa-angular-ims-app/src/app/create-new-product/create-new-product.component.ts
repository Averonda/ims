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

  public url = 'http://localhost:8080/products/add';

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
  }
  
  onSubmit(form:NgForm) { 
   
    const httpOptions = {headers: new HttpHeaders({'Content-Type':'application/json'})}

    this.http.post(this.url, JSON.stringify({title:form.value.title,category:form.value.category,manufacturer:form.value.manufacturer, min:form.value.minimum_limit, boh:form.value.boh}), httpOptions
    ).subscribe({next:(data:any)=>{
    }
    })

    alert("Product Added Successfully")

    this.router.navigate([''])

}

}
