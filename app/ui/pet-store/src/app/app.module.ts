import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpModule }    from '@angular/http';
import { FormsModule }   from '@angular/forms';

import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';

import { PetstoreService } from './petstore.service';
import { HeaderComponent } from './header/header.component';
import { BodyComponent } from './body/body.component';
  
import {MatButtonModule} from '@angular/material';
import {MatDialogModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material';
import {MatInputModule} from '@angular/material';
import {MatIconModule} from '@angular/material';
import {NewPetExampleDialog} from './header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BodyComponent,
    NewPetExampleDialog
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatToolbarModule,
    BrowserAnimationsModule
  ],
  entryComponents: [
    NewPetExampleDialog
  ],
  providers: [PetstoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
