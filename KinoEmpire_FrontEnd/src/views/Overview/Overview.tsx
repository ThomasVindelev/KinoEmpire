import React, { Component } from "react";
import MovieBox from "./MovieBox/MovieBox";
import TicketContainer from "./TicketContainer/TicketContainer";
import Spinner from "react-bootstrap/Spinner";

interface overviewProps {}

interface overviewState {
  isLoaded: boolean;
}

export default class Overview extends Component<overviewProps, overviewState> {
  constructor(props: overviewProps) {
    super(props);
    this.state = {
      isLoaded: false
    };
  }

  private load = () => {
      return new Promise((resolve, reject) => {
        setTimeout(resolve, 1000);
      })
  }

  componentDidMount() {
      this.load()
      .then(res => this.setState({ isLoaded: true }))
  }

  render() {
    return (
      <div>
        {this.state.isLoaded ? (
          <div>
            <MovieBox title={"Gooseboy"} /> <TicketContainer />
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
