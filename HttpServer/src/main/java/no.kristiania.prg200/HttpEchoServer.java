package no.kristiania.prg200;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpEchoServer {


    private ServerSocket serverSocket;

    public HttpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket (port);
        new Thread(this::runServerThread).start();
    }

    private void runServerThread() {
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            } catch (RuntimeException e) {
                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                    } catch (IOException ioEx) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    private void handleRequest(Socket clientSocket) {
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }
}
