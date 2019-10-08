import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from "react-bootstrap/Col";

interface ManageMovieProps {

}

interface ManageMovieState {
    genres: string[];
}

class ManageMovie extends React.Component<ManageMovieProps, ManageMovieState> {

    constructor(props: ManageMovieProps) {
        super(props);
        this.state = {
            genres: ["Horror", "Action"]
        }
    }

    render() {
        return (
            <div>
                <Form>
                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridEmail">
                            <Form.Label>Titel på filmen</Form.Label>
                            <Form.Control type="text" placeholder="Filmtitel" />
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridPassword">
                            <Form.Label>Længde</Form.Label>
                            <Form.Control type="text" placeholder="Længde" />
                        </Form.Group>
                    </Form.Row>
                    <Form.Group controlId="formGridAddress1">
                        <Form.Label>Aldersbegrænsning</Form.Label>
                        <Form.Control placeholder="Indsæt alder" />
                    </Form.Group>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Genre</Form.Label>
                            <Form.Control as="select">
                                {this.state.genres.map(g => {
                                    return <option>{g}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>

                    <Button variant="success" type="submit">
                        Tilføj Film
  </Button>
                </Form>
            </div>
        )
    }

}

export default ManageMovie;