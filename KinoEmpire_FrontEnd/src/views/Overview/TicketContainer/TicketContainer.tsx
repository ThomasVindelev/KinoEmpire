import React, { Component } from "react";
import "./TicketContainer.css";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

interface ticketState {
  seat: number[];
  row: number[];
  ticketPrice: number;
  tickets: number;
  totalAmount: number;
  allSelected: any[];
}

interface ticketProps {
  selected: any[];
  id: string;
  movie: undefined,
  theater: undefined,
  date: string;
}

export default class TicketContainer extends Component<ticketProps, ticketState> {
  
  constructor(props: any) {
    super(props);
    this.state = {
      seat: [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20,
        21,
        22,
        23,
        24,
        25
      ],
      row: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
      tickets: 0,
      totalAmount: 0,
      allSelected: [],
      ticketPrice: 115
    };
  }

  private handleSubmit = (e: any) => {
    console.log(JSON.stringify(this.state.allSelected))

    e.preventDefault();
    fetch(`http://localhost:5000/reserveSeats/${this.props.id}`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(this.state.allSelected) // body data type must match "Content-Type" header
        })
            .then(res => res.json())
            .then(res => {
                console.log(res);
            })
            .catch(err => console.log(err));
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
                      ? "#3368FF" : this.props.selected.filter(temp => temp.seat === seat && temp.row === row).length > 0 ? "#bd2130" : "#28a745";
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
