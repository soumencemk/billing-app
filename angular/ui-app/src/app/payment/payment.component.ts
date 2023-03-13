import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { NewPaymentComponent } from './new-payment/new-payment.component';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  dataSource: any;
  displayedColumns: string[] = ['id', 'meterType', 'paymentDate', 'amount'];

  constructor(private httpClient: HttpClient,public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource();
    this.getPayments().subscribe(payment => {
      this.dataSource.data = payment;
    });
  }

  getPayments() {
    return this.httpClient.get("http://validator-tests:9191/simple-billing/payment");
  }


  openNewPayment() {
    const dialogRef = this.dialog.open(NewPaymentComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

}
