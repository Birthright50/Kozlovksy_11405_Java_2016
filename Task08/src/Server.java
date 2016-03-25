import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Birthright on 28.11.2015.
 */
public class Server {
    public final ArrayList<String> names;
    public volatile ArrayList<ClientRoomThread> connections;
    final int PORT = 3456;
    private static Random random = new Random();

    public Server() throws IOException {
        connections = new ArrayList<>();
        names = new ArrayList<>();
        go();
    }

    public void go() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");
        while (true) {



            Thread thread = (Thread) ac.getBean("thread");

            thread.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }

    public class ClientRoomThread implements Runnable {
        private ObjectInputStream ois;
        private ObjectOutputStream ous;
        private ObjectOutputStream enemyOutputStream;
        private String name;

        public ClientRoomThread(Socket socket) {
            try {
                ous = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ignored) {
            }
        }

        @Override
        public void run() {
            try {
                connections.add(this);
                synchronized (names) {
                    ous.writeObject(names);
                    ous.flush();
                    this.name = ois.readUTF();
                    ous.writeObject(names);
                    ous.flush();
                    names.add(this.name);
                }
                String choose = ois.readUTF();
                int randomColor;
                if (!choose.equals(Client.NEW_ROOM)) {
                    for (ClientRoomThread clientRoomThread : connections) {
                        if (clientRoomThread.name.equals(choose)) {
                            this.enemyOutputStream = clientRoomThread.ous;
                            clientRoomThread.enemyOutputStream = this.ous;
                            names.remove(this.name);
                            names.remove(clientRoomThread.name);
                            randomColor = Server.random.nextInt(2);
                            System.out.println(randomColor);
                            if (randomColor == 1) {
                                this.ous.writeObject(StoneColor.BLACK);
                                this.enemyOutputStream.writeObject(StoneColor.WHITE);
                            } else {
                                this.ous.writeObject(StoneColor.WHITE);
                                this.enemyOutputStream.writeObject(StoneColor.BLACK);
                            }
                            break;
                        }
                    }
                }
                while (true) {
                    try {
                        Message message = (Message) ois.readObject();
                        enemyOutputStream.writeObject(message);
                        enemyOutputStream.flush();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SocketException e) {
                names.remove(this.name);
                connections.remove(this);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

