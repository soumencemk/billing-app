import axios from "axios";
import { useEffect, useState } from "react";
import Grid from "./Grid";
import { Tag } from "react-bootstrap-icons";
import Loading from "./Loading";

const RATES_URL = "http://localhost:9191/simple-billing/rates";

const columns = [
  {
    name: "Meter Type",
    selector: "meterType",
  },
  {
    name: "Rate",
    selector: (row) => "£ " + row.rate,
  },
  {
    name: "Standing Charge",
    selector: (row) => "£ " + row.standingCharge,
  },
];
function Rates() {
  const [rates, setRates] = useState([]);
  useEffect(() => {
    axios.get(RATES_URL).then((response) => {
      setRates(response.data);
    });
  }, []);
  return (
    <div className="card border-0">
      <div className="card-header display-6">
        <Tag /> Rates
      </div>
      <div className="card-body">
        {rates.length === 0 && <Loading />}
        {rates.length !== 0 && <Grid columns={columns} data={rates}></Grid>}
      </div>
    </div>
  );
}

export default Rates;
