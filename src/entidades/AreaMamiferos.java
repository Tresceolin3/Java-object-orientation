package entidades;

import java.io.Serializable;

public class AreaMamiferos extends SetorZoo implements Serializable{

    private TipoMamifero tipo_mamifero;
    private boolean periculosidade;

    public enum TipoMamifero {
        marsupiais, monotremados, euterios;
    }

    public AreaMamiferos(String id, ContinenteFauna continente_fauna, int quantidade_especie, TipoMamifero tipo_mamifero, boolean perigosidade) {
        super(id, continente_fauna, quantidade_especie);
        this.tipo_mamifero = tipo_mamifero;
        this.periculosidade = perigosidade;
    }

    public TipoMamifero getTipoMamifero() {
        return tipo_mamifero;
    }

    public boolean isPericulosidade() {
        return periculosidade;
    }

    public String toStringPericulosidade() {
        if (periculosidade == true) {
            return " - Cuidado - Nao encoste na grade ";
        } else {
            return "";
        }
    }

    public String toString() {
        return " -- Area Mamiferos: "
                + super.toString()
                + "\n                     - Tipo Mamifero: " + tipo_mamifero
                + toStringPericulosidade();
    }

}
