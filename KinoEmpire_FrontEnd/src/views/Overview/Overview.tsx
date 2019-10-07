import React, { Component } from "react";
import MovieBox from "./MovieBox/MovieBox";
import TicketContainer from "./TicketContainer/TicketContainer";
import Spinner from "react-bootstrap/Spinner";
import { RouteComponentProps } from "react-router-dom";

interface overviewState {
  isLoaded: boolean;
  databaseSelected: any[];
}

interface RouteInfo {
  id: string;
}

interface ComponentProps extends RouteComponentProps<RouteInfo> {

}

export default class Overview extends Component<ComponentProps, overviewState> {
  constructor(props: ComponentProps) {
    super(props);
    this.state = {
      isLoaded: false,
      databaseSelected: []
    };
  }


  componentDidMount() {
   this.getSeats();
  }

  private getSeats = () => {
    fetch(`http://localhost:5000/getSeats/${this.props.match.params.id}`)
      .then(res => res.json())
      .then(res => {
        this.setState({ databaseSelected : res.seating, isLoaded: true })
      })
      .catch(err => console.log(err)) 
  }

  render() {
    return (
      <div>
        {this.state.isLoaded ? (
          <div>
            <MovieBox title={"Gooseboy"} /> <TicketContainer selected={this.state.databaseSelected} />
          </div>
        ) : (
          <Spinner
            animation="grow"
            style={{
              display: "block",
              position: "fixed",
              top: "50%",
              right: "50%"
            }}
          />
        )}
      </div>
    );
  }
}
