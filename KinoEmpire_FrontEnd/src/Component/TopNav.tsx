import React, { Component } from "react";
import Navbar from "react-bootstrap/Navbar";
import Form from "react-bootstrap/Form";
import './TopNav.css';
import Search from "./Search";

export default class TopNav extends Component {
  render() {
    return (
      <div>
        <Navbar bg="dark" variant="dark" className="flex">
          <Navbar.Brand href="#home">{"Kino Empire"}</Navbar.Brand>
          <Form inline>
            <Search/>
          </Form>
        </Navbar>
      </div>
    );
  }
}
