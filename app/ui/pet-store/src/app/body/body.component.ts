import { Component, OnInit, Input } from '@angular/core';

import {PetstoreService} from '../petstore.service';
import { Observable }     from 'rxjs/Observable';

import { Pet } from '../pet';
import { User } from '../user';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {

  @Input() user: User;  
  @Input() pets: Observable<Pet[]>;
    
  filterString: string;
  filteredPets: Pet[];
    
  constructor(private petstoreService: PetstoreService) { }

  ngOnInit() {

  }
    
  remove(pet: Pet, event: any): void {
      event.preventDefault();
      this.petstoreService.remove(pet.id);
  }

}
