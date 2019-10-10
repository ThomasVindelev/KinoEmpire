import React, { Component } from "react";
import "./MovieBox.css";

interface MovieBoxProps {
  movie: Movie;
  date: string;
  theaterId: number;
}

 interface Movie {
  title: string;
  description?: string;
  length: string;
  age_limit: string;
  img_url: string;
  genre: {
    name: string;
  }
}

export default class MovieBox extends Component<MovieBoxProps> {
  render() {
    return (
      <React.Fragment>
        <div className="MovieBox">
          <div className="bg"></div>
          <div className="MoviePic">
            <img
              src={this.props.movie.img_url}
              alt="moviepic"
            />
            <div className="MovieText">
              <h1>{this.props.movie.title}</h1>
              <h6 className="MovieTextTime">
                Sal {this.props.theaterId}
                <br />
                {this.props.date}
              </h6>
              <span className="MovieTextInfo">
              {this.props.movie.length} minutter. 
                <br/>Beskrivelse: {this.props.movie.description}
                <br/>Aldersgrænse: {this.props.movie.age_limit}
              </span>
            </div>
          </div>
        </div>
      </React.Fragment>
    );
  }
}
