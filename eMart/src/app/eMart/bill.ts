import { Item } from './item';

export interface Bill
{
    id : number,
    buyerId : number,
    type : string,
    date : Date,
    remarks : string,
    item: Item[],
    amount : number 
}
