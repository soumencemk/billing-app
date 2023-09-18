import "bootstrap/dist/css/bootstrap.min.css";
import Heading from "./components/Heading";
import Rates from "./components/Rates";
import { Route, Switch } from "react-router-dom";
import MeterReading from "./components/MeterReading";
import Payment from "./components/Payment";
import HistoricalReadings from "./components/HistoricalReadings";
import Bills from "./components/Bills";
import "./main.css";
import NewMeterReading from "./components/NewMeterReading";
import NewPayment from "./components/NewPayment";

function App() {
  return (
    <div className="container">
      <div className="col gx-5">
        <Heading></Heading>
        <Switch>
          <Route exact path="/" component={Bills} />
          <Route path="/Rates" component={Rates} />
          <Route path="/MeterReading" component={MeterReading} />
          <Route path="/Payment" component={Payment} />
          <Route path="/History" component={HistoricalReadings} />
          <Route path="/Bills" component={Bills} />
          <Route path="/NewMeterReading" component={NewMeterReading} />
          <Route path="/NewPayment" component={NewPayment} />
        </Switch>
      </div>
      <footer>
        <div className="text-center p-5 small">
          © 2023 Copyright:
          <a className="text-reset" href="https://soumencemk.github.io/">
            https://soumencemk.github.io/
          </a>
        </div>
      </footer>
    </div>
  );
}

export default App;
