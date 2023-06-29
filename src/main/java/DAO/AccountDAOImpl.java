package DAO;

import Model.Account;
import Service.Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDAOImpl implements AccountDAO {

    //public static String file = "src\\Files\\accounts.txt";

    @Override
    public void addAccount(String idClient, Account account) {
        try (FileWriter fw = new FileWriter("src\\Files\\accounts.txt", true)){  
            StringBuilder sb = new StringBuilder();
            sb.append(idClient);
            sb.append(',');
            sb.append(account.getIdAccount());
            sb.append(',');
            sb.append(account.getBalance());
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
    public void removeAllAccounts(String idClient) {
        try {
            File oldFile = new File("src\\Files\\accounts.txt");     
            File newFile = new File(oldFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(new FileWriter(newFile));

            String line = null;
            final String secretKey = "clave";
            while ((line = br.readLine()) != null) {
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String curpClient = data[0];

                if (!curpClient.equals(idClient)){
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
    public void removeAccount(String idClient, int idAccount) {
        try {
            File oldFile = new File("src\\Files\\accounts.txt");     
            File newFile = new File(oldFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(new FileWriter(newFile));

            String line = null;
            final String secretKey = "clave";
            while ((line = br.readLine()) != null) {
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String curpClient = data[0];
                int idAccountInt = Integer.parseInt(data[1]);
                if (!curpClient.equals(idClient) && idAccountInt!=idAccount){
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
    public void deposit(String idClient, int idAccount, double amount){
        try {
            File oldFile = new File("src\\Files\\accounts.txt");     
            File newFile = new File(oldFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(new FileWriter(newFile));

            String line = null;
            final String secretKey = "clave";
            while ((line = br.readLine()) != null) {
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String curpClient = data[0];
                int idAccountInt = Integer.parseInt(data[1]);
                double currentBalance = Double.parseDouble(data[2]);
                double newBalance = currentBalance + amount;
                if (!curpClient.equals(idClient) && idAccountInt!=idAccount){
                    pw.println(line);
                    pw.flush();
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    sb.append(idClient);
                    sb.append(',');
                    sb.append(idAccount);
                    sb.append(',');
                    sb.append(newBalance);
                    sb.append(',');
                    String encryptedLine = Algorithm.encryptTL(sb.toString(), secretKey);
                    pw.append(encryptedLine);
                    pw.append("\n");
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
    public void withdraw(String idClient, int idAccount, double amount){
        try {
            File oldFile = new File("src\\Files\\accounts.txt");     
            File newFile = new File(oldFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(new FileWriter(newFile));

            String line = null;
            final String secretKey = "clave";
            while ((line = br.readLine()) != null) {
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String curpClient = data[0];
                int idAccountInt = Integer.parseInt(data[1]);
                double currentBalance = Double.parseDouble(data[2]);

                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;
                    if (!curpClient.equals(idClient) && idAccountInt!=idAccount){
                        pw.println(line);
                        pw.flush();
                    }
                    else{
                        StringBuilder sb = new StringBuilder();
                        sb.append(idClient);
                        sb.append(',');
                        sb.append(idAccount);
                        sb.append(',');
                        sb.append(newBalance);
                        sb.append(',');
                        String encryptedLine = Algorithm.encryptTL(sb.toString(), secretKey);
                        pw.append(encryptedLine);
                        pw.append("\n");
                    }
                } else {
                    System.out.println("Saldo insuficiente para realizar el retiro.");
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
    public List<Account> showAccounts(String curpClient) {
        List<Account> accounts = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("src\\Files\\accounts.txt"))) {       
            final String secretKey = "clave";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String decryptedLine = "";
                decryptedLine= Algorithm.decryptTL(line, secretKey); 
                String[] data =decryptedLine.split(",");

                String idClient = data[0];
                int idAccount = Integer.parseInt(data[1]);
                Account account = new Account(idClient, idAccount);
                accounts.add(account);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return accounts;
    }
    
    
    
}

