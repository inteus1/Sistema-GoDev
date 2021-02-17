package treinamento;

import java.util.ArrayList;

public class Sala {
    //Atributos de sala
    private String nome;
    private int lotacao;
    private ArrayList<String> pessoas1 = new ArrayList<String>();
    private ArrayList<String> pessoas2 = new ArrayList<String>();

    //Geters e Setters
    public String getNome() {
        return nome;
    }

    public int getLotacao() {
        return lotacao;
    }

    //Construtor
    public Sala(String nome, int lotacao) {
        this.nome = nome;
        this.lotacao = lotacao;
    }

    //Adição de pessoas na sala
    public void addPessoas(Pessoa pessoa, boolean etapa) {
        //Verificação de etapa
        if (etapa) {
            //Se ainda há espaço
            if (pessoas1.size() < lotacao) {
                //Adicionar pessoa à sala na etapa 1
                pessoas1.add(pessoa.getNome() + " " + pessoa.getSobrenome());
            } else { //Senão
                //Informar lotação
                System.out.println("Essa sala está lotada/");
            }
        } else {
            //Se ainda há espaço
            if (pessoas2.size() < lotacao) {
                //Adicionar pessoa à sala na etapa 2
                pessoas2.add(pessoa.getNome() + " " + pessoa.getSobrenome());
            } else {//Senão
                //Informar lotação
                System.out.println("Essa sala está lotada/");
            }
        }
    }

    //Exibição de informação
    public void info() {
        System.out.print("\nSala " + this.nome + "\nEtapa 1: ");
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
