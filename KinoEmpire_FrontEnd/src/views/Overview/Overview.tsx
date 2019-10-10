import React, { Component } from "react";
import MovieBox from "./MovieBox/MovieBox";
import TicketContainer from "./TicketContainer/TicketContainer";
import Spinner from "react-bootstrap/Spinner";
import { RouteComponentProps } from "react-router-dom";

interface overviewState {
  isLoaded: boolean;
  seatsSelected: any[];
  movie: any;
  theater: undefined;
  date: string;
}

interface Movie {
  title: string;
  description?: string;
  length: string;
  age_limit: string;
  genre: {
    name: string;
  }
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
      seatsSelected: [],
      movie: undefined,
      theater: undefined,
      date: ''
    };
  }

  componentDidMount() {
   this.getSeats();
  }

  private getSeats = () => {
    fetch(`http://localhost:5000/getViewing/${this.props.match.params.id}`)
      .then(res => res.json())
      .then(res => {
        this.setState({ 
          movie : res.movie,
          theater: res.theater,
          date: res.date })
      })
      .then(() => {
        fetch(`http://localhost:5000/getSeats/${this.props.match.params.id}`)
        .then(res => res.json())
        .then(res => this.setState({ 
          seatsSelected : res.seating,
          isLoaded: true }))
      })
      .catch(err => console.log(err)) 
  }

  render() {
    return (
      <div>
        {this.state.isLoaded ? (
          <div>
            <MovieBox movie={this.state.movie} date={this.state.date} theaterId={0} /> <TicketContainer 
            id={this.props.match.params.id} 
            selected={this.state.seatsSelected}
            theater={this.state.theater}
            />
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
