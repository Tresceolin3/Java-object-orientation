package entidades;

import java.io.Serializable;
import java.util.HashMap;

public class Guia implements Serializable {

    private static HashMap<String, Guia> e_guias = new HashMap();

    public static boolean add(Guia guia) {
        String cpf = guia.getCpf();
        if (e_guias.get(cpf) == null) {
            e_guias.put(cpf, guia);
            return true;
        } else {
            return false;
        }
    }

    public static Guia getGuia(String cpf) {
        return e_guias.get(cpf);
    }

    public static HashMap<String, Guia> getGuias() {
        return e_guias;
    }

    public static void setGuias(HashMap<String, Guia> guias) {
        Guia.e_guias = guias;
    }

    private String orientador;
    private String cpf;
    private Especialista especialista;

    public enum Especialista {
        veterianario, Zootecnico, biologo, ecologista;
    }
    public static HashMap<String, Guia> getE_guias() {
        return e_guias;
    }

    public static void setE_guias(HashMap<String, Guia> e_guias) {
        Guia.e_guias = e_guias;
    }

    public Guia(String orientador,String cpf, Especialista especialista) {
        this.cpf = cpf;
        this.orientador = orientador;
        this.especialista = especialista;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public String getCpf() {
        return cpf;
    }

    public String toString() {
        String dado_guia =
                 " -- "+getOrientador()
                + " - Cpf: " + getCpf()
                + " - Especialidade: " + getEspecialista();
        return dado_guia;
    }

}
