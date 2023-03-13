import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-old-readings',
  templateUrl: './old-readings.component.html',
  styleUrls: ['./old-readings.component.scss']
})
export class OldReadingsComponent implements OnInit, AfterViewInit {
  dataSource: any
  displayedColumns: string[] = ['id', 'meterType', 'meterReadingValue', 'submitDate'];

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource()
    this.getOldReadings().subscribe(readings => {
      this.dataSource.data = readings;
    });
  }

  getOldReadings() {
    return this.httpClient.get("http://validator-tests:9191/simple-billing/reading/historical");
  }

}
