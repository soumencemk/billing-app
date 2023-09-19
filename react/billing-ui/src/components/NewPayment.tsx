import axios from "axios";
import { useState } from "react";
import { Bank } from "react-bootstrap-icons";

const NEW_PAYMENT_URL = import.meta.env.VITE_API_URL+ "/simple-billing/payment";

function NewPayment() {
  const [formValue, setformValue] = useState({
    paymentDate: "",
    amount: "",
    meterType: "",
  });
  const [message, setmessage] = useState("");

  const handleChange = (event) => {
    const value = event.target.value;
    setformValue({
      ...formValue,
      [event.target.name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post(NEW_PAYMENT_URL, formValue)
      .then((response) => {
        console.log("Response");
        console.log(response);
        setmessage(
          "Payment - £ " + formValue.amount + " Submitted successfully !"
        );
      })
      .catch((error) => {
        console.log(error);
        setmessage(error.message);
      });
  };

  return (
    <div className="card border-0">
      <div className="card-header display-6">
        <Bank /> New Payment
      </div>
      {message && (
        <div className="alert alert-primary" role="alert">
          {message}
        </div>
      )}
      <div className="card-body">
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="readingVal"> Amount</label>
            <input
              type="text"
              className="form-control"
              placeholder="£ Amount"
              id="readingVal"
              name="amount"
              required
              value={formValue.amount}
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="meterReadingDate">Date</label>
            <input
              type="date"
              className="form-control"
              id="meterReadingDate"
              name="paymentDate"
              value={formValue.paymentDate}
              onChange={handleChange}
              required
            />
          </div>
          <div className="form-group">
            <label>Meter Type</label>
            <select
              className="form-select"
              aria-label="Meter Type"
              name="meterType"
              value={formValue.meterType}
              onChange={handleChange}
            >
              <option value="SELECT">-SELECT-</option>
              <option value="ELECTRIC">Electric</option>
              <option value="GAS">Gas</option>
            </select>
          </div>
          <hr></hr>
          <div className="form-group text-center">
            <button type="submit" className="btn btn-primary btn-block">
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default NewPayment;
