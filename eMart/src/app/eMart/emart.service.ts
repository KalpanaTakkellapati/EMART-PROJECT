import { Injectable } from '@angular/core';
import { Category } from './category';
import { SubCategory } from './sub-category';
import { Item } from './item';
import { Cart } from './cart';
import { Bill } from './bill';
import { Buyer } from './buyer';
import { Seller } from './seller';
import { ɵangular_packages_platform_browser_platform_browser_d } from '@angular/platform-browser';

import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmartService {
  categories : Category[];
  subCategories : SubCategory[];
  allItems : Item[]; 
  cartItems : Item[];
  //items: Item[];
  //cart: Cart;
  //allBills = [];
  allBills:any;
  currentBuyer:any;
  //allBuyers:  Buyer[];
  allSellers: Seller[];

  
  
  
  constructor(protected http:HttpClient) {
    /*this.categories = [{
      id : 101,
      name : 'Electronics',
      brief : 'varieties of electronics like tv, ac,fridge etc'
    },
    {
        id : 102,
        name : 'Footwear',
        brief : 'varieties of footwear slippers,flipflops etc'
    },
    {
      id : 103,
        name : 'Clothes',
        brief : 'varieties of clothes like sarees,tops,kurthies etc'
    }
 ];
this.subCategories = [{
        id : 501,
        name :'TV',
        categoryId : 101,
        brief : 'LED HD',
        gstPercent : 10
      },
      {
        id : 502,
        name :'Mobile',
        categoryId : 101,
        brief : 'Liquid Retina display',
        gstPercent : 10
      },
      {
        id : 503,
        name :'Shoes',
        categoryId : 102,
        brief : 'shoes from nike',
        gstPercent : 5
      },
      {
        id : 504,
        name :'Slippers',
        categoryId : 102,
        brief : 'smooth and water proof',
        gstPercent : 2
      },
      {
        id : 505,
        name :'Winterwear',
        categoryId : 103,
        brief : 'Leather coated',
        gstPercent : 20
      },
      {
        id : 506,
        name :'Saree',
        categoryId : 103,
        brief : 'Cotton fabric',
        gstPercent : 18
      }];
this.allItems = [{
      id : 701,
      name : 'Samsung TV',
      categoryId : 101,
      subCategoryId : 501,
      price : 50000,
      description : 'Smart HD TV',
      stock : 500,
      remarks : 'good',
      image : 'https://images.unsplash.com/photo-1558888401-3cc1de77652d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
   },
  {
    id : 702,
    name : 'Sony TV',
    categoryId : 101,
    subCategoryId : 501,
    price : 60000,
    description : 'Smart HD TV,with 3d display',
    stock : 498,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1580897275296-87979517bd4c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 703,
    name : 'iphone XR',
    categoryId : 101,
    subCategoryId : 502,
    price : 50000,
    description : 'Liquid Retina display',
    stock : 5000,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1580770485090-ccc803e2d4d3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 704,
    name : 'OnePlus 7T',
    categoryId : 101,
    subCategoryId : 502,
    price : 34999,
    description : 'Dual Core processor',
    stock : 10000,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1549846130-54aa06586995?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 705,
    name : 'Sparx Canvas shoes',
    categoryId : 102,
    subCategoryId : 503,
    price : 6999,
    description : 'Cushioned footbed',
    stock : 200,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1543508282-5c1f427f023f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 706,
    name : 'Hybrid NX shoes',
    categoryId : 102,
    subCategoryId : 503,
    price : 7999,
    description : 'Textured and patterned outsole',
    stock : 658,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1460353581641-37baddab0fa2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 707,
    name : 'Earton slippers',
    categoryId : 102,
    subCategoryId : 504,
    price : 389,
    description : 'Trending and Unique Style Flip Flops',
    stock : 509,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1564609116497-e14884a2dc28?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 708,
    name : 'Kreuzer slippers',
    categoryId : 102,
    subCategoryId : 504,
    price : 559,
    description : 'Men Synthetic Leather Flip Flops',
    stock : 345,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1543420629-5350879dd4cd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 709,
    name : 'contrast lined fraux coat',
    categoryId : 103,
    subCategoryId : 505,
    price : 559,
    description : 'Wine Floral Asymmetric Hem Shrug',
    stock : 109,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1569150357193-9882dc28496d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 710,
    name : 'Contrast Lined Faux Fur Hood Parka Coat',
    categoryId : 103,
    subCategoryId : 505,
    price : 1499,
    description : 'Fog Grey Plain Puffer Jacket',
    stock : 324,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1571063965701-a40072cdc65d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'

  },
  {
    id : 711,
    name : 'Tikhi Imli',
    categoryId : 103,
    subCategoryId : 506,
    price : 1998,
    description : 'Black Embellished Poly Georgette Saree',
    stock : 1345,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1559548160-f30d317a4e90?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'
  },
  {
    id : 712,
    name : 'GoSriKi',
    categoryId : 103,
    subCategoryId : 506,
    price : 1998,
    description : 'Black & Grey Art Silk Colourblocked Mysore Silk Saree',
    stock : 678,
    remarks : 'good',
    image : 'https://images.unsplash.com/photo-1578681140818-d89e3f986631?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60' 
  }];*/
  /*
{
  this.allBuyers = [{
    id:101,
    username:'kalpana',
    password:'kal',
    email:'kal@gmailcom',
    mobile:7729880770,
    date:'19/02/2020'
  },
  {
    id:102,
    username:'sindhu',
    password:'sin',
    email:'sindhu@gmailcom',
    mobile:6303799615,
    date:'19/02/2022'
  }];
this.allSellers = [{
    id:201,
    username:'Ashu',
    password:'ashu',
    company:'abc',
    gst:6,
    brief:"description",
    address:'Chennai',
    email:'ashu@gmail.com',
    website:'alibaba.com',
    contact:9876543210
  },
  {
    id:202,
    username:'kalpana',
    password:'kalpi',
    company:'xyz',
    gst:7,
    brief:"description",
    address:'Chennai',
    email:'kalpana@gmail.com',
    website:'kalpana.com',
    contact:8974561320
  }];*/

  this.cartItems =[];
  this.allBills = [];
  
}
getAllItems(): any{
  return this.http.get("http://localhost:8043/emart/item/all");
}
getCategories(): Category[]
{
  return[].concat(this.categories);
}
getSubCategories(): SubCategory[]
{
  return[].concat(this.subCategories);
}
getAllBills():any{
return this.allBills;
}
setBuyerAndBills(currentBuyer){
  this.currentBuyer = currentBuyer;
  this.allBills = currentBuyer.allBills;
}
getcurrentBuyer(){
  console.log(this.currentBuyer);
  return this.currentBuyer;
}
getItem(itemId:string) :any{
return this.http.get("http://localhost:8043/emart/item/"+itemId);
}
 /* let item: Item;
  let size = this.allItems.length;
  for(let i=0;i<size;i++)
  {
      if(this.allItems[i].id == +itemId){
            //item = this.allItems[i];
            item = {
              id : this.allItems[i].id,
              name : this.allItems[i].name,
              categoryId : this.allItems[i].categoryId,
              subCategoryId : this.allItems[i].subCategoryId,
              price : this.allItems[i].price,
              description : this.allItems[i].description,
              stock : this.allItems[i].stock,
              remarks : this.allItems[i].remarks,
              image : this.allItems[i].image  
            }
            break;
    }
  }
  return item;*/

addToCart(item:any)
{
  this.cartItems.push(item);
}

  getAllCart()
  {
        return [].concat(this.cartItems);
  }
deleteCartItem(itemId: number)
{
  let size = this.cartItems.length;
  for(let i=0;i<size;i++)
  {
      if(this.cartItems[i].id == itemId)
      {
        this.cartItems.splice(i,1);
      }
  }
}
addBill(Date:Date, amount: number) {
  let allBillDetails:any[] = [];
for(let i=0;i<this.cartItems.length;i++){
  allBillDetails.push({
    billDetailsId:0,
    bill:null,
    item:this.cartItems[i]
  })
}
  let bill: any = {
    id: 0,
     type: 'Debit',
    date: Date,
    remarks: 'good',
    item: this.cartItems,
    amount: amount,
    buyer:{
      id:this.currentBuyer.id
    },
    allBillDetails:allBillDetails
  }
  this.allBills.push(bill);
  this.cartItems = [];
  console.log("before:" +JSON.stringify(bill));
  return this.http.post("http://localhost:8043/emart/bill",bill);

}
getBuyer(){
return this.http.get("http://localhost:8043/emart/buyer/"+this.currentBuyer.id);
}


  validateBuyer(username:string,password:string){
    /*let buyer: Buyer;
    let size = this.allBuyers.length;
    for(let i=0;i<size;i++)
    {
      if(this.allBuyers[i].username==username && this.allBuyers[i].password==password)
      {
        buyer = {
                  id:this.allBuyers[i].id,
                  username: this.allBuyers[i].username,
                  password: this.allBuyers[i].password,
                  email: this.allBuyers[i].email,
                  date: this.allBuyers[i].date,
                  mobile: this.allBuyers[i].mobile
        }
        break;
      }
    }
    return buyer;*/
    let crendential = username+ ':' +password;
  let headers = new HttpHeaders();
  headers = headers.set('Authorization', crendential);
  return this.http.get("http://localhost:8043/emart/validate",{headers});
  }

  


 validateSeller(username:string,password:string){
    let seller: Seller;
    let size = this.allSellers.length;
    for(let i=0;i<size;i++)
    {
      if(this.allSellers[i].username==username && this.allSellers[i].password==password)
      {
        seller = {
                  id:this.allSellers[i].id,
                  username: this.allSellers[i].username,
                  password: this.allSellers[i].password,
                  email: this.allSellers[i].email,
                  company:this.allSellers[i].company,
                  gst:this.allSellers[i].gst,
                  brief:this.allSellers[i].brief,
                  address:this.allSellers[i].address,
                  website:this.allSellers[i].website,
                  contact:this.allSellers[i].contact
        }
        break;

      }
    }
    return seller;
  }
}
