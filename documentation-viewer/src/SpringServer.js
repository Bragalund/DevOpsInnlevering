import React, {Component} from 'react';

class SpringServer extends Component {

    constructor() {
        super();
        this.state = {
            containerID: 'ingen id'
        }
    }

    getData() {
        return fetch('http://springserver:8080/hostname', {
            method: 'GET',
            header: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            mode: 'no-cors',
        }).then(response => response.json())
            .then(json => {
                    console.log(json);
                    this.setState({
                            containerID: json
                        }
                    )
                }
            )
            .catch((error) => {
                console.error(error);
            });
    }

    componentDidMount() {
        this.getData();
    }


    render() {
        return (
            <div>
                <p>Dette er spring-serveren sin container ID: </p>
                <p>{this.state.containerID}</p>
            </div>
        )
    }
}

export default SpringServer