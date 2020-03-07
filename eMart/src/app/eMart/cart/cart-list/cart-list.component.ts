import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { Item } from '../../item';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {
cartItems: any;
showCart:boolean;
  constructor(protected emartservice : EmartService) { }

  ngOnInit(): void {
   
    this.cartItems=this.emartservice.getAllCart();
    console.log(this.cartItems);
    if(this.cartItems.length==[])
    {
      this.showCart=false;
    }
    else{
      this.showCart=true;
    }
    }
deleteCartItem(itemId: number)
  {
    this.emartservice.deleteCartItem(itemId);
    this.cartItems=this.emartservice.getAllCart();
  }
}
