package util;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Data implements Serializable {

    public static Data toData(String data_string) {
        if (!data_string.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("- ERRO na conversão para data do string: " + data_string);
            return null;
        }
        String[] partes = data_string.split("/");
        return new Data(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]),
                Integer.parseInt(partes[2]));
    }

    private int dia, mês, ano;

    public Data(int dia, int mês, int ano) {
        this.dia = dia;
        this.mês = mês;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMês() {
        return mês;
    }

    public void setMês(int mês) {
        this.mês = mês;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        String data;
        if (dia < 10) {
            data = "0" + dia;
        } else {
            data = "" + dia; // lembre-se : artifício para converter um inteiro para string
        }
        if (mês < 10) {
            data += "/0" + mês + "/";
        } else {
            data += "/" + mês + "/";
        }
        return data += ano;
    }

    public int compareTo(Data outraData) {
        if (ano > outraData.getAno()) {
            return 1;
        }
        if (ano < outraData.getAno()) {
            return -1;
        }
        if (mês > outraData.getMês()) {
            return 1;
        }
        if (mês < outraData.getMês()) {
            return -1;
        }
        if (dia > outraData.getDia()) {
            return 1;
        }
        if (dia < outraData.getDia()) {
            return -1;
        }
        return 0;
    }

    public int calcularIdade() {
        GregorianCalendar data_atualGregorianCalendar = new GregorianCalendar();
        int dia_atual = data_atualGregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int mês_atual = data_atualGregorianCalendar.get(Calendar.MONTH) + 1;
        // no GregorianCalendar: mês varia de 0 a 11
        int ano_atual = data_atualGregorianCalendar.get(Calendar.YEAR);
        int idade = ano_atual - ano;
        if ((mês_atual < mês) || ((mês_atual == mês) && (dia_atual < dia))) {
            idade--;
        }
        return idade;
    }

}
