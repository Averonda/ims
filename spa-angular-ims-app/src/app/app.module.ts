import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CreateNewProductComponent } from './create-new-product/create-new-product.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateNewProductComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
