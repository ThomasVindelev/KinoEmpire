import React from "react";
import "./App.css";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import TopNav from "./Component/TopNav";
import Overview from "./views/Overview/Overview";
import Container from "./Component/Container";
import ManageMovie from "./views/ManageMovie/ManageMovie";
import ManageViewing from "./views/ManageViewing/ManageViewing";
import Home from "./views/Home/Home";

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <TopNav />
        <BrowserRouter>
          <Switch>
            <Container>
              <Route exact path="/" component={Home} />
              <Route path="/overview/:id" component={Overview} />
              <Route path="/movie" component={ManageMovie} />
              <Route path="/viewing" component={ManageViewing} />
            </Container>
          </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
