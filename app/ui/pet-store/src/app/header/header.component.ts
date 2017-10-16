import { Component, OnInit, Input, Inject } from '@angular/core';

import {MAT_DIALOG_DATA} from '@angular/material';
import { MatDialog } from '@angular/material';
import { MatDialogRef } from '@angular/material';

import {PetstoreService} from '../petstore.service';
import { User } from '../user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input() user: User;  
    
  constructor(public dialog: MatDialog, private petstoreService: PetstoreService) { }

  ngOnInit() {
  }
    
  openDialog(): void {
    let dialogRef = this.dialog.open(NewPetExampleDialog, {
      data: { petstoreService: this.petstoreService }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed: ' + result);
    });
  }
    
  triggerSearch($event: any): void {
    this.petstoreService.onSearch($event.currentTarget.value);
  }

 
}

@Component({
  selector: 'dialog-overview-example-dialog',
  template: `
    <div class="example-container">
      <p> Create a new Pet here </p>
      <mat-form-field class="example-full-width">
          <input matInput placeholder="Enter the pet name" [(ngModel)]="data.name">
      </mat-form-field>
      
      <button mat-button (click)="onCreateClick()">Create</button>
      <button mat-button (click)="onCancelClick()">Cancel</button>
    </div>
  `
})
export class NewPetExampleDialog {

  constructor(
    public dialogRef: MatDialogRef<NewPetExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onCancelClick(): void {
    this.dialogRef.close();
  }
  
  onCreateClick(): void {
    this.data.petstoreService.createPet({"name": this.data.name});
    this.dialogRef.close();
  }

}
