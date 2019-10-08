import React, { Component } from "react";
import "./MovieBox.css";

interface MovieBoxProps {
  movie: Movie;
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

export default class MovieBox extends Component<MovieBoxProps> {
  render() {
    return (
      <React.Fragment>
        <div className="MovieBox">
          <div className="bg"></div>
          <div className="MoviePic">
            <img
              src="https://www.nfbio.dk/sites/default/files/styles/movie_poster_homepage/public/movies/gooseboy_plakat.jpg?itok=IIxvCOL2"
              alt="moviepic"
            />
            <div className="MovieText">
              <h1>{this.props.movie.title}</h1>
              <h6 className="MovieTextTime">
                Theater 1
                <br />
                {this.props.date}
              </h6>
              <span className="MovieTextInfo">
              {this.props.movie.length} minutter forventet 
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
