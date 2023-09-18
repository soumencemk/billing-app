import { Link } from "react-router-dom";

function Heading() {
  return (
    <>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <a className="navbar-brand" href="/">
            Simple Billing
          </a>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <Link to="/Bills" className="nav-link">
                  Bills
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/MeterReading" className="nav-link">
                  Meter Reading
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/Rates" className="nav-link">
                  Rates
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/Payment" className="nav-link">
                  Payment
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/History" className="nav-link">
                  History
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </>
  );
}

export default Heading;
