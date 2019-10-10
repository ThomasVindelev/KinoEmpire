import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from "react-bootstrap/Col";

interface ManageViewingProps {

}

interface ManageViewingState {
    sal: any[];
    movies: any[];
    time: string;
    movieInput: string;
    salInput: string;
}

class ManageViewing extends React.Component<ManageViewingProps, ManageViewingState> {

    componentDidMount() {
        this.getInfo();
    }

    private getInfo = () => {
        fetch('http://localhost:5000/getMovieTitles')
        .then(res => res.json())
        .then(res => this.setState({ movies: res }))
        .then(() => {
            fetch('http://localhost:5000/theater')
            .then(res => res.json())
            .then(res => this.setState({ sal : res }))
            .catch(err => console.log(err));
        })
        .catch(err => console.log(err));
    }
    
    private onChangeDate = (e: any) => {
        this.setState({ time : e.target.value })
    }

    private onChangeMovie = (e: any) => {
        this.setState({ movieInput : e.target.value })
    }

    private onChangeSal = (e: any) => {
        this.setState({ salInput : e.target.value })
    }

    constructor(props: ManageViewingProps) {
        super(props);
        this.state = {
            sal: [],
            movies: [],
            time: '',
            movieInput: '',
            salInput: ''
        }
    }

    render() {
        return (
            <div>
                <Form>
                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Film</Form.Label>
                            <Form.Control as="select" value={this.state.movieInput} onChange={this.onChangeMovie}>
                                {this.state.movies.map(m => {
                                    return <option>{m.title}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Sal</Form.Label>
                            <Form.Control as="select" value={this.state.salInput} onChange={this.onChangeSal}>
                                {this.state.sal.map(s => {
                                    return <option>{s.id}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    <Form.Group controlId="formGridAddress1">
                        <Form.Label>Aldersbegrænsning</Form.Label>
                        <Form.Control type="datetime-local" placeholder="Indsæt dato" value={this.state.time} onChange={this.onChangeDate} />
                    </Form.Group>

                    <Button variant="success" type="submit">
                        Tilføj tidspunkt
  </Button>
                </Form>
            </div>
        )
    }

}

export default ManageViewing;