import { Bank } from "react-bootstrap-icons";

function NewPayment() {
  return (
    <div className="card border-0">
      <div className="card-header display-6">
        <Bank /> New Payment
      </div>
      <div className="card-body">
        <form>
          <div className="form-group">
            <label htmlFor="readingVal"> Amount</label>
            <input
              type="text"
              className="form-control"
              placeholder="£ Amount"
              id="readingVal"
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="meterReadingDate">Date</label>
            <input
              type="date"
              className="form-control"
              id="meterReadingDate"
              required
            />
          </div>
          <div className="form-group">
            <label>Meter Type</label>
            <select className="form-select" aria-label="Meter Type">
              <option selected>Electric</option>
              <option value="1">Gas</option>
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
