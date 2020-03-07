import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FnParam } from '@angular/compiler/src/output/output_ast';
import { EmartService } from '../../emart.service';
import { Item } from '../../item';

@Component({
  selector: 'app-item-display',
  templateUrl: './item-display.component.html',
  styleUrls: ['./item-display.component.css']
})
export class ItemDisplayComponent implements OnInit {
  item: Item;

  constructor(protected activatedRoute : ActivatedRoute ,
     protected emartservice :EmartService,
     protected router : Router) { }

  ngOnInit(): void {
  this.activatedRoute.paramMap.subscribe (
                                           (param)=>{
                                                let id = param.get('iId');
                                               this.emartservice.getItem(id).subscribe(
                                                 (response:any)=>{
                                                   this.item=response;
                                                 }
                                               );
      
    }
  )
 }
addTocart(item : any)
{
  this.emartservice.addToCart(item);
  this.router.navigate(['item-list']);
}
}
