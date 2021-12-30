package icai.dtc.isw.domain;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import java.io.Serializable;

public class Entrada implements Serializable {
    private String origen;
    private String destino;
    private String fecha;
    private String hora;

    public String getName() {
        return name;
    }

    private String name;

    public Entrada(String origen, String destino, String fecha, String hora)
    {
        this.origen= origen;
        this.destino = destino;
        this.fecha = String.valueOf(fecha);
        this.hora = hora;
    }

    public Entrada (String name){
        this.name=name;
    }

    public String getOrigen()
    {
        return origen;
    }

    public String getDestino()
    {
        return destino;
    }

//    public String getPlazas()
//    {
//        return plazas;
//    }

    public String getFecha() { return fecha; }

    public String getHora() { return hora; }
}
