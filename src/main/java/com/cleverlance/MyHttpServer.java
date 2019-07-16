package com.cleverlance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer {
	static int i = 0;

	public static void main(String[] args) {
		new MyHttpServer().start();
	}

	public void start() {
		System.out.println("Server: listening");
		ServerSocket ss;
		try {
			ss = new ServerSocket(8080);
			do {
				Socket socket = ss.accept();
				new Thread(new ServerThread(socket), "THR"+i++).start();
			} while (true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerThread implements Runnable {
	Socket socket;
	ServerThread(Socket socket) {
		this.socket = socket;
	}
	void log(String msg) {
		System.out.println("Server["+Thread.currentThread().getName()+"]: " + msg);
	}
	@Override
	public void run() {
		log("got connection");
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			InputStream ins = socket.getInputStream();
			read(ins);
			out.println("HTTP/1.1 200 OK");
			out.println("Content-Type: text/html");
			out.println("Cache-control: no-cache");
			out.println("");
			out.println("<html><body><h1>Hello, World!</h1>"+System.currentTimeMillis()+"</body></html>");
			out.flush();
//			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void read(InputStream ins) {
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(ins));
			String inputLine;
			while ((inputLine = in.readLine()) != null && !inputLine.equals(""))
				sb.append(inputLine);
//			in.close();
		    log(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
