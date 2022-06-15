package com.java.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	private static int port = 5000;

	public static void main(String[] args) throws IOException {
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server started\nListening for requests at port: "+port);
			
			while (true) {
				
				try (Socket client = serverSocket.accept()) {
					// cliente requests queued up
					System.out.println("Debug: got new request\n"+client.toString());
					
					// Read the request
					InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
					
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					
					// Read the request from client
					StringBuilder request = new StringBuilder();
					String line = bufferedReader.readLine();
					while (!line.isBlank()) {
						request.append(line+"\r\n");
						line = bufferedReader.readLine();
					}
					
					// Send back a response
					
					// Get the first line of request
					String firstLine = request.toString().split("\n")[0];
					
					// Get the resource from the first line
					String resource = firstLine.split(" ")[1];
					
					// Compare the resource and send back a response
					if (resource.equals("/")) {
						InputStream image = Main.class.getResourceAsStream("/java.jpg");
						OutputStream clientOutput = client.getOutputStream();
						clientOutput.write(("HTTP/1.1 200 OK\r\n").getBytes());
						clientOutput.write(("\r\n").getBytes());
						clientOutput.write((image.readAllBytes()));
						clientOutput.flush();
						image.close();
					} else if (resource.equals("/hello")) {
						OutputStream clientOutput = client.getOutputStream();
						clientOutput.write(("HTTP/1.1 200 OK\r\n").getBytes());
						clientOutput.write(("\r\n").getBytes());
						clientOutput.write(("Hello World!").getBytes());
						clientOutput.flush();						
					} else {
						OutputStream clientOutput = client.getOutputStream();
						clientOutput.write(("HTTP/1.1 200\r\n").getBytes());
						clientOutput.write(("\r\n").getBytes());
						clientOutput.write(("200 OK").getBytes());
						clientOutput.flush();
					}
					client.close();
				}
				
			}
		}

	}

}
