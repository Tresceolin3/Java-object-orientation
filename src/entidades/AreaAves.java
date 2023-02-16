package entidades;

import java.io.Serializable;

public class AreaAves extends SetorZoo implements Serializable {

    private TipoAve tipo_ave;
    private boolean acesso_viveiro;

    public enum TipoAve {
        ratitas, carinatas;
    }

    public AreaAves(String id, ContinenteFauna continente_fauna, int quantidade_especie, TipoAve tipo_ave, boolean acesso_viveiro) {
        super(id, continente_fauna, quantidade_especie);
        this.tipo_ave = tipo_ave;
        this.acesso_viveiro = acesso_viveiro;
    }

    public TipoAve getTipoAve() {
        return tipo_ave;
    }

    public boolean isAcessoViveiro() {
        return acesso_viveiro;
    }

    public String toStringAcessoViveiro() {
        if (acesso_viveiro == true) {
            return " - Visita ao Viveiro ";
        } else {
            return "";
        }
    }

    public String toString() {
        return " -- Area Aves: "
                + super.toString()
                + "\n                     - Tipo Ave: " + tipo_ave
                + toStringAcessoViveiro();
    }

    public void setTipoAve(TipoAve tipo_ave) {
        this.tipo_ave = tipo_ave;
    }
}
