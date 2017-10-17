import { Component, OnInit } from '@angular/core';
import { User } from './user'; 
import {PetstoreService} from './petstore.service';
import { Pet } from './pet';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/add/observable/of';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public user: User;
  public pets: Observable<Pet[]>;
  public searchString: string = "";
  
  constructor(private petstoreService: PetstoreService) { }

  ngOnInit() {
    this.petstoreService.getUserInfo().then(user => this.user = user);
    this.pets = this.petstoreService.getPets();
    this.petstoreService.loadAllPets();
  }

}
