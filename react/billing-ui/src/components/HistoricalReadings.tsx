import axios from "axios";
import { useEffect, useState } from "react";
import Grid from "./Grid";
import { ClockHistory } from "react-bootstrap-icons";
import Loading from "./Loading";

const HISTORICAL_READINGS_URL =
  "http://localhost:9191/simple-billing/reading/historical";
const columns = [
  {
    name: "Meter Type",
    selector: "meterType",
    sortable: true,
  },
  {
    name: "Reading",
    selector: "meterReadingValue",
    sortable: true,
  },
  {
    name: "Date",
    selector: "submitDate",
    sortable: true,
  },
];
function HistoricalReadings() {
  const [readings, setReadings] = useState([]);
  useEffect(() => {
    axios.get(HISTORICAL_READINGS_URL).then((response) => {
      setReadings(response.data);
    });
  }, []);
  return (
    <>
      <div className="card border-0">
        <div className="card-header display-6">
          <ClockHistory /> Old Reading
        </div>
        <div className="card-body">
          {readings.length == 0 && <Loading />}
          <Grid columns={columns} data={readings}></Grid>
        </div>
      </div>
    </>
  );
}

export default HistoricalReadings;
