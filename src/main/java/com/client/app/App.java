package com.client.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    String address = "localhost";
    int port = 5156;
    Socket socket;
    try {
      socket = new Socket(address, port);
      System.out.println("Connected to server");
      InputStream is = socket.getInputStream();
      BufferedReader bs = new BufferedReader(new InputStreamReader(is));
      PrintWriter outchan = new PrintWriter(socket.getOutputStream(), true);

      new Thread(() -> {
        try {
          String serverResponse;
          while ((serverResponse = bs.readLine()) != null) {
            System.out.println(serverResponse);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();

      Scanner scanner = new Scanner(System.in);
      String line = "";
      while (!line.equals("exit")) {
        line = scanner.nextLine();
        outchan.println(line);
        System.out.print("\033[1A");
        System.out.print("\033[2K");
        System.out.print("\r");
        System.out.flush();
      }

      try {
        scanner.close();
        bs.close();
        outchan.close();
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
