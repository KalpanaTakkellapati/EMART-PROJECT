import { Component, OnInit } from '@angular/core';
import { Bill } from '../../bill';
import { EmartService } from '../../emart.service';
import { Item } from '../../item';

@Component({
  selector: 'app-bill-list',
  templateUrl: './bill-list.component.html',
  styleUrls: ['./bill-list.component.css']
})
export class BillListComponent implements OnInit {
 allBills:any;
 currentBuyer:any;
 showBill:boolean = true;
 constructor(protected emartService: EmartService) { }

  ngOnInit(): void {
    this.currentBuyer=this.emartService.getcurrentBuyer();
    this.allBills=[];
   // console.log("currentBuyer"+this.currentBuyer.allBills);
    if(this.currentBuyer!=null){
      this.allBills=this.currentBuyer.allBills;
    }
   
    console.log(this.allBills);
    if(this.allBills.length==[]){
      this.showBill=false;
    }
      
  }

}
