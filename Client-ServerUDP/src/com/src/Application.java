package com.src;

import java.io.IOException;
import java.util.Scanner;
import java.net.*;


/**
 * Class responsible for interpreting the console input messages and then delegate them to either the Server or the Clients
 */
public class Application {

	/**
	 * The application's server
	 */
	private static Server server;

	/**
	 * Possible States the Application may be in
	 */
	private enum State {
		START, OPENED_SERVER
	}

	/**
	 * Current State the application is in
	 */
	private static State currentState;

	public static void main(String[] args) throws IOException {
		//Inicializar a maquina de estados que assegura que o programa:
		// 1 - abre o servidor (1� estado)
		// 2 - chamadas consecutivas de cleinetes ( 2� estado)

		//Depois mudar isto para ele interpretar, para j� fica hardcoded para garantir que funciona
		// send request

		DatagramSocket socket = new DatagramSocket(8888);
		byte[] sbuf = "test".getBytes();
		InetAddress address = InetAddress.getByName("127.0.0.1");

		DatagramPacket packet = new DatagramPacket(sbuf, sbuf.length, address, 8888);
		socket.send(packet);

		// get response
		byte[] rbuf = new byte[sbuf.length];
		packet = new DatagramPacket(rbuf, rbuf.length);
		socket.receive(packet);

		// display response
		String received = new String(packet.getData());
		System.out.println("Echoed Message: " + received);
		socket.close();
	}
}