package treinamento;

import java.util.ArrayList;

public class Espaco {

    //Atributos de espaço
    private String nome;
    private ArrayList<String> pessoas1 = new ArrayList<String>();
    private ArrayList<String> pessoas2 = new ArrayList<String>();

    //Geters e Setters
    public String getNome() {
        return nome;
    }

    //Construtor
    public Espaco(String nome) {
        this.nome = nome;
    }

    //Adição de pessoas no espaço
    public void addPessoas(Pessoa pessoa, boolean etapa) {
        //Verificação de etapa
        if (etapa) {
            //Adicionar pessoa ao espaço na etapa 1
            pessoas1.add(pessoa.getNome() + " " + pessoa.getSobrenome());
        } else {
            //Adicionar pessoa ao espaço na etapa 2
            pessoas2.add(pessoa.getNome() + " " + pessoa.getSobrenome());
        }
    }

    //Exibição de informação
    public void info() {
        System.out.print("\nEspaço " + this.nome + "\nEtapa 1: ");
        for (int i = 0; i < pessoas1.size(); i++) {
            if (i == 0) {
                System.out.print(pessoas1.get(i));
            } else if (i < pessoas1.size() - 1) {
                System.out.print(", " + pessoas1.get(i));
            } else {
                System.out.println("e " + pessoas1.get(i) + ".");
            }
        }
        System.out.print("Etapa 2: ");
        for (int i = 0; i < pessoas2.size(); i++) {
            if (i == 0) {
                System.out.print(pessoas2.get(i));
            } else if (i < pessoas2.size() - 1) {
                System.out.print(", " + pessoas2.get(i));
            } else {
                System.out.println(" e " + pessoas2.get(i) + ".");
            }
        }
        System.out.println();
    }
}
