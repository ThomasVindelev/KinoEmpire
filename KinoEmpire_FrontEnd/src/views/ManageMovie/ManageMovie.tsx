import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from "react-bootstrap/Col";
import Table from "react-bootstrap/Table";
import './ManageMovie.css';
import Notification from '../../Component/Notification/Notification';
import Modal from '../../Component/Modal';
import { Redirect } from 'react-router';
import Spinner from 'react-bootstrap/Spinner';

interface ManageMovieProps {

}

interface ManageMovieState {
    genres: any[];
    title: string;
    id: number;
    viewings: boolean;
    length: string;
    age_limit: string;
    description: string;
    img_url: string;
    genreInput: string;
    genreId: string;
    movies: any[];
    movieAdded: boolean;
    edit: boolean;
    modalProps: any;
    open: boolean;
    loaded: boolean;
}

class ManageMovie extends React.Component<ManageMovieProps, ManageMovieState> {

    componentDidMount() {
        this.getInfo();
    }

    getInfo = () => {
        fetch(`http://localhost:5000/getGenres`)
            .then(res => res.json())
            .then(res => this.setState({ genres: res }))
            .then(() => {
                fetch(`http://localhost:5000/movies`)
                    .then(res => res.json())
                    .then(res => this.setState({ movies: res, loaded: true }));
            });
    }

    constructor(props: ManageMovieProps) {
        super(props);
        this.state = {
            genres: [],
            id: 0,
            title: '',
            length: '',
            age_limit: '',
            description: '',
            img_url: '',
            genreInput: '',
            genreId: '',
            movies: [],
            movieAdded: false,
            edit: false,
            modalProps: null,
            open: false,
            viewings: false,
            loaded: false
        }
    }

    private toggleModal = (m?: any): void => {
        console.log(m);
        this.setState({
            edit: true,
            modalProps: m,
            title: m.title,
            length: m.length,
            age_limit: m.age_limit,
            description: m.description,
            img_url: m.img_url,
            genreInput: m.genre.name,
            id: m.id
        })
    }

    private toggleViewings = (m?: any): void => {

        this.setState({
            viewings: !this.state.viewings,
            modalProps: m
        })
    }

    private editMovie = (e: any) => {
        console.log(this.state.id);
        e.preventDefault();
        let data = {
            title: this.state.title,
            length: this.state.length,
            age_limit: this.state.age_limit,
            genreId: this.state.genreId,
            description: this.state.description,
            img_url: this.state.img_url,
            genre: {
                name: this.state.genreInput
            }
        }

        fetch(`http://localhost:5000/updateMovie/${this.state.id}`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        })
            .then(res => res.json())
            .then(() => {
                fetch(`http://localhost:5000/movies`)
                    .then(res => res.json())
                    .then(res => this.setState({ movies: res }));
            })
            .catch(err => console.log(err));
    }

    private onChangeTitle = (e: any) => {
        this.setState({ title: e.target.value })
    }

    private onChangeLength = (e: any) => {
        this.setState({ length: e.target.value })
    }

    private onChangeAgeLimit = (e: any) => {
        this.setState({ age_limit: e.target.value })
    }

    private onChangeDescription = (e: any) => {
        this.setState({ description: e.target.value })
    }

    private onChangeImgUrl = (e: any) => {
        this.setState({ img_url: e.target.value })
    }

    private onChangeGenreId = (e: any) => {
        this.state.genres.filter(temp => {
            if (temp.name === e.target.value) {
                this.setState({ genreId: temp.id })
            }
            this.setState({ genreInput: e.target.value })
        })
    }

    private addMovie = (e: any) => {
        e.preventDefault();
        let data = {
            title: this.state.title,
            length: this.state.length,
            age_limit: this.state.age_limit,
            genreId: this.state.genreId,
            description: this.state.description,
            img_url: this.state.img_url,
            genre: {
                name: this.state.genreInput
            }
        }

        console.log(data);

        fetch(`http://localhost:5000/addMovie`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        })
            .then(res => res.json())
            .then(res => {
                let tempArray = this.state.movies;
                tempArray.push(data);
                this.setState({ movies: tempArray, movieAdded: true })
            })
            .catch(err => console.log(err));
    }

    render() {
        return (
            <div>
                <Form>
                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridEmail">
                            <Form.Label>Titel på filmen</Form.Label>
                            <Form.Control type="text" placeholder="Filmtitel" value={this.state.title} onChange={this.onChangeTitle} />
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridPassword">
                            <Form.Label>Længde</Form.Label>
                            <Form.Control type="text" placeholder="Længde" value={this.state.length} onChange={this.onChangeLength} />
                        </Form.Group>
                    </Form.Row>
                    <Form.Group controlId="formGridAddress1">
                        <Form.Label>Aldersbegrænsning</Form.Label>
                        <Form.Control placeholder="Indsæt alder" value={this.state.age_limit} onChange={this.onChangeAgeLimit} />
                    </Form.Group>
                    <Form.Group controlId="formGridAddress1">
                        <Form.Label>Beskrivelse</Form.Label>
                        <Form.Control placeholder="Indsæt beskrivelse" value={this.state.description} onChange={this.onChangeDescription} />
                    </Form.Group>
                    <Form.Group controlId="formGridAddress1">
                        <Form.Label>Billede url</Form.Label>
                        <Form.Control placeholder="Indsæt url" value={this.state.img_url} onChange={this.onChangeImgUrl} />
                    </Form.Group>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Genre</Form.Label>
                            <Form.Control as="select" value={this.state.genreInput} onChange={this.onChangeGenreId}>
                                {this.state.genres.map((g, index) => {
                                    return <option key={index}>{g.name}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Form.Row>
                    {this.state.edit ? <Button variant="success" type="submit" onClick={this.editMovie}>
                        Ret film
                    </Button> : <Button variant="success" type="submit" onClick={this.addMovie}>
                            Tilføj Film
                    </Button>}

                </Form>
                <br />
                {this.state.loaded ? <Table striped bordered hover variant="dark">

<thead>
    <tr>
        <th>Titel</th>
        <th>Varighed</th>
        <th>Alder</th>
        <th>Genre</th>
        <th></th>
    </tr>
</thead>
<tbody>
    {this.state.movies.map((m, index) => {
        return (
            <tr key={m.id}>
                <td onClick={() => this.setState({ open: true })}>{m.title}</td>
                <td>{m.length}</td>
                <td>{m.age_limit}</td>
                <td>{m.genre.name}</td>
                <td className="editDelete">
                <Button style={{ width: '45%' }} key={index} variant="success" type="submit" onClick={(e: any) => this.toggleViewings(m)
                    }
                    >Forestillinger</Button>
                    <Button style={{ width: '30%' }} key={index} variant="primary" type="submit" onClick={(e: any) => this.toggleModal(m)
                    }
                    >Rediger</Button>
                    <Button key={index} variant="danger" type="submit" onClick={(e: any) => {
                        e.preventDefault();
                        console.log(m.id);
                        fetch(`http://localhost:5000/deleteMovie/${m.id}`, {
                            method: 'DELETE', // *GET, POST, PUT, DELETE, etc.
                            headers: {
                                'Content-Type': 'application/json'
                                // 'Content-Type': 'application/x-www-form-urlencoded',
                            }
                        })
                            .then(res => res.json())
                            .then(res => {
                                let tempArray = this.state.movies.filter(movie => movie.id !== m.id);
                                this.setState({ movies: tempArray })
                            })
                            .catch(err => console.log(err));
                    }}>
                        Slet
                    </Button></td>
            </tr>
        );
    })}
</tbody>
</Table> : <Spinner
            animation="grow"
            style={{
              display: "block",
              position: "fixed",
              top: "80%",
              right: "50%"
            }}
          />}
            
                {this.state.movieAdded ? <Notification title="Det lykkedes!" message="Filmen er nu blevet tilføjet" /> : null}
                {this.state.viewings ? <Modal toggle={this.toggleViewings} modalProps={this.state.modalProps}/> : null}
            </div>

        )
    }

}

export default ManageMovie;