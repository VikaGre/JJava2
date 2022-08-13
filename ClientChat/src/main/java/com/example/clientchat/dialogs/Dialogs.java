package com.example.clientchat.dialogs;

import com.example.clientchat.ClientChat;
import com.example.clientchat.model.Network;
import javafx.scene.control.Alert;

public class Dialogs {

    public enum AuthError {
        EMPTY_CREDENTIALS("Login and password must be specified."),
        INVALID_CREDENTIALS("Incorrect login and password.");

        private static final String TITLE = "Authentication error.";
        private static final String TYPE = TITLE;

        private final String message;

        AuthError(String message) {
            this.message = message;
        }

        public void show() {
            showDialogs(Alert.AlertType.ERROR, TITLE, TITLE, message);
        }
    }

    public enum NetworkError {
        SEND_MESSAGE("Failed to send a message."),
        SERVER_CONNECT("Failed to connect to the server.");

        private static final String TITLE = "Network error.";
        private static final String TYPE = "Network data transfer error.";
        private final String message;

        NetworkError(String message) {
            this.message = message;
        }

        public void show() {
            showDialogs(Alert.AlertType.ERROR, TITLE, TYPE, message);
        }

    }

    private static void showDialogs(Alert.AlertType dialogType, String title, String type, String message) {
        Alert alert = new Alert(dialogType);
        alert.initOwner(ClientChat.getInstance().getChatStage());
        alert.setTitle(title);
        alert.setHeaderText(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
