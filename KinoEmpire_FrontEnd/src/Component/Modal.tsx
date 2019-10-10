import React, { Component } from 'react'
import { MDBContainer, MDBBtn, MDBModal, MDBModalHeader, MDBModalBody, MDBModalFooter } from 'mdbreact';
import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/Col';

interface Props {
    toggle?: (m?: any) => void,
    modalProps?: any;
    genres?: any[];
}
interface State {
    viewings: any[]
}

class Modal extends Component<Props, State> {
    constructor(props: Props) {
        super(props)

        this.state = {
            viewings: []
        }
    }

    componentDidMount() {
        fetch(`http://localhost:5000/getViewingByMovieId/${this.props.modalProps.id}`)
        .then(res => res.json())
        .then(res => this.setState({ viewings : res }))
        .catch(err => console.log(err));
    }

    render() {
        return (
            <div>
                <MDBContainer>
                    <MDBModal isOpen={true} toggle={this.props.toggle}>
                        <MDBModalHeader style={{ color: "black" }} toggle={this.props.toggle}>{this.props.modalProps.title}</MDBModalHeader>
                        <MDBModalBody style={{ color: "black" }}>
                    {this.state.viewings.map(viewing => {
                        return <div><a key={viewing.id} href={'/viewing/' + viewing.id}>{viewing.date}</a> <br/></div>
                    })}
                        </MDBModalBody>
                        <MDBModalFooter>
                            <MDBBtn color="secondary" onClick={this.props.toggle}>Luk</MDBBtn>
                        </MDBModalFooter>
                    </MDBModal>
                </MDBContainer>
            </div>
        )
    }
}

export default Modal
