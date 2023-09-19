import axios from "axios";
import { useEffect, useState } from "react";
import Grid from "./Grid";
import { Bank } from "react-bootstrap-icons";
import Loading from "./Loading";
import { Link } from "react-router-dom";
const PAYMENT_URL = import.meta.env.VITE_API_URL + "/simple-billing/payment";
const columns = [
  {
    name: "ID",
    selector: "id",
  },
  {
    name: "Date",
    selector: "paymentDate",
    sortable: true,
  },
  {
    name: "Amount",
    selector: row => "£ "+row.amount,
    sortable: true,
  },
  {
    name: "Meter",
    selector: "meterType",
    sortable: true,
  },
];
function Payment() {
  const [payment, setPayment] = useState([]);
  useEffect(() => {
    axios.get(PAYMENT_URL).then((response) => {
      setPayment(response.data);
    });
  }, []);
  return (
    <>
      <div className="card border-0">
        <div className="card-header display-6">
          <Bank /> Payment
        </div>
        <div className="card-body">
        {payment.length == 0 && <Loading />}
        <Link to="/NewPayment" className="btn btn-outline-primary btn-sm shadow">
            New Payment
          </Link>
          <Grid columns={columns} data={payment}></Grid>
        </div>
      </div>
    </>
  );
}

export default Payment;
