package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ClientListener> clientListeners = new ArrayList<>();

    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(55555);

            while (true){
                Socket socket = serverSocket.accept();
                //отримати повідомлення
                //відправлення повідомлення

                //new Thread(new ClientListener(socket)).start();
                ClientListener clientListener = new ClientListener(socket, this);
                new Thread(clientListener).start();
                clientListeners.add(clientListener);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToOll(String message){
        clientListeners.forEach(clientListener -> clientListener.sendMessage(message));
    }
}
