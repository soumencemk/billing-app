import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { RateService } from './rate.service';

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.scss']
})
export class RateComponent implements OnInit {
  dataSource: any
  displayedColumns: string[] = ['meterType', 'rate', 'standingCharge','action'];
  constructor(private rateService: RateService) { }
  ngOnInit(): void {
    this.dataSource = new MatTableDataSource()
    this.rateService.getRates().subscribe(rate => {
      this.dataSource.data = rate;
    });

  }
}
