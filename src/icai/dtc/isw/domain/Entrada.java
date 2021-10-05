package icai.dtc.isw.domain;

import java.io.Serializable;

public class Entrada implements Serializable {
    private String origen;
    private String destino;
    private String plazas;

    public Entrada(String origen, String destino, String plazas)
    {
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

    public String getPlazas()
    {
        return plazas;
    }
}
