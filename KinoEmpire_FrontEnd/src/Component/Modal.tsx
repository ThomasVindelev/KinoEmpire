import React, { Component } from 'react'
import { MDBContainer, MDBBtn, MDBModal, MDBModalHeader, MDBModalBody, MDBModalFooter } from 'mdbreact';

interface Props { 
   
}
interface State {
    open: boolean;
}

class Modal extends Component<Props, State> {
    constructor(props: Props) {
        super(props)

        this.state = {
            open: true
        }
    }

    private toggle = () => {
        let toggle = !this.state.open;
        this.setState({ open: toggle })
    }

    render() {
        return (
            <div>
                <MDBContainer>
                    <MDBModal isOpen={this.state.open} toggle={this.toggle}>
                        <MDBModalHeader toggle={this.toggle}>MDBModal title</MDBModalHeader>
                        <MDBModalBody>
                            (...)
        </MDBModalBody>
                        <MDBModalFooter>
                            <MDBBtn color="secondary" onClick={this.toggle}>Close</MDBBtn>
                            <MDBBtn color="primary">Save changes</MDBBtn>
                        </MDBModalFooter>
                    </MDBModal>
                </MDBContainer>
            </div>
        )
    }
}

export default Modal
