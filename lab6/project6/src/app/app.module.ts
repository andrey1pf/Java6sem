import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DesignModule } from './design/design.module';

import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent
  ],
  providers: [],
  bootstrap: [AppComponent],

  imports: [
    BrowserModule,
    AppRoutingModule,
    DesignModule,
    HttpClientModule
  ],
  exports: [RouterModule]
})
export class AppModule { }
