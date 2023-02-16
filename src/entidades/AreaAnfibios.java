package entidades;

import java.io.Serializable;

public class AreaAnfibios extends SetorZoo implements Serializable {

    private TipoAnfibios tipo_anfibios;
    private boolean venenoso;

    public enum TipoAnfibios {
        anura, urodela, gymnophiona;
    }

    public AreaAnfibios(String id, ContinenteFauna continente_fauna, int quantidade_especie, TipoAnfibios tipo_anfibios, boolean venenoso) {
        super(id, continente_fauna, quantidade_especie);
        this.tipo_anfibios = tipo_anfibios;
        this.venenoso = venenoso;
    }

    public TipoAnfibios getTipoRepteis() {
        return tipo_anfibios;
    }

    public boolean isVenenoso() {
        return venenoso;
    }

    public String toStringVenenoso() {
        if (venenoso == true) {
            return " - Cuidado - Animal venenoso ";
        } else {
            return "";
        }
    }

    public String toString() {
        return " -- Area Reptéis: "
                + super.toString()
                + "\n                     - Tipo Repteil: " + tipo_anfibios
                + toStringVenenoso();
    }
}
