package cadastroserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import controller.ProdutosJpaController;
import controller.UsuariosJpaController;

public class ServidorCadastro {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastroServerPU");
        
        ProdutosJpaController ctrlProdutos = new ProdutosJpaController(emf);
        UsuariosJpaController ctrlUsuarios = new UsuariosJpaController(emf);
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4321);
            System.out.println("Servidor aguardando conexões na porta 4321...");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (true) {
            try {
               
                Socket socket = serverSocket.accept();
             
                CadastroThread cadastroThread = new CadastroThread(ctrlProdutos, ctrlUsuarios, socket);
                cadastroThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
