package icai.dtc.isw.server;

import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.message.Message;
import icai.dtc.isw.ui.JVentanaBuscar;
import icai.dtc.isw.ui.JVentanaRegistro;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

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
					//System.out.println("ok contexto");
		    		CustomerControler customerControler=new CustomerControler();
					//System.out.println("ok controller");
					ArrayList<Customer> lista= new ArrayList<>();
					HashMap<String,Object> mapa = mensajeIn.getSession();
					System.out.println(mapa);
					//Entrada en = (Entrada) objeto.values();
					//System.out.println(en.getOrigen());
					System.out.println("pregetcustomer");
		    		customerControler.getCustomer(lista,mapa);
		    		mensajeOut.setContext("/getCustomerResponse");
		    		HashMap<String,Object> session= new HashMap<>();
		    		session.put("Customer",lista);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);



				case "/getUsuario":
					//System.out.println("ok contexto");
					CustomerControler customerControler2=new CustomerControler();
					//System.out.println("ok controller");
					ArrayList<Usuario> lista2= new ArrayList<>();
					HashMap<String,Object> mapa2 = mensajeIn.getSession();
					System.out.println(mapa2);
					//Entrada en = (Entrada) objeto.values();
					//System.out.println(en.getOrigen());
					System.out.println("pregetusuario");
					customerControler2.getUsuario(lista2,mapa2);
					mensajeOut.setContext("/getUsuarioResponse");
					HashMap<String,Object> session2=new HashMap<>();
					session2.put("Usuario",lista2);
					mensajeOut.setSession(session2);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/setUsuario":
					CustomerControler customerControler3=new CustomerControler();
					ArrayList<Usuario> lista3=new ArrayList<Usuario>();
					HashMap<String,Object> mapa3 = mensajeIn.getSession();
					customerControler3.setUsuario(lista3,mapa3);
					mensajeOut.setContext("/setUsuarioResponse");
					HashMap<String,Object> session3=new HashMap<>();
					session3.put("Usuario",lista3);
					//System.out.println(lista3.size());
					mensajeOut.setSession(session3);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/setCoche":
					CustomerControler customerControler4=new CustomerControler();
					ArrayList<Customer> lista4=new ArrayList<Customer>();
					HashMap<String,Object> mapa4 = mensajeIn.getSession();
					customerControler4.setCustomer(lista4,mapa4);
					mensajeOut.setContext("/setCocheResponse");
					HashMap<String,Object> session4=new HashMap<>();
					session4.put("Customer",lista4);
					//System.out.println(lista3.size());
					mensajeOut.setSession(session4);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/getCustomerC":
					//System.out.println("ok contexto");
					CustomerControler customerControler5=new CustomerControler();
					//System.out.println("ok controller");
					ArrayList<Customer> lista5= new ArrayList<>();
					HashMap<String,Object> mapa5 = mensajeIn.getSession();
					System.out.println(mapa5);
					//Entrada en = (Entrada) objeto.values();
					//System.out.println(en.getOrigen());
					//System.out.println("pregetcustomer");
					customerControler5.getCustomerC(lista5,mapa5);
					mensajeOut.setContext("/getCustomerResponse");
					HashMap<String,Object> session5= new HashMap<>();
					session5.put("Customer",lista5);
					mensajeOut.setSession(session5);
					objectOutputStream.writeObject(mensajeOut);

				case "/preUpdate":
					//System.out.println("ok contexto");
					CustomerControler customerControler6=new CustomerControler();
					//System.out.println("ok controller");
					ArrayList<Customer> lista6= new ArrayList<>();
					HashMap<String,Object> mapa6 = mensajeIn.getSession();
					System.out.println(mapa6);
					//Entrada en = (Entrada) objeto.values();
					//System.out.println(en.getOrigen());
					//System.out.println("pregetcustomer");
					customerControler6.preUpdate(lista6,mapa6);
					mensajeOut.setContext("/UpdateResponse");
					HashMap<String,Object> session6= new HashMap<>();
					session6.put("Customer",lista6);
					mensajeOut.setSession(session6);
					objectOutputStream.writeObject(mensajeOut);

				case "/Update":
					//System.out.println("ok contexto");
					CustomerControler customerControler7=new CustomerControler();
					//System.out.println("ok controller");
					ArrayList<Customer> lista7= new ArrayList<>();
					HashMap<String,Object> mapa7 = mensajeIn.getSession();
					System.out.println(mapa7);
					//Entrada en = (Entrada) objeto.values();
					//System.out.println(en.getOrigen());
					//System.out.println("pregetcustomer");
					customerControler7.update(lista7,mapa7);
					mensajeOut.setContext("/UpdateResponse2");
					HashMap<String,Object> session7= new HashMap<>();
					session7.put("Customer",lista7);
					mensajeOut.setSession(session7);
					objectOutputStream.writeObject(mensajeOut);

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
		//new JVentanaBuscar();
//		new JVentanaRegistro();
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