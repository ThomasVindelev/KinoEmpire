import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from "react-bootstrap/Col";

interface ManageViewingProps {

}

interface ManageViewingState {
    sal: string[];
    movies: string[];
    time: string[];
}

class ManageViewing extends React.Component<ManageViewingProps, ManageViewingState> {

    constructor(props: ManageViewingProps) {
        super(props);
        this.state = {
            sal: ["Sal 1", "Sal 2"],
            movies: ["Peter Plys", "Far til Fire"],
            time: ["09/10-2019 14:15-15:45", "09/10-2019 15:50-17:20", "09/10-2019 17:30-19:00"]
        }
    }

    render() {
        return (
            <div>
                <Form>
                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Film</Form.Label>
                            <Form.Control as="select">
                                {this.state.movies.map(m => {
                                    return <option>{m}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Sal</Form.Label>
                            <Form.Control as="select">
                                {this.state.sal.map(s => {
                                    return <option>{s}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Tidspunkt</Form.Label>
                            <Form.Control as="select">
                                {this.state.time.map(t => {
                                    return <option>{t}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    <Button variant="success" type="submit">
                        Tilføj tidspunkt
  </Button>
                </Form>
            </div>
        )
    }

}

export default ManageViewing;