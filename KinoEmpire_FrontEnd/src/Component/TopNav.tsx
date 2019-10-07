import React, { Component } from "react";
import Navbar from "react-bootstrap/Navbar";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";
import Form from "react-bootstrap/Form";
import './TopNav.css';

export default class TopNav extends Component {
  render() {
    return (
      <div>
        <Navbar bg="dark" variant="dark" className="flex">
          <Navbar.Brand href="#home">{"Kino Empire"}</Navbar.Brand>
          <Form inline>
            <FormControl type="text" placeholder="Søg" className="mr-sm-2 search" />
            <Button variant="outline-light">Søg</Button>
          </Form>
        </Navbar>
      </div>
    );
  }
}
