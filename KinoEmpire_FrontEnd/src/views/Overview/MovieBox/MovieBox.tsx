import React, { Component } from "react";
import "./MovieBox.css";

interface MovieBoxProps {
  title: string;
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
              <h1>{this.props.title}</h1>
              <h6 className="MovieTextTime">
                Theater 1
                <br />
                Søn, 6. okt 2019, 14:00
              </h6>
              <span className="MovieTextInfo">
                1 time 27 minutter Forventet 
                <br/>sluttidspunkt: 15:47 
                <br/>Tilladt for alle
              </span>
            </div>
          </div>
        </div>
      </React.Fragment>
    );
  }
}
