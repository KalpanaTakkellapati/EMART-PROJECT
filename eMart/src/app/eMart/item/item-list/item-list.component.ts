import { Component, OnInit } from '@angular/core';
import { Item } from '../../item';
import { EmartService } from '../../emart.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  allitems: any;
  emartservice: any;
  constructor(protected emart : EmartService, protected router :Router) { }

  ngOnInit(): void {
    this.emart.getAllItems().subscribe(
      (Response:any)=>{
        this.allitems=Response;
      }
    );
      }
    
   
  displayItemDetails(itemId :number)
{
  
  this.router.navigate(['/item-display/'+itemId]);
}
}
