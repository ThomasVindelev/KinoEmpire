import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from "react-bootstrap/Col";

interface ManageViewingProps {

}

interface ManageViewingState {
    sal: any[];
    movies: any[];
    date: string;
    movieInput: string;
    salInput: string;
    movieId: number;
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

    private addViewing = (e: any) => {
        e.preventDefault();
        let data = {
            movieId: this.state.movieId,
            theaterId: this.state.salInput,
            date: this.state.date
        }
        console.log(data);
        fetch(`http://localhost:5000/createViewing`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        })
            .then(res => res.json())
            .then(res => console.log(res))
            .catch(err => console.log(err));
    }
    
    private onChangeDate = (e: any) => {
        this.setState({ date : e.target.value })
    }

    private onChangeMovieId = (e: any) => {
        this.state.movies.filter(temp => {
            if (temp.name === e.target.value) {
                console.log(temp.id);
                this.setState({ movieId: temp.id })
            }
            this.setState({ movieInput: e.target.value })
        })
    }

    private onChangeSal = (e: any) => {
        this.setState({ salInput : e.target.value })
    }

    constructor(props: ManageViewingProps) {
        super(props);
        this.state = {
            sal: [],
            movies: [],
            date: '',
            movieId: 0,
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
                            <Form.Control as="select" value={this.state.movieInput} onChange={this.onChangeMovieId}>
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
                        <Form.Control type="datetime-local" placeholder="Indsæt dato" value={this.state.date} onChange={this.onChangeDate} />
                    </Form.Group>

                    <Button variant="success" type="submit" onClick={this.addViewing}>
                        Tilføj tidspunkt
  </Button>
                </Form>
            </div>
        )
    }

}

export default ManageViewing;