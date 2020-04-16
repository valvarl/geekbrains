import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8090;
    private static final String END_MESSAGE = "/end";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isActive = true;

    public ConsoleClient() {
        try {
            System.out.println("Open connection. Thread: " + Thread.currentThread().getName());
            this.openConnection();
        } catch (IOException var3) {
            System.err.println("Ошибка соединения с сервером. " + var3.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        while(this.isActive) {
            String text = scanner.nextLine();
            this.sendMessage(text);
        }

    }

    public void openConnection() throws IOException {
        this.socket = new Socket("localhost", 8090);
        this.in = new DataInputStream(this.socket.getInputStream());
        this.out = new DataOutputStream(this.socket.getOutputStream());
        (new Thread(() -> {
            System.out.println("Processing connection. Thread: " + Thread.currentThread().getName());

            try {
                while(this.isActive) {
                    String strFromServer = this.in.readUTF();
                    if (strFromServer.equalsIgnoreCase("/end")) {
                        this.isActive = false;
                        System.out.println("Сервер закрыл соединение.");
                        break;
                    }

                    System.out.println("> " + strFromServer);
                }
            } catch (Exception var2) {
                Thread.currentThread().interrupt();
            }

        })).start();
    }

    private void close(Closeable... objects) {
        Closeable[] var2 = objects;
        int var3 = objects.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Closeable o = var2[var4];

            try {
                if (o != null) {
                    o.close();
                }
            } catch (IOException var7) {
                var7.printStackTrace();
            }
        }

    }

    public void sendMessage(String msg) {
        String text = msg.trim();
        if (!text.isEmpty()) {
            if (this.out == null) {
                System.err.println("Ошибка отправки сообщения. Сервер не доступен.");
            }

            try {
                this.out.writeUTF(text);
                this.out.flush();
                if ("/end".equals(text)) {
                    this.close(this.in, this.out, this.socket);
                    this.isActive = false;
                }
            } catch (IOException var4) {
                var4.printStackTrace();
                System.out.println("Ошибка отправки сообщения. " + var4.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("In main. Tread: " + Thread.currentThread().getName());
        new ConsoleClient();
    }
}
