package entidades;

import java.io.Serializable;
import java.util.HashMap;

public class SetorZoo implements Serializable {

    private static HashMap<String, SetorZoo> setor_zoos = new HashMap();

    public static boolean add(SetorZoo setorzoo) {
        String id = setorzoo.getId();
        if (setor_zoos.get(id) == null) {
            setor_zoos.put(id, setorzoo);
            return true;
        } else {
            return false;
        }
    }

    public static SetorZoo getSetorZoo(String id) {
        return setor_zoos.get(id);
    }

    public static HashMap<String, SetorZoo> getSetorZoos() {
        return setor_zoos;
    }

    public static void setSetorZoos(HashMap<String, SetorZoo> setor_zoos) {
        SetorZoo.setor_zoos = setor_zoos;
    }

    protected ContinenteFauna continente_fauna;
    protected int quantidade_especie;
    private String id;

    public enum ContinenteFauna {
        AméricaSul, AméricaNorte, AméricaCentral, Europa, Ásia, África, Oceania, Antártida;
    }

    public SetorZoo(String id, ContinenteFauna continente_fauna, int quantidade_especie) {
        this.id = id;
        this.continente_fauna = continente_fauna;
        this.quantidade_especie = quantidade_especie;
    }

    public String getId() {
        return id;
    }

    public int getQuantidadeEspecie() {
        return quantidade_especie;
    }

    public ContinenteFauna getContinenteFauna() {
        return continente_fauna;
    }

    public String toString() {
        return " -- Pertence ao Continente: " + continente_fauna
                + " - Quantidade de especies: " + quantidade_especie
                + " - Identificaçao: " + id;

    }
}
