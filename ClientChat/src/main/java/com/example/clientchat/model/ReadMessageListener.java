package com.example.clientchat.model;

import com.example.commands.Command;

public interface ReadMessageListener {

    void processReceivedCommand(Command command);
}
