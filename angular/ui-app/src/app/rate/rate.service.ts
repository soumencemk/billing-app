import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RateService {

  constructor(private httpClient: HttpClient) {} 

  getRates() {
    return this.httpClient.get("http://validator-tests:9191/simple-billing/rates");
  }
}
