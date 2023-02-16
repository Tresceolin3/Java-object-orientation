package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistênciaArquivo implements Serializable{

    public static void salvar(Object objeto_raiz, String arquivo) {
        if (objeto_raiz == null) {
            return;
        }
        try {
            ObjectOutputStream saída = new ObjectOutputStream(new FileOutputStream(arquivo));
            saída.writeObject(objeto_raiz);
            saída.close();
        } catch (Exception exceção) {
            System.out.println("Falha ao salvar no arquivo: " + arquivo + "\n");
        }
    }

    public static Object recuperar(String arquivo) {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arquivo));
            Object objeto_raiz = entrada.readObject();
            return objeto_raiz;
        } catch (Exception exceção) {
            System.out.println("Falha na recuperação do arquivo: " + arquivo + "\n");
            return null;
        }
    }
}
