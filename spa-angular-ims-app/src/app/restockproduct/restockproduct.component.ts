import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {HttpClient, HttpHeaderResponse, HttpHeaders} from '@angular/common/http';


@Component({
  selector: 'app-restockproduct',
  templateUrl: './restockproduct.component.html',
  styleUrls: ['./restockproduct.component.css']
})
export class RestockproductComponent implements OnInit {
  [x: string]: any;

   public url='http://localhost:8080/products/productbalance';
   products:any = [];

  status:any;
  constructor(private http:HttpClient, ) { }

  ngOnInit(): void {
     this.fetch();
     
  }
 
 

    fetch(){
      this.http.get(this.url).subscribe(data=>{
        this.products= data;
        
       
      })

   }




getStatus(){
    
   console.log(HttpHeaderResponse)

}

   
  order(_data:any){

  }

  downloadFile(_data:any){

}

}
