package com.example.day15.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Handler;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> allClients = new HashSet<>();

    public static void main(String[] args) throws Exception{
        System.out.println("채팅 서버가 시작되었습니다.");
        ServerSocket listener = new ServerSocket(PORT);

        try{
            while(true){
                // 새 클라이언트가 서버에 연결되면 해당 클라이언트에 대한 핸들러를 생성하고 시작
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (allClients) {
                    allClients.add(out);
                }

                String input;
                while((input = in.readLine()) != null){
                    synchronized (allClients){
                        for(PrintWriter writer : allClients){
                            writer.println(input);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally{
                if(out != null){
                    synchronized (allClients){
                        allClients.remove(out);
                    }
                }

                try{
                    socket.close();
                } catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
