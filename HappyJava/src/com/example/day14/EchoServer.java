package com.example.day14;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        // int portNumber = Integer.parseInt(arg[0]);
        int portNumber = 9999;

        try(ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String line = null;
                while((line = in.readLine())!= null) {
                    out.println(line);
                }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
