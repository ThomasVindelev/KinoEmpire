import React, { Component } from 'react'
import CardItem from './Card/CardItem'
import './Home.css';

interface Props {}
interface State {}

class Home extends Component<Props, State> {
    constructor(props: Props) {
        super(props)

        this.state = {
            
        }
    }

    render() {
        return (
            <div className="Cards">
                <CardItem cardTitle={'Film'} url={'/movie'} favicon={'fas fa-film'} />
                <CardItem cardTitle={'Forestilling'} url={'/viewing'} favicon={'fas fa-ticket-alt'} />
            </div>
        )
    }
}

export default Home
