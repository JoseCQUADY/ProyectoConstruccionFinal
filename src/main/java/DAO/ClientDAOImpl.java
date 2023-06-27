package DAO;

import Model.Client;
import Service.Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.util.Scanner;


public class ClientDAOImpl implements ClientDAO {

    //public static String file = "src\\Files\\clients.txt";

    @Override
    public void addClient(Client client) {
        try (FileWriter fw = new FileWriter("src\\Files\\clients.txt", true)){  
            StringBuilder sb = new StringBuilder();
            sb.append(client.getCurp());
            sb.append(',');
            sb.append(client.getName());
            sb.append(',');
            final String secretKey = "clave";
            String encryptedText = "";
            encryptedText = Algorithm.encryptTL(sb.toString(), secretKey);
            fw.append(encryptedText);
            fw.append("\n");
            fw.close();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void removeClient(String idClient) {
        try {
            File oldFile = new File("src\\Files\\clients.txt");     
            File newFile = new File(oldFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(new FileWriter(newFile));

            String line = null;
            final String secretKey = "clave";
            while ((line = br.readLine()) != null) {
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String curp = data[0];

                if (!curp.equals(idClient)){
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Client showClient(String idClient) {
        Client client = null;
        try(Scanner scanner = new Scanner(Paths.get("src\\Files\\clients.txt"))) {       
            final String secretKey = "clave";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");
                
                String curp = data[0];
                if (curp.equals(idClient)){                       
                    String nombre = data[1];
                    client = new Client(nombre, curp);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> showAllClients() {
        List<Client> clientes = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("src\\Files\\clients.txt"))) {       
            final String secretKey = "clave";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String nombre = data[0];
                String curp = data[1];
                Client cliente = new Client(nombre, curp);
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }
    
    @Override
    public boolean existClient(String idClient){
        try(Scanner scanner = new Scanner(Paths.get("src\\Files\\clients.txt"))) {       
            final String secretKey = "clave";
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String curp = data[0];
                System.out.println(curp);
                System.out.println(idClient);
                if (curp.equals(idClient)){
                    count+=1;;
                }
            }

            return count > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }
}

