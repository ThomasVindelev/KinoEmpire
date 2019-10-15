import React from 'react';
import { MDBNotification } from 'mdbreact';

interface NotificationState {
    showToast: boolean;
    level: string;
    message: any;
}

interface NotificationProps {
    title: string;
    message: string;
}

class Notification extends React.Component<NotificationProps, NotificationState> {

    render() {
        return (
            <div>
                <MDBNotification
                    show
                    fade
                    iconClassName="text-success"
                    icon="film"
                    style={{
                        position: "fixed",
                        top: "70px",
                        right: "10px",
                        zIndex: 9999,
                        background: '#343a40'
                      }}
                    title={this.props.title}
                    message={this.props.message}
                    text="Lige nu"
                />
            </div>
        )
    }

}

export default Notification;