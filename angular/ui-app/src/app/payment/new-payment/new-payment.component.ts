import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-new-payment',
  templateUrl: './new-payment.component.html',
  styleUrls: ['./new-payment.component.scss']
})
export class NewPaymentComponent implements OnInit {
  formGroup!: FormGroup;
  paymentInfo: any;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.initForm();
  }
  initForm() {
    this.formGroup = this.formBuilder.group({
      "paymentDate": "",
      "amount": "",
      "meterType": ""
    });
  }
  savePayment(paymentInfo: any) {
    console.log(paymentInfo);
  }

}
