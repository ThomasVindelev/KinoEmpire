import React from 'react';
import '../Home/Home.css';
import CardItem from '../Home/Card/CardItem';
import Spinner from 'react-bootstrap/Spinner';

interface StatsState {
    totalSeats: number;
    totalViewings: number;
    loaded: boolean;
}

interface StatsProps {
    
}

class Stats extends React.Component<StatsProps, StatsState> {

    constructor(props: StatsProps) {
        super(props);
        this.state = {
            totalSeats: 0,
            totalViewings: 0,
            loaded: false
        }
    }

    componentDidMount() {
        fetch('http://localhost:5000/getSoldSeats')
        .then(res => res.json())
        .then(res => this.setState({ totalSeats: res }))
        .then(() => {
            fetch('http://localhost:5000/getViewingCount')
            .then(res => res.json())
            .then(res => this.setState({ totalViewings: res, loaded: true }))
        });
    }

    render() {
        return (
            <React.Fragment>
                {this.state.loaded ? <div className="Cards">
                <CardItem url="#" cardTitle="Antal solgte sæder" favicon="fas fa-couch" stat={this.state.totalSeats} />
                <CardItem url="#" cardTitle="Forestillinger i alt" favicon="fas fa-ticket-alt" stat={this.state.totalViewings} />
                <CardItem url="#" cardTitle="Omsætning i kr" favicon="fas fa-dollar-sign" stat={this.state.totalSeats * 115} />
            </div> : <Spinner
            animation="grow"
            style={{
              display: "block",
              position: "fixed",
              top: "50%",
              right: "50%"
            }}
          />}
            </React.Fragment>
        )
    }

}

export default Stats;