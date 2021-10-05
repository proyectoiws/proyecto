package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private String origen;
	private String destino;
	private int plazas;
	private String matricula;
	//private String fecha;
	//private String hora;

	public Customer(String matricula, String origen, String destino, int plazas)
	{
		this.matricula= matricula;
		this.origen= origen;
		this.destino = destino;
		this.plazas = plazas;
	}

	public String getOrigen()
	{
		return origen;
	}

	public String getDestino()
	{
		return destino;
	}

	public int getPlazas()
	{
		return plazas;
	}
	public String getMatricula()
	{
		return matricula;
	}
	
}
