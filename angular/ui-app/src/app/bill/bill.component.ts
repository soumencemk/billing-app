import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { AverageBill, BillObject } from './bill.model';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})
export class BillComponent implements OnInit {

  billData: BillObject[] = [];
  averageBillData: AverageBill[] = [];
  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    this.getBill().subscribe(
      bill => {
        this.billData = bill;
      });

    this.getAvg().subscribe(avgBill => {
      this.averageBillData = avgBill;
    });


  }
  getBill() {
    return this.httpClient.get<BillObject[]>("http://validator-tests:9191/simple-billing/bill/current");
  }

  getAvg() {
    return this.httpClient.get<AverageBill[]>("http://validator-tests:9191/simple-billing/bill/monthPredict");
  }


}
