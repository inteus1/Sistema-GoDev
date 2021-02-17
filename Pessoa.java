package treinamento;

public class Pessoa {
    //Atributos de pessoa
    private String nome, sobrenome;
    private String sala [] = new String [2], espaco [] = new String [2];

    //Geters e Setters
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String[] getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        if (this.sala[0] == null){
            this.sala[0] = sala.getNome();
        } else {
            this.sala[1] = sala.getNome();
        }
    }

    public String[] getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        if (this.espaco[0] == null){
            this.espaco[0] = espaco.getNome();
        } else {
            this.espaco[1] = espaco.getNome();
        }
    }
    
    //Construtor
    public Pessoa(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    //Exibição de informação
    public void info(){
        System.out.println("\nNome: " + getNome() +
                "\nEtapa 1: Sala " + getSala()[0] +
                "\nEtapa 2: Sala " + getSala()[1] +
                "\nIntervalo 1: Espaço " + getEspaco()[0] +
                "\nIntervalo 2: Espaço " + getEspaco()[1]);
        System.out.println();
    }
}
