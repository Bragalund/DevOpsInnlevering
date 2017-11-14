import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import SpringServer from "./SpringServer";

class App extends Component {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Velkommen til min DevOps-applikasjon</h1>
                </header>
                <p className="App-intro">
                    Denne appen består av en spring server og en react applikasjon. Begge kjører i hver sin
                    docker-container. De er sydd sammen med docker-compose.yml.
                </p>
                <div>
                    <SpringServer/>
                </div>
                <div>

                </div>
            </div>
        );
    }
}

export default App;
