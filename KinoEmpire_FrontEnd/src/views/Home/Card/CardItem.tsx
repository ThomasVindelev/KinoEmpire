import React, { Component } from 'react'
import Card from 'react-bootstrap/Card'
import './cardItem.css';

interface Props {
    cardTitle: string;
    url?: string;
    favicon?: string;
    stat?: number;
}
interface State { }

class CardItem extends Component<Props, State> {
    constructor(props: Props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div className="cardItem">
                <a href={this.props.url}>
                    <Card style={{ width: '18rem', background: "#343a40", marginRight: "15px" }}>
                        <Card.Body style={{ textAlign: 'center' }}>
                            <Card.Title >{this.props.cardTitle}</Card.Title>
                            <Card.Text>
                                <h1><i className={this.props.favicon}></i></h1>
                                {this.props.stat ? <h2>{this.props.stat}</h2> : null}
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </a>
            </div>
        )
    }
}

export default CardItem
