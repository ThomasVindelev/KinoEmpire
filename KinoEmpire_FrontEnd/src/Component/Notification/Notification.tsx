import React from 'react';
import { MDBNotification } from 'mdbreact';

interface NotificationState {
    showToast: boolean;
    level: string;
    message: any;
}

class Notification extends React.Component<{}, NotificationState> {

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
                    title="Film tilføjet!"
                    message="Din film er nu blevet tilføjet!"
                    text="Lige nu"
                />
            </div>
        )
    }

}

export default Notification;