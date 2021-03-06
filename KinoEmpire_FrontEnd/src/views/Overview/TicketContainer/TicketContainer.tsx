import React, { Component } from "react";
import "./TicketContainer.css";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { RouteComponentProps, withRouter } from "react-router-dom";

interface ticketState {
  ticketPrice: number;
  tickets: number;
  totalAmount: number;
  allSelected: any[];
  seat: any[];
  row: any[];
}

interface ticketProps {
  selected: any[];
  id: string;
  theater: any;
}

class TicketContainer extends Component<ticketProps, ticketState> {

  constructor(props: any) {
    super(props);
    this.state = {
      tickets: 0,
      totalAmount: 0,
      allSelected: [],
      ticketPrice: 115,
      seat: [],
      row: []
    };
  }

  componentDidMount() {
    let seatArray = [];
    let rowArray = [];

    let row = 0;
    let seat = 0;

    if(this.props.theater.id === 1) {
      row = 12;
      seat = 20;
    } else {
      row = 16;
      seat = 25;
    }

    for(let i = 1;i<=row;i++) {
      rowArray[i] = i;
    }
    for(let i = 1;i<=seat;i++) {
      seatArray[i] = i;
    }

    this.setState({ seat: seatArray, row: rowArray })

  }

  private handleSubmit = (e: any) => {
    e.preventDefault();
    fetch(`http://localhost:5000/reserveSeats/${this.props.id}`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(this.state.allSelected) // body data type must match "Content-Type" header
        })
        .then(() => {
         
        })
  }

  private handlePlus = () => {
    let prevState = this.state.tickets;
    if (this.state.tickets < 10) {
      this.setState({ tickets: prevState + 1 });
    }
  };

  private handleMinus = () => {
    if (this.state.tickets > 0) {
      let prevState = this.state.tickets;
      this.setState({ tickets: prevState - 1 });
    }
    if (this.state.tickets <= this.state.allSelected.length) {
      let tempArray = this.state.allSelected;
      tempArray.splice(this.state.tickets - 1, 1);
      this.setState({ allSelected: tempArray });
    }
  };

  render() {
    return (
      <div className="TicketContainer">
        <div className="TicketSelecter">
          <h5>Vælg antal billetter</h5>
          <div className="buttonTockle">
            <Button
              variant="danger"
              size="lg"
              onClick={this.handleMinus}
              active
            >
              -
            </Button>
            <div className="ticketValue">{this.state.tickets}</div>
            <Button variant="danger" size="lg" onClick={this.handlePlus} active>
              +
            </Button>
          </div>
          <div className="seatInfo">
            Følgende pladser er valgt:
            {this.state.allSelected ? (
              <React.Fragment>
                {this.state.allSelected.map((selected, index) => {
                  return (
                    <React.Fragment key={index}>
                      <br />
                      Række: {selected.row}, Sæde: {selected.seat}
                    </React.Fragment>
                  );
                })}
              </React.Fragment>
            ) : null}
          </div>
          <Card
            bg="light"
            style={{ width: "15rem", marginTop: "30px", color: "black" }}
          >
            <Card.Body>
              <Card.Title>
                <div className="totalContainer">
                  <div>
                    <strong>{this.state.tickets}</strong> billet(ter)
                  </div>
                  <div>
                    Total <strong>{this.state.tickets * this.state.ticketPrice}</strong> ,-
                  </div>
                </div>
              </Card.Title>
              <Card.Text>
                <Button
                  onClick={this.handleSubmit}
                  variant="success"
                  size="lg"
                  block
                  style={{ marginTop: "20px" }}
                >
                  Køb sæder
                </Button>
              </Card.Text>
            </Card.Body>
          </Card>
        </div>
        <div className="seats">
          {this.state.seat.map((seat, index) => {
            return (
              <div className="seat" key={index}>
                {this.state.row.map((row, index) => {
                  let bgColor =
                    this.state.allSelected.filter(
                      temp => temp.seat === seat && temp.row === row
                    ).length > 0
                      ? "#ffff00" : this.props.selected.filter(temp => temp.seat === seat && temp.row === row).length > 0 ? "#bd2130" : "#28a745";
                  return (
                    <div
                      className="row"
                      key={index}
                      style={{ background: bgColor }}
                      onClick={e => {
                        let newSelected = this.state.allSelected;
                        if (newSelected.length < this.state.tickets) {
                          if (
                            newSelected.filter(
                              temp => temp.seat === seat && temp.row === row
                            ).length === 0 && this.props.selected.filter(temp => temp.seat === seat && temp.row === row).length === 0
                          ) {
                            newSelected.push({ seat: seat, row: row });
                            this.setState({ allSelected: newSelected });
                          }
                        }
                      }}
                    />
                  );
                })}
              </div>
            );
          })}
        </div>
      </div>
    );
  }
}

export default TicketContainer;
