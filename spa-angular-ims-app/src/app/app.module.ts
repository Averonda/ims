import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UpdateProductStockComponent } from './update-product-stock/update-product-stock.component';
import { CreateInvoiceComponent } from './create-invoice/create-invoice.component';

const routes:Routes = [
  {path: '', component: HomeComponent},
  {path: 'updateproductstock', component: UpdateProductStockComponent},
  {path: 'createinvoice', component: CreateInvoiceComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UpdateProductStockComponent,
    CreateInvoiceComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
