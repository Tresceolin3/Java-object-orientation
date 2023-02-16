package entidades;

import java.io.Serializable;
import java.util.HashMap;

public class Grupo implements Serializable {

    private static HashMap<String, Grupo> e_grupos = new HashMap();

    public static boolean add(Grupo grupo) {
        String id = grupo.getId();
        if (e_grupos.get(id) == null) {
            e_grupos.put(id, grupo);
            return true;
        } else {
            return false;
        }
    }

    public static Grupo getGrupo(String id) {
        return e_grupos.get(id);
    }

    public static HashMap<String, Grupo> getGrupos() {
        return e_grupos;
    }

    public static void setGrupos(HashMap<String, Grupo> grupos) {
        Grupo.e_grupos = grupos;
    }

    private TipoGrupo tipo_grupo;
    private int integrantes;
    private boolean necessidades_especiais;
    private String id;

    public enum TipoGrupo {
        publico, particular, escolar, especial;
    }

    public Grupo(String id, TipoGrupo tipo_grupo, int integrantes, boolean necessidades_especiais) {
        this.id = id;
        this.tipo_grupo = tipo_grupo;
        this.integrantes = integrantes;
        this.necessidades_especiais = necessidades_especiais;
    }

    public TipoGrupo getTipoGrupo() {
        return tipo_grupo;
    }

    public void setTipoGrupo(TipoGrupo tipo_grupo) {
        this.tipo_grupo = tipo_grupo;
    }

    public int getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(int integrantes) {
        this.integrantes = integrantes;
    }

    public boolean isNecessidadesEspeciais() {
        return necessidades_especiais;
    }

    public void setNecessidadesEspeciais(boolean necessidades_especiais) {
        this.necessidades_especiais = necessidades_especiais;
    }

    public String getId() {
        return id;
    }

    public String toStringNecessidadesEspeciais() {
        if (necessidades_especiais == true) {
            return " - Visitante com necessidade Especial ";
        } else {
            return "";
        }
    }

    public String toString() {
        String dado_grupo = " -- "+getTipoGrupo()
                + " - Identificaçao: " + getId()
                + " - Quantidade de integrantes: " + getIntegrantes()
                + "  "+ toStringNecessidadesEspeciais();

        return dado_grupo;
    }

}
