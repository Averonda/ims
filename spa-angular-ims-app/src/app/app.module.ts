import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateNewProductComponent } from './create-new-product/create-new-product.component';
import { HomeComponent } from './home/home.component';
import { UpdateProductStockComponent } from './update-product-stock/update-product-stock.component';
import { CreateInvoiceComponent } from './create-invoice/create-invoice.component';
import { RestockproductComponent } from './restockproduct/restockproduct.component';
import { ProductTableComponent } from './product-table/product-table.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const routes:Routes = [
  {path:"createNewProduct", component:CreateNewProductComponent },
  {path: '', component: HomeComponent},
  {path: 'updateproductstock', component: UpdateProductStockComponent},
  {path: 'createinvoice', component: CreateInvoiceComponent},
  {path: 'restockProduct', component: RestockproductComponent},
  {path: 'productStock', component: ProductTableComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    CreateNewProductComponent, 
    HomeComponent,
    UpdateProductStockComponent,
    CreateInvoiceComponent,
    RestockproductComponent,
    ProductTableComponent 

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [ MatFormFieldModule, MatInputModule ]
})
export class AppModule { }
