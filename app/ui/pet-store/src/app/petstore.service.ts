import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import { Observable }     from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

import { Pet } from './pet';
import { User } from './user';

@Injectable()
export class PetstoreService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private getPetsUrl = 'api/v1/data/list-all-pets';
  private deletePetUrl = 'api/v1/data/delete-a-pet';
  private createPetUrl = "api/v1/data/create-a-pet";
  private userUrl = 'user';
  private _pets: BehaviorSubject<Pet[]>;
  private dataStore: {
    pets: Pet[]
  }

  constructor(private http: Http) { 
    this.dataStore = {pets: []};
    this._pets = <BehaviorSubject<Pet[]>>new BehaviorSubject([]);
  }

  getUserInfo(): Promise<User> {
    return this.http.get(this.userUrl)
     .toPromise()
     .then(response => response.json() as User)
     .catch(this.handleError);
  }
    
    
  getPets(): Observable<Pet[]> {
    return this._pets.asObservable();
  }
    
  loadAllPets() {
    this.http.get(this.getPetsUrl)
    .map(response => response.json())
    .subscribe(data => {
      this.dataStore.pets = data;
      this._pets.next(Object.assign({}, this.dataStore).pets);    
    }, error => console.log('Could not load pets.'))
  }
    
  onSearch(key) {
    this._pets.next(this.dataStore.pets.filter(pet => pet.name.toLowerCase().includes(key.toLowerCase())));
  }
    
    
  createPet(pet: Pet): void {
    this.http
        .post(this.createPetUrl, JSON.stringify(pet), {headers: new Headers({'Content-Type': 'application/json'})})
        .map(response => response.json())
        .subscribe(data => {
          this.dataStore.pets.push(data);
          this._pets.next(Object.assign({}, this.dataStore).pets);
        }, error => console.log('Could not create pet.'));
  }
    
  remove(id: number) {
    this.http.delete(`${this.deletePetUrl}/${id}`).subscribe(response => {
      this.dataStore.pets.forEach((t, i) => {
        if (t.id === id) { this.dataStore.pets.splice(i, 1); }
      });

      this._pets.next(Object.assign({}, this.dataStore).pets);
    }, error => console.log('Could not delete pet.'));
  }

  private handleError(error: any): Promise<any> {
    console.log('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}