package cr.ac.tec.BuildATree.TreesStructure.ServerSocket;


import cr.ac.tec.BuildATree.TreesStructure.Printer.BTreePrinter;
import cr.ac.tec.BuildATree.TreesStructure.TreeManager.TreeManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static cr.ac.tec.BuildATree.TreesStructure.Printer.BTreePrinterTest.imprimi2;

public class Server {

    public static void main(String[] args) throws IOException {
        final int port = 5000;
        ServerSocket server;
        Socket connection;
        TreeManager treeManager = new TreeManager();

        try {
            System.out.println("Servidor iniciado");
            while (true) {//ciclo repetitivo
                //abre socket
                server = new ServerSocket(port);
                System.out.println("Iniciando servidor");
                connection = server.accept();
                System.out.println("Conectado");
                //Para leer la entrada
                BufferedReader in_data = new BufferedReader(new InputStreamReader(System.in));
                //para imprimir datos del servidor
                PrintStream out_data = new PrintStream(connection.getOutputStream());
                //Para leer lo que envie el servidor

                InputStream stream = connection.getInputStream();
                //mensaje para el cliente
                byte[] bytes = new byte[256];
                stream.read(bytes, 0, 256);
                //convierte a string
                String received = new String(bytes, "UTF-8");
                //imprime en pantalla
                System.out.println("Cliente dijo> " + " = " + received.trim());

                //captura comando escrito por el usuario
                String request = treeManager.checkEvent(received.trim());
                //manda al servidor
                out_data.println(request);
                //lee respuesta del servidor

                server.close();
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

}



