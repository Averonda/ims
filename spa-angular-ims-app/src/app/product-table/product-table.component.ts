import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import { MatFormField, MatFormFieldControl } from '@angular/material/form-field';


@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit {

  
  products : any = [];
  displayedColumns: string[] = ['id', 'title', 'category', 'manufacturer', 'min', 'boh'];
  dataSource :any;
  
  public url = 'http://localhost:8080/products/all';

  constructor(private router: Router, private http: HttpClient) {
   }

  applyFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
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

  ngOnInit(): void {
    this.fetch();
  }

}











