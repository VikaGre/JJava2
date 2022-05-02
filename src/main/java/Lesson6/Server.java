package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) throws IOException {
        new Server().connection(SERVER_PORT);
    }
    public void connection(int PORT) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        Thread inputThread = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started!");
            socket = serverSocket.accept();
            System.out.println("Client connected!");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            inputThread = IN(in);
            Out(out);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (inputThread != null) {
                inputThread.interrupt();
            }
            if (socket != null) {
                socket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private void Out(DataOutputStream out) throws IOException {
        Scanner input = new Scanner(System.in);

        while (true) {
            String message = input.nextLine();
            if(message.equalsIgnoreCase("/end")) {
                break;
            }
            out.writeUTF(message);
        }
    }

    private Thread IN(DataInputStream in) throws IOException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String message = in.readUTF();
                        System.out.println("Client: " + message);
                        if(message.equalsIgnoreCase("/end")) {
                            System.exit(0);
                        }
                    } catch (IOException exception) {
                        System.exit(0);
                        break;
                    }
                }

            }
        });
        thread.start();
        return thread;
    }
}
