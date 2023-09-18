import axios from "axios";
import { useEffect, useState } from "react";
import Grid from "./Grid";
import { Book } from "react-bootstrap-icons";
import Loading from "./Loading";
import { Link } from "react-router-dom";
const METER_READING_URL = "http://localhost:9191/simple-billing/reading/all";
const columns = [
  {
    name: "ID",
    selector: "id",
    center: true,
  },
  {
    name: "Meter Type",
    selector: "meterType",
    sortable: true,
    center: true,
  },
  {
    name: "Reading",
    selector: "meterReadingValue",
    sortable: true,
    center: true,
  },
  {
    name: "Date",
    selector: "submitDate",
    sortable: true,
    center: true,
  },
  {
    name: "Starting Reading",
    selector: (row) => (row.startingReading ? "YES" : "NO"),
    sortable: true,
  },
];
function MeterReading() {
  const [readings, setReadings] = useState([]);
  useEffect(() => {
    axios.get(METER_READING_URL).then((response) => {
      setReadings(response.data);
    });
  }, []);
  return (
    <>
      <div className="card border-0">
        <div className="card-header display-6">
          <Book /> Meter Reading
        </div>
        <div className="card-body">
          {readings.length == 0 && <Loading />}
          <Link to="/NewMeterReading" className="btn btn-outline-primary btn-sm">
            New Reading
          </Link>
          <Grid columns={columns} data={readings}></Grid>
        </div>
      </div>
    </>
  );
}

export default MeterReading;
