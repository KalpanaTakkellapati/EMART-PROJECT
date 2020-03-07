import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemListComponent } from './eMart/item/item-list/item-list.component';
import { ItemDisplayComponent } from './eMart/item/item-display/item-display.component';
import { CartListComponent } from './eMart/cart/cart-list/cart-list.component';
import { BillViewComponent } from './eMart/bill/bill-view/bill-view.component';
import { BillListComponent } from './eMart/bill/bill-list/bill-list.component';
import { LoginComponent } from './eMart/login/login.component';



const routes: Routes = [{
  path:'item-list',
  component: ItemListComponent
},
{
  path:'item-display/:iId',
  component: ItemDisplayComponent
  
},
{
  path:'cart-list',
  component: CartListComponent
},
{
  path:'bill-view',
  component: BillViewComponent
},
{
  path:'bill-list',
  component:BillListComponent
},
{
  path:'login',
  component:LoginComponent
}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
