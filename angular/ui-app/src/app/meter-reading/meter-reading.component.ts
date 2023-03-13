import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-meter-reading',
  templateUrl: './meter-reading.component.html',
  styleUrls: ['./meter-reading.component.scss']
})
export class MeterReadingComponent implements OnInit {
  dataSource: any
  displayedColumns: string[] = ['meterType', 'meterReadingValue', 'submitDate', 'startingReading'];


  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource()
    this.getReadings().subscribe(readings => {
      this.dataSource.data = readings;
    });
  }

  getReadings() {
    return this.httpClient.get("http://validator-tests:9191/simple-billing/reading/all");
  }

}
