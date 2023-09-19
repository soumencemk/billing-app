import axios from "axios";
import { useState } from "react";
import { Book } from "react-bootstrap-icons";

const NEW_METER_READING_URL =
import.meta.env.VITE_API_URL + "/simple-billing/reading/submit";

function NewMeterReading() {
  const [formValue, setformValue] = useState({
    meterType: "",
    readingDate: "",
    readingValue: "",
    isStartingReading: "false",
  });

  const [message, setmessage] = useState("");

  const handleChange = (event) => {
    const value =
      event.target.type === "checkbox"
        ? event.target.checked
        : event.target.value;
    setformValue({
      ...formValue,
      [event.target.name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post(NEW_METER_READING_URL, formValue)
      .then((response) => {
        console.log("Response");
        console.log(response);
        setmessage(
          "Meter reading " +
            formValue.readingValue +
            " Submitted successfully !"
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
        <Book /> New Meter Reading
      </div>
      {message && (
        <div className="alert alert-primary" role="alert">
          {message}
        </div>
      )}
      <div className="card-body">
        <form onSubmit={handleSubmit}>
          <div className="row form-group">
            <div className="col">
              <label htmlFor="readingVal"> Reading</label>
              <input
                type="text"
                name="readingValue"
                className="form-control"
                placeholder="Meter Reading"
                value={formValue.readingValue}
                onChange={handleChange}
                required
              />
            </div>
            <div className="col">
              <label htmlFor="meterReadingDate">Date</label>
              <input
                type="date"
                className="form-control"
                name="readingDate"
                id="meterReadingDate"
                value={formValue.readingDate}
                onChange={handleChange}
                required
              />
            </div>
          </div>
          <div className="form-group row">
            <div className="col">
              <label>Meter Type</label>
              <select
                className="form-select"
                aria-label="Meter Type"
                name="meterType"
                value={formValue.meterType}
                onChange={handleChange}
              >
                <option value="select">- Select - </option>
                <option value="ELECTRIC">Electric</option>
                <option value="GAS">Gas</option>
              </select>
            </div>
            <div className="col">
              <label>Starting Reading</label>
              <div className="form-check form-switch">
                <input
                  className="form-check-input"
                  type="checkbox"
                  id="startingReading"
                  name="isStartingReading"
                  checked={formValue.isStartingReading}
                  onChange={handleChange}
                />
              </div>
            </div>
          </div>
          <div className="form-group text-center">
            <hr></hr>
            <button type="submit" className="btn btn-primary btn-block">
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default NewMeterReading;
