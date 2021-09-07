import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-restockproduct',
  templateUrl: './restockproduct.component.html',
  styleUrls: ['./restockproduct.component.css']
})
export class RestockproductComponent implements OnInit {
  [x: string]: any;
  products : any = [];
  displayedColumns: string[] = ['id', 'title', 'category', 'manufacturer', 'min', 'boh'];
  dataSource :any;

  public url = 'http://localhost:8080/products/productbalance';

  status: any;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.fetch();
  }

  fetch() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    this.http.get(this.url, httpOptions).subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource(this.products);
    })

  }

  submit(){
    alert("Under Construction, Comming Soon!")
  }
  order(_data: any) {

  }

  downloadFile(_data: any) {

  }

}
