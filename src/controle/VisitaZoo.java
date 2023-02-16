package controle;

import entidades.AreaAves;
import entidades.AreaMamiferos;
import entidades.AreaAnfibios;
import entidades.Grupo;
import entidades.Guia;
import entidades.SetorZoo;
import entidades.Visita;
import entidades.Visita.Periodo;
import interfaces.InterfaceTextual;
import java.util.ArrayList;
import java.util.HashMap;
import util.Data;
import util.PersistênciaArquivo;

public class VisitaZoo {

    private static final String arquivo = "dados/VisitaZoo.bds";

    public static void salvarAplicação() {
        ArrayList objeto_raiz = new ArrayList();
        objeto_raiz.add(Grupo.getGrupos());
        objeto_raiz.add(Guia.getGuias());
        objeto_raiz.add(SetorZoo.getSetorZoos());
        objeto_raiz.add(Visita.getVisitas());
        PersistênciaArquivo.salvar(objeto_raiz, arquivo);
    }

    public static void recuperarAplicação() {
        ArrayList objeto_raiz = (ArrayList) PersistênciaArquivo.recuperar(arquivo);
        if (objeto_raiz != null) {
            Grupo.setGrupos((HashMap<String, Grupo>) objeto_raiz.get(0));
            Guia.setGuias((HashMap<String, Guia>) objeto_raiz.get(1));
            SetorZoo.setSetorZoos((HashMap<String, SetorZoo>) objeto_raiz.get(2));
            Visita.setVisitas((ArrayList<Visita>) objeto_raiz.get(3));
        }
    }

    public static void main(String[] args) {
        recuperarAplicação();
        
        InterfaceTextual.loopOpçõesExecução();
        salvarAplicação();
    }

    public static ArrayList<Visita> selecionarVisitas(Periodo periodo_visita, int quantidade_especies, String prefixo_guia, char necessidade_especial, char animal_periculosidade, char animal_venenoso, char acesso_viveiro, Data data_máxima_visita) {
        ArrayList<Visita> visitas_selecionadas = new ArrayList();
        for (Visita visita : Visita.getVisitas()) {
            Data data_visita = visita.getDataPasseio();
            Periodo periodo = visita.getPeriodo();
            int q_especies = visita.getSetorZoo().getQuantidadeEspecie();
            String cpf = visita.getGuia().getCpf();
            boolean s_necessidade_especial = visita.getGrupo().isNecessidadesEspeciais();
    
            if ((periodo_visita != null) && (visita.getPeriodo() != periodo_visita)) {
                continue;
            }

            if ((quantidade_especies != -1) && (visita.getSetorZoo().getQuantidadeEspecie() > quantidade_especies)) {
                continue;
            }

            if ((prefixo_guia != null) && (!visita.getGuia().getCpf().startsWith(prefixo_guia))) {
                continue;
            }

            if ((necessidade_especial == 'S') && !s_necessidade_especial) {
                continue;
            }

            if ((necessidade_especial == 'N') && s_necessidade_especial) {
                continue;
            }

            SetorZoo setor_zoo = null;
            if (setor_zoo instanceof AreaMamiferos) {
                AreaMamiferos area_mamiferos = (AreaMamiferos) setor_zoo;
                boolean s_perigosidade = area_mamiferos.isPericulosidade();
                if ((animal_periculosidade == 'S') && !s_perigosidade) {
                    continue;
                }
                if ((animal_periculosidade == 'N') && s_perigosidade) {
                    continue;
                }
            } else {
                if (setor_zoo instanceof AreaAnfibios) {
                    AreaAnfibios area_anfibios = (AreaAnfibios) setor_zoo;
                    boolean s_venenoso = area_anfibios.isVenenoso();
                    if ((animal_venenoso == 'S') && !s_venenoso) {
                        continue;
                    }
                    if ((animal_venenoso == 'N') && s_venenoso) {
                        continue;
                    }
                } else {
                    if (setor_zoo instanceof AreaAves) {
                        AreaAves area_aves = (AreaAves) setor_zoo;
                        boolean s_viveiro = area_aves.isAcessoViveiro();
                        if ((acesso_viveiro == 'S') && !s_viveiro) {
                            continue;
                        }
                        if ((acesso_viveiro == 'N') && s_viveiro) {
                            continue;
                        }
                    }
                }
            }
            if ((data_máxima_visita != null)
                    && (data_máxima_visita.compareTo(data_visita) < 0)) {
                continue;
            }
            visitas_selecionadas.add(visita);
        }
        return visitas_selecionadas;
    }
}