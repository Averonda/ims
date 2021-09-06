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
    console.log(form.value.title);
    console.log(form.value.category);
    console.log(form.value.manufacturer);
    console.log(form.value.minimum_limit);
    console.log(form.value.boh);
   
    const httpOptions = {headers: new HttpHeaders({'Content-Type':'application/json'})}

    this.http.post(this.url, JSON.stringify({title:form.value.title,category:form.value.category,manufacturer:form.value.manufacturer, min:form.value.minimum_limit, boh:form.value.boh}), httpOptions
    ).subscribe({next:(data:any)=>{console.log(data)
    }
    })
    this.router.navigate([''])  //TODO: update with location to this page again

    //TODO: "Message: Product Successfully Added"

}

}
