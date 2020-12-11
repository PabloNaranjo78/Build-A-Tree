package cr.ac.tec.BuildATree.TreesStructure.ServerSocket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerSocket {
    private final static int PORT = 5000;
    private final static String SERVER = "localhost";

    public static void main(String[] args) {
        //

        Socket clientSocket;//Socket para la comunicacion cliente servidor
        try{
            System.out.println("Client> started");
            while( true ){//ciclo repetitivo
                //abre socket
                clientSocket = new Socket(SERVER,PORT);
                //Para leer lo que escriba el usuario
                BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in));
                //para imprimir datos del servidor
                PrintStream toServer = new PrintStream(clientSocket.getOutputStream());
                //Para leer lo que envie el servidor
                InputStream stream = clientSocket.getInputStream();
                //mensaje para el cliente
                System.out.println("Client> Introduzca expresión matematica ");
                //captura comando escrito por el usuario
                String request = brRequest.readLine();
                //manda al servidor
                toServer.println(request);
                //lee respuesta del servidor
                byte[] bytes = new byte[256];
                stream.read(bytes,0,256);
                //convierte a string
                String received = new String(bytes,"UTF-8");
                //imprime en pantalla
                System.out.println("Server> " + request + " = " + received.trim());

            }
        }catch(IOException | NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }


}
