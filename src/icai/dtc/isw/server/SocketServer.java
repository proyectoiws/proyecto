package icai.dtc.isw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import icai.dtc.isw.message.Message;

public class SocketServer extends Thread {
	public static final int PORT_NUMBER = 8081;
	//private entrada Entrada;
	//introducir entrada

	protected Socket socket;

	private SocketServer(Socket socket) {
		this.socket = socket;
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}

	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//first read the object that has been sent
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
		    Message mensajeIn= (Message)objectInputStream.readObject();
		    //Object to return informations 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		    Message mensajeOut=new Message();
			//System.out.println("sockect");
		    switch (mensajeIn.getContext()) {

		    	case "/getCustomer":
					System.out.println("ok contexto");
		    		CustomerControler customerControler=new CustomerControler();
					System.out.println("ok controller");
					ArrayList<Customer> lista=new ArrayList<Customer>();
					HashMap<String,Object> mapa = mensajeIn.getSession();
					System.out.println(mapa);
					//Entrada en = (Entrada) objeto.values();
					//System.out.println(en.getOrigen());
					System.out.println("pregetcustomer");
		    		customerControler.getCustomer(lista,mapa);
		    		mensajeOut.setContext("/getCustomerResponse");
		    		HashMap<String,Object> session=new HashMap<String, Object>();
		    		session.put("Customer",lista);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);		    		
		    	break;
		    	
		    	
		    	default:
		    		System.out.println("\nParámetro no encontrado");
		    		break;
		    }
		    
		    //Lógica del controlador 
		    //System.out.println("\n1.- He leído: "+mensaje.getContext());
		    //System.out.println("\n2.- He leído: "+(String)mensaje.getSession().get("Nombre"));
		    
		    
		    
		    //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			
			//Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" añado información";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He leído: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT_NUMBER);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}