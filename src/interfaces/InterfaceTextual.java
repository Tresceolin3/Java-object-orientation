package interfaces;

import controle.VisitaZoo;
import entidades.AreaAnfibios;
import entidades.AreaAnfibios.TipoAnfibios;
import entidades.AreaAves;
import entidades.AreaAves.TipoAve;
import entidades.AreaMamiferos;
import entidades.AreaMamiferos.TipoMamifero;
import entidades.Grupo;
import entidades.Grupo.TipoGrupo;
import entidades.Guia;
import entidades.Guia.Especialista;
import entidades.SetorZoo;
import entidades.SetorZoo.ContinenteFauna;
import entidades.Visita;
import entidades.Visita.Periodo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import util.Data;

public class InterfaceTextual implements Serializable{

    private static ArrayList<Visita> visitas = new ArrayList();

    private static String lerString(String dado) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        System.out.print("- Informe " + dado + " : ");
        try {
            string = entrada.readLine();
            if (string.isEmpty()) {
                return null;
            }
        } catch (IOException exceção) {
            System.out.println("\n- ERRO na leitura de: " + dado);
            return null;
        }
        return string;
    }
    String id_setorzoo = lerString("ID SetorZoo");

    private static int lerInteiroPositivo(String dado) {
        String inteiro_positivo_string = lerString(dado);
        if (inteiro_positivo_string == null) {
            return -1;
        }
        int inteiro_positivo = 0;
        try {
            inteiro_positivo = Integer.valueOf(inteiro_positivo_string).intValue();
        } catch (NumberFormatException exceção) {
            System.out.println("- ERRO na conversão para inteiro de: " + dado);
            return -1;
        }
        if (inteiro_positivo > 0) {
            return inteiro_positivo;
        } else {
            return -1;
        }
    }
    int quantidade_especies = lerInteiroPositivo("Quantidade de especies existentes");

    private static boolean lerBoolean(String dado) {
        String string_lido = lerString(dado + " [S: sim]");
        if (string_lido == null) {
            return false; 
        }
        if (string_lido.equalsIgnoreCase("S")) {
            return true;
        }
        return false;
    }
    boolean area_mamiferos_periculosidade = lerBoolean("periculosidade Mamiferos");

    private static Periodo lerPeriodo() {
        String periodo_string = lerString("periodo visita [M: Manhã – T: Tarde – I: Integral]");
        if (periodo_string == null) {
            return null;
        }
        if (periodo_string.equalsIgnoreCase("M")) {
            return Periodo.manha;
        } else if (periodo_string.equalsIgnoreCase("T")) {
            return Periodo.tarde;
        } else if (periodo_string.equalsIgnoreCase("I")) {
            return Periodo.integral;
        } else {
            return null;
        }
    }
    private static ContinenteFauna lerContinenteFauna() {
        String continente_fauna_string = lerString("Continente Fauna [AS:America do sul – AN: AméricaNorte – AC: AméricaCentral - EU:Europa - AA:Ásia - AF:África - OA:Oceania - ATD:Antártida]");
        if (continente_fauna_string == null) {
            return null;
        }
        if (continente_fauna_string.equalsIgnoreCase("AS")) {
            return ContinenteFauna.AméricaSul;
        } else if (continente_fauna_string.equalsIgnoreCase("AN")) {
            return ContinenteFauna.AméricaNorte;
        } else if (continente_fauna_string.equalsIgnoreCase("AC")) {
            return ContinenteFauna.AméricaCentral;
        } else if (continente_fauna_string.equalsIgnoreCase("EU")) {
            return ContinenteFauna.Europa;
        } else if (continente_fauna_string.equalsIgnoreCase("AA")) {
            return ContinenteFauna.Ásia;
        } else if (continente_fauna_string.equalsIgnoreCase("AF")) {
            return ContinenteFauna.África;
        } else if (continente_fauna_string.equalsIgnoreCase("OA")) {
            return ContinenteFauna.Oceania;
        } else if (continente_fauna_string.equalsIgnoreCase("ATD")) {
            return ContinenteFauna.Antártida;
        } else {
            return null;
        }
    }
    private static TipoMamifero lerTipoMamifero() {
        String tipo_mamifero_string = lerString("Tipo de Mamifero[MA:Marsupiais - MO:Monotremados - ET:Euterios]");
        if (tipo_mamifero_string == null) {
            return null;
        }
        if (tipo_mamifero_string.equalsIgnoreCase("MA")) {
            return TipoMamifero.marsupiais;
        } else if (tipo_mamifero_string.equalsIgnoreCase("MO")) {
            return TipoMamifero.monotremados;
        } else if (tipo_mamifero_string.equalsIgnoreCase("ET")) {
            return TipoMamifero.euterios;
        } else {
            return null;
        }
    }

    private static TipoAve lerTipoAve() {
        String tipo_ave_string = lerString("Tipo de Ave[RA:Ratitas - CA:Carinatas]");
        if (tipo_ave_string == null) {
            return null;
        }
        if (tipo_ave_string.equalsIgnoreCase("RA")) {
            return TipoAve.ratitas;
        } else if (tipo_ave_string.equalsIgnoreCase("CA")) {
            return TipoAve.carinatas;
        } else {
            return null;
        }
    }

    private static TipoAnfibios lerTipoAnfibios() {
        String tipo_anfibios_string = lerString("Tipo de Anfibios[AN:Anura - UR:Urodela - GA:Gymnophiona]");
        if (tipo_anfibios_string == null) {
            return null;
        }
        if (tipo_anfibios_string.equalsIgnoreCase("AN")) {
            return TipoAnfibios.anura;
        } else if (tipo_anfibios_string.equalsIgnoreCase("UR")) {
            return TipoAnfibios.urodela;
        } else if (tipo_anfibios_string.equalsIgnoreCase("GA")) {
            return TipoAnfibios.gymnophiona;
        } else {
            return null;
        }
    }
    private static Especialista lerEspecialista() {
        String especialista_string = lerString("Especialidade[VT:Veterianario - ZT:Zootecnico - BI:Biologo - EC:Ecologista]");
        if (especialista_string == null) {
            return null;
        }
        if (especialista_string.equalsIgnoreCase("VT")) {
            return Especialista.veterianario;
        } else if (especialista_string.equalsIgnoreCase("ZT")) {
            return Especialista.Zootecnico;
        } else if (especialista_string.equalsIgnoreCase("BI")) {
            return Especialista.biologo;
        } else if (especialista_string.equalsIgnoreCase("EC")) {
            return Especialista.ecologista;
        } else {
            return null;
        }
    }

    private static TipoGrupo lerTipoGrupo() {
        String tipo_grupo_string = lerString("Tipo Grupo[PU:publico - PA:Particular - ER:Escolar - EL:Especial]");
        if (tipo_grupo_string == null) {
            return null;
        }
        if (tipo_grupo_string.equalsIgnoreCase("PU")) {
            return TipoGrupo.publico;
        } else if (tipo_grupo_string.equalsIgnoreCase("PA")) {
            return TipoGrupo.particular;
        } else if (tipo_grupo_string.equalsIgnoreCase("ER")) {
            return TipoGrupo.escolar;
        } else if (tipo_grupo_string.equalsIgnoreCase("EL")) {
            return TipoGrupo.especial;
        } else {
            return null;
        }
    }

    private static Data lerData(String dado) {
        String data_string = lerString(dado + " [dd/mm/aaaa]");
        if (data_string == null) {
            return null;
        }
        return Data.toData(data_string);
    }
    Data data_reserva = lerData("data da reserva");

    private static char lerChar(String dado) {
        String string = lerString(dado);
        if ((string == null) || (string.length() != 1)) {
            return 'X';
        }
        return string.charAt(0); 
    }

    char necessidade_grupo = lerChar("grupo com necessidades especiais");

    public static ArrayList<Visita>selecionarVisitas() {
        System.out.println("--- Leitura de Filtros de Seleção de Visitas ---");
        Periodo periodo_visita = lerPeriodo();
        int quantidade_especies = lerInteiroPositivo("Quantidade de especies até");
        String prefixo_cpf_guia = lerString("prefixo do cpf do guia");
        char grupo_especial = lerChar("Grupo com necessidades especiais [S:sim - N:não]");
        char animal_periculosidade = lerChar("animal perigoso [S:sim - N:não]");
        char animal_venoso = lerChar("animal venenoso [S:sim - N:não]");
        char acesso_viveiro = lerChar("Ave acesso viveiro [S:sim - N:não]");
        Data data_máxima_visita = lerData("data máxima da visita");
        System.out.println("\n --- Filtros de seleção"
                + "\n periodo da visita: " + periodo_visita
                + "\n quantidade de especies até: " + quantidade_especies
                + "\n prefixo cpf do guia: " + prefixo_cpf_guia
                + "\n grupo com necessidades especiais: " + grupo_especial
                + "\n animal perigoso: " + animal_periculosidade
                + "\n animal venenoso: " + animal_venoso
                + "\n Ave acesso viveiro: " + acesso_viveiro
                + "\n data máxima da visita: " + data_máxima_visita);

        return VisitaZoo.selecionarVisitas(periodo_visita, quantidade_especies, prefixo_cpf_guia, grupo_especial, animal_periculosidade, animal_venoso, acesso_viveiro,data_máxima_visita);
    }

    private static SetorZoo lerSetorZoo() {
        String id = lerString("id");
        if (id == null) {
            return null;
        }
        int quantidade_especies = lerInteiroPositivo("Quantidade especies");
        if (quantidade_especies == -1) {
            return null;
        }
        ContinenteFauna continente_fauna = lerContinenteFauna();
        if (continente_fauna == null) {
            return null;
        }
        String tipo_SetorZoo = lerString("Tipo SetorZoo [AM:Area Mamiferos - AV:Area Aves - AF:Area Anfibios]");
        if (tipo_SetorZoo == null) {
            return null;
        }
        if (tipo_SetorZoo.equalsIgnoreCase("AM")) {
            TipoMamifero tipo_mamifero = lerTipoMamifero();
            if (tipo_mamifero == null) {
                return null;
            }
            boolean periculosidade = lerBoolean("Periculosidade do animal");
            return new AreaMamiferos(id, continente_fauna, quantidade_especies, tipo_mamifero, periculosidade);
        }
        if (tipo_SetorZoo.equalsIgnoreCase("AV")) {
            TipoAve tipo_ave = lerTipoAve();
            if (tipo_ave == null) {
                return null;
            }
            boolean acesso_viveiro = lerBoolean("Aves Viveiro");
            return new AreaAves(id, continente_fauna, quantidade_especies, tipo_ave, acesso_viveiro);
        }
        if (tipo_SetorZoo.equalsIgnoreCase("AF")) {
            TipoAnfibios tipo_anfibio = lerTipoAnfibios();
            if (tipo_anfibio == null) {
                return null;
            }
            boolean animal_venenoso = lerBoolean("Animal venenoso");
            return new AreaAnfibios(id, continente_fauna, quantidade_especies, tipo_anfibio, animal_venenoso);
        }

        return null;
    }

    private static Guia lerGuia() {
        String orientador = lerString("nome do guia");
        if (orientador == null) {
            return null;
        }
        String cpf = lerString("cpf do guia");
        if (cpf == null) {
            return null;
        }
        Especialista especialista = lerEspecialista();
        if (especialista == null) {
            return null;
        }
        return new Guia(orientador, cpf, especialista);
    }

    private static Grupo lerGrupo() {
        TipoGrupo tipo_grupo = lerTipoGrupo();
        if (tipo_grupo == null) {
            return null;
        }
        int integrantes = lerInteiroPositivo("Quantidade de integrantes");
        if (integrantes == -1) {
            return null;
        }
        boolean necessidades_especiais = lerBoolean("Grupo especial");
        String id = lerString("ID Grupo");
        if (id == null) {
            return null;
        }
        return new Grupo(id, tipo_grupo, integrantes, necessidades_especiais);
    }

    private static Visita lerVisita() {
        String cpf = lerString("CPF do guia");
        if (cpf == null) {
            return null;
        }
        Guia guia = Guia.getGuia(cpf);
        if (guia == null) {
            System.out.println("- ERRO : não existe guia cadastrado com este CPF");
            return null;
        }
        String id_grupo = lerString("ID do grupo");
        if (id_grupo == null) {
            return null;
        }
        Grupo grupo = Grupo.getGrupo(id_grupo);
        if (grupo == null) {
            System.out.println("- ERRO : não existe grupo cadastrado com este ID");
            return null;
        }
        String id_setor_zoo = lerString("ID SetorZoo");
        if (id_setor_zoo == null) {
            return null;
        }
        SetorZoo setor_zoo = SetorZoo.getSetorZoo(id_setor_zoo);
        if (setor_zoo == null) {
            System.out.println("- ERRO : não existe grupo cadastrado com este ID");
            return null;
        }
        Periodo periodo = lerPeriodo();
        if (periodo == null) {
            return null;
        }
        Data data = lerData("data da visita");
        if (data == null) {
            return null;
        }
        return new Visita(grupo, guia, setor_zoo, periodo, data);
    }

    public static void loopOpçõesExecução() {
        imprimirObjetos("Guias cadastrados", Guia.getGuias().values());
        imprimirObjetos("\nGrupos cadastrados", Grupo.getGrupos().values());
        imprimirObjetos("\nSetorZoo cadastrados", SetorZoo.getSetorZoos().values());
        imprimirObjetos("\nVisitas cadastradas", Visita.getVisitas());
        int opção = 0;
        while (opção != -1) {
            System.out.println("\n1: cadastrar guia -- 2: cadastrar grupo"
                    + " -- 3: cadastrar setorzoo -- 4: cadastrar visita "
                    + "5: selecionar visitas ");
            opção = lerInteiroPositivo(" opção de execução");
            switch (opção) {
                case 1:
                    loopleituraGuias();
                    imprimirObjetos("Guias cadastrados", Guia.getGuias().values());
                    break;
                case 2:
                    loopleituraGrupos();
                    imprimirObjetos("Grupos cadastradas", Grupo.getGrupos().values());
                    break;
                case 3:
                    loopleituraSetorZoos();
                    imprimirObjetos("SetorZoo cadastradas", SetorZoo.getSetorZoos().values());
                    break;
                case 4:
                    loopleituraVisitas();
                    imprimirObjetos("Visitas cadastradas", Visita.getVisitas());
                    break;
                case 5:
                    imprimirObjetos("Visitas selecionadas", selecionarVisitas());
                    break;
            }
        }
    }

    public static void loopleituraSetorZoos() {
        boolean parar_cadastrar = false;
        System.out.println("--- Leitura de Dados de SetorZOO ---");
        while (!parar_cadastrar) {
            SetorZoo setor_zoo = lerSetorZoo();
            if (setor_zoo != null) {
                boolean sucesso = SetorZoo.add(setor_zoo);
                if (!sucesso) {
                    System.out.println("- ERRO : já existe um setorzoo com o mesmo id");
                }
            } else {
                System.out.println("- ERRO : na leitura do id setorzoo");
            }
            parar_cadastrar = lerBoolean("parar de cadastrar");
        }
    }

    public static void loopleituraVisitas() {
        boolean parar_cadastrar = false;
        System.out.println("--- Leitura de Dados de Visita ---");
        while (!parar_cadastrar) {
            Visita visita = lerVisita();
            if (visita != null) {
                boolean sucesso = Visita.add(visita);
                if (!sucesso) {
                    System.out.println("- ERRO : já existe uma visita cadastrada");
                }
            } else {
                System.out.println("- ERRO : na leitura da visita");
            }
            parar_cadastrar = lerBoolean("parar de cadastrar");
        }
    }

    public static void loopleituraGuias() {
        boolean parar_cadastrar = false;
        System.out.println("--- Leitura de Dados de Guia ---");
        while (!parar_cadastrar) {
            Guia guia = lerGuia();
            if (guia != null) {
                boolean sucesso = Guia.add(guia);
                if (!sucesso) {
                    System.out.println("- ERRO : já existe um guia com o mesmo nome");
                }
            } else {
                System.out.println("- ERRO : na leitura do guia");
            }
            parar_cadastrar = lerBoolean("parar de cadastrar");
        }
    }

    public static void loopleituraGrupos() {
        boolean parar_cadastrar = false;
        System.out.println("--- Leitura de Dados de Grupo ---");
        while (!parar_cadastrar) {
            Grupo grupo = lerGrupo();
            if (grupo != null) {
                boolean sucesso = Grupo.add(grupo);
                if (!sucesso) {
                    System.out.println("- ERRO : já existe um grupo com o mesmo ID grupo");
                }
            } else {
                System.out.println("- ERRO : na leitura do grupo");
            }
            parar_cadastrar = lerBoolean("parar de cadastrar");
        }
    }

    public static void imprimirObjetos(String cabeçalho, Collection objetos) {
        if (objetos.isEmpty()) {
            return;
        }
        System.out.println(cabeçalho);
        for (Object objeto : objetos) {
            System.out.println(objeto);
        }
    }
}