import axios from "axios";
import { useEffect, useState } from "react";
import {
  Calculator,
  Calendar,
  Speedometer,
  Calendar2Day,
  CurrencyPound,
  ChatLeftText,
  Receipt,
} from "react-bootstrap-icons";
import Loading from "./Loading";

const BILLS_ENDPOINT = "http://localhost:9191/simple-billing/bill/current";
const PREDICTION_ENDPOINT =
  "http://localhost:9191/simple-billing/bill/monthPredict";

function Bills() {
  const [bills, setBills] = useState([]);
  const [avgPerMonth, setAvgPerMonth] = useState([]);
  useEffect(() => {
    axios.get(BILLS_ENDPOINT).then((response) => {
      setBills(response.data);
    });
    axios.get(PREDICTION_ENDPOINT).then((response) => {
      setAvgPerMonth(response.data);
    });
  }, []);
  return (
    <>
      <div className="card border-0">
        <div className="card-header display-6">
          <Receipt /> Bills
        </div>
        <div className="card-body">
          {bills.length == 0 && <Loading />}
          <div className="container">
            <div className="row gx-5">
              {bills.map((bill) => (
                <div className="col">
                  <div className="card">
                    <div className="card-body">
                      <h5 className="card-title text-center bg-light">
                        {bill.meterType}
                      </h5>
                      <h5 className="card-title text-center">
                        {"£ " + bill.bill.actualAmount}
                      </h5>
                      <p className="card-text">
                        <table className="table-sm table-hover">
                          <tr>
                            <td>
                              <Calendar /> START DATE
                            </td>
                            <td>{bill.usageStartDate}</td>
                          </tr>
                          <tr>
                            <td>
                              <Calendar /> END DATE
                            </td>
                            <td>{bill.usageEndDate}</td>
                          </tr>
                          <tr>
                            <td>
                              <Speedometer /> UNITS
                            </td>
                            <td>{bill.unitsUsed}</td>
                          </tr>
                          <tr>
                            <td>
                              <Calendar2Day /> Days
                            </td>
                            <td>{bill.noOfDays}</td>
                          </tr>
                          <tr>
                            <td>
                              <CurrencyPound /> ACTUAL AMOUNT
                            </td>
                            <td>{"£ " + bill.bill.actualAmount}</td>
                          </tr>
                          <tr>
                            <td>
                              <CurrencyPound /> PAID AMOUNT
                            </td>
                            <td>{"£ " + bill.bill.paidAmount}</td>
                          </tr>
                          <tr>
                            <td>
                              <CurrencyPound /> BALANCE
                            </td>
                            <td>{"£ " + bill.bill.balance}</td>
                          </tr>
                          <tr>
                            <td>
                              <ChatLeftText /> MESSAGE
                            </td>
                            <td className="mark"><b>{bill.bill.message}</b></td>
                          </tr>
                          <tfoot>
                            <tr className="table-success">
                              <td>
                                <Calculator /> Average Per month
                              </td>
                              <td>
                                {avgPerMonth.map(
                                  (avgPm) =>
                                    avgPm.meterType === bill.meterType && (
                                      <span>{"£ " + avgPm.monthlyUsage}</span>
                                    )
                                )}
                              </td>
                            </tr>
                          </tfoot>
                        </table>
                      </p>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Bills;
