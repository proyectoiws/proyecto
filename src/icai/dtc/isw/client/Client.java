package icai.dtc.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.message.Message;

public class Client {
	private String host;
	private int port;
	private ArrayList<Customer> salidas;
	final static Logger logger = Logger.getLogger(Client.class);


	public void envioPeticion(String contexto, HashMap <String,Object> session) {
		//Configure connections

		String host = PropertiesISW.getInstance().getProperty("host");
		System.out.println("ok1");
		int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		System.out.println("ok2");
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		System.out.println("ok3");
		//Create a cliente class
		this.setC( host,  port);
		System.out.println("ok4");


		//HashMap<String,Object> session=new HashMap<String, Object>();
		//session.put("/getCustomer","");
		
		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();
		mensajeEnvio.setContext(contexto);
		mensajeEnvio.setSession(session);
		System.out.println("pre ");
		this.sent(mensajeEnvio,mensajeVuelta);
		System.out.println("post ");
		
		
		switch (mensajeVuelta.getContext()) {
			case "/getCustomerResponse":
				// Aquí tenemos q conseguir devolver un array
				ArrayList<Customer> customerList=(ArrayList<Customer>)(mensajeVuelta.getSession().get("Customer"));
				this.salidas= customerList;
				 for (Customer customer : customerList) {			
						System.out.println("He leído la matricula: "+customer.getMatricula()+" origen:"+customer.getOrigen()+" destino:"+customer.getDestino()+"numero de plazas"+customer.getPlazas());
					} 
				break;
				
			default:
				Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vuelta");
				break;
		
		}
		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
	}
	
	public void setC(String host, int port) {
		this.host=host;
		this.port=port;
	}

	public ArrayList<Customer> getSalida(){
		return salidas;
	}


	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
				
				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);
				
				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
		        Message msg=(Message)objectInputStream.readObject();
		        messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Unable to get streams from server");
				System.exit(1);
			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}