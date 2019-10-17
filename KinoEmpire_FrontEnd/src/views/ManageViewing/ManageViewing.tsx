import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from "react-bootstrap/Col";
import Notification from '../../Component/Notification/Notification';

interface ManageViewingProps {}

interface ManageViewingState {
    sal: any[];
    movies: any[];
    date: string;
    movieInput: string;
    salInput: string;
    salId: string;
    movieId: string;
    viewingAdded: boolean;
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
            mid: this.state.movieId,
            theaterId: this.state.salId,
            date: this.state.date
        }
        
        fetch(`http://localhost:5000/createViewing`, {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(res => res.json())
            .then(res => {
                this.setState({ viewingAdded: true })
            })
            .catch(err => console.log(err));
    }
    
    private onChangeDate = (e: any) => {
        this.setState({ date : e.target.value })
    }

    private onChangeMovieId = (e: any) => {
        this.state.movies.filter(temp => {
            if (temp.title === e.target.value) {
                
                this.setState({ movieId: temp.id })
            }
            this.setState({ movieInput: e.target.value })
        })
    }

    private onChangeSal = (e: any) => {
        this.state.sal.filter(temp => {
            if (temp.id == e.target.value) {
                this.setState({ salId: temp.id })
            }
        })
    }

    constructor(props: ManageViewingProps) {
        super(props);
        this.state = {
            sal: [],
            salId: '',
            movies: [],
            date: '',
            movieId: '',
            movieInput: '',
            salInput: '',
            viewingAdded: false
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
                            <Form.Control as="select" value={this.state.salId} onChange={this.onChangeSal}>
                                {this.state.sal.map(s => {
                                    return <option>{s.id}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    <Form.Group controlId="formGridAddress1">
                        <Form.Label>Dato og tidspunkt</Form.Label>
                        <Form.Control type="datetime-local" placeholder="Indsæt dato" value={this.state.date} onChange={this.onChangeDate} />
                    </Form.Group>

                    <Button variant="success" type="submit" onClick={this.addViewing}>
                        Opret forestilling
  </Button>
                </Form>
                {this.state.viewingAdded ? <Notification title="Det lykkedes!" message="Forestillingen er nu blevet tilføjet" /> : null}
            </div>
        )
    }

}

export default ManageViewing;