package entidades;

import util.Data;
import java.io.Serializable;
import java.util.ArrayList;

public class Visita implements Serializable {

    private static ArrayList<Visita> visitas = new ArrayList();

    public static boolean add(Visita visita) {
        if (!visitas.contains(visita)) {
            visitas.add(visita);
            return true;
        }else{
            System.out.println("ERRO : visita já cadastrada");
            return false;
        }
    }

    public static ArrayList<Visita> getVisitas() {
        return visitas;
    }

    public static void setVisitas(ArrayList<Visita> visitas) {
        Visita.visitas = visitas;
    }

    private Grupo grupo;
    private Guia guia;
    private SetorZoo setor_zoo;
    private Periodo periodo;
    private Data data_passeio;

    public enum Periodo {
        manha, tarde, integral;
    }

    public Visita(Grupo grupo, Guia guia, SetorZoo setor_zoo, Periodo periodo, Data data_passeio) {
        this.grupo = grupo;
        this.guia = guia;
        this.setor_zoo = setor_zoo;
        this.periodo = periodo;
        this.data_passeio = data_passeio;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public SetorZoo getSetorZoo() {
        return setor_zoo;
    }

    public void setSetorZoo(SetorZoo setor_zoo) {
        this.setor_zoo = setor_zoo;
    }

    public Data getDataPasseio() {
        return data_passeio;
    }

    public void setDataPasseio(Data data_passeio) {
        this.data_passeio = data_passeio;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public String toString() {
        String dado_visita = "\n    Grupo: " + getGrupo()
                + "\n    Guia: " + getGuia()
                + "\n    Setor Zoo: " + getSetorZoo()
                + "\n    Data Passeio: " + getDataPasseio()
                + "\n    Periodo: " + getPeriodo();
        return dado_visita;
    }
}