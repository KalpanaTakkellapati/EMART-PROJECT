import { Component, OnInit } from '@angular/core';
import { Item } from '../../item';
import { EmartService } from '../../emart.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bill-view',
  templateUrl: './bill-view.component.html',
  styleUrls: ['./bill-view.component.css']
})
export class BillViewComponent implements OnInit {
  cartItems: Item[];
  buyerName: string; 
  buyerId: string ;
 
  todayDate: Date = new Date();
  amount: number = 0;
  currentBuyer : any;
  constructor(protected emartService: EmartService,  protected router: Router,protected activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.cartItems = this.emartService.getAllCart();
    this.currentBuyer=this.emartService.getcurrentBuyer();
    let size = this.cartItems.length;
    for(let i=0;i<size;i++){
      this.amount = this.amount + this.cartItems[i].price
    }
  }

  addBill(){
    this.emartService.addBill(this.todayDate, this.amount).subscribe(
      (response) => {
        this.emartService
            .getBuyer()
            .subscribe(
              (response) => {
                console.log("res:"+response);
                this.currentBuyer = response;
                this.emartService.setBuyerAndBills(this.currentBuyer)


              }
            )
      }
    )
    this.router.navigate(['item-list']);
  }

}

