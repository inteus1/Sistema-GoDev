package treinamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Treinamento {

    //Listas
    public static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    public static ArrayList<Sala> salas = new ArrayList<Sala>();
    public static ArrayList<Espaco> espacos = new ArrayList<Espaco>();

    //Entrada de dados
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Leitura de dados salvos
        read();

        //Processamento de divisão de pessoas em sala
        algoritimo();

        //Menu para interação
        menu();
    }

    //Menu de opções principal
    public static void menu() {
        //Variável de escolha
        int opcao;

        //Repetição principal
        do {
            System.out.print("\nEscolha uma das opções abaixo:"
                    + "\n1 - Cadastrar"
                    + "\n2 - Remover"
                    + "\n3 - Buscar"
                    + "\n4 - Mostrar"
                    + "\n5 - Encerrar"
                    + "\nEscolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            //Verificação de escolha
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    info();
                    System.out.println("Pressione enter para continuar");
                    sc.nextLine();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nOpção inválida\nPressione enter para continuar");
                    sc.nextLine();
            }
        } while (opcao != 5);
    }

    //Menu de cadastro
    public static void cadastrar() {
        System.out.print("\nEscolha uma das opções abaixo:"
                + "\n1 - Pessoa"
                + "\n2 - Sala"
                + "\n3 - Espaço"
                + "\n4 - Voltar"
                + "\nEscolha: ");
        int opcao = Integer.parseInt(sc.nextLine());
        String s;
        switch (opcao) {
            case 1:
                System.out.print("\nInsira o nome e sobrenome da pessoa: ");
                s = sc.nextLine();
                //Separação da string recebida, geração de pessoa e armazenamento na lista
                pessoas.add(new Pessoa(s.split(" ")[0], s.split(" ")[1]));
                writeP();
                break;
            case 2:
                System.out.print("\nInsira o nome da sala: ");
                s = sc.nextLine();
                System.out.print("\nInsira a capacidade da sala: ");
                int i = Integer.parseInt(sc.nextLine());
                //Geração de sala e armazenamento na lista
                salas.add(new Sala(s, i));
                writeS();
                break;
            case 3:
                System.out.print("\nInsira o nome do espaço: ");
                s = sc.nextLine();
                //Geração de espaço e armazenamento na lista
                espacos.add(new Espaco(s));
                writeE();
                break;
            case 4:
                break;
            default:
                System.out.println("\nOpção inválida\nPressione enter para continuar");
                sc.nextLine();
        }
    }

    //Menu de remoção de elemento
    public static void remover() {
        System.out.print("\nEscolha uma das opções abaixo:"
                + "\n1 - Pessoa"
                + "\n2 - Sala"
                + "\n3 - Espaço"
                + "\n4 - Voltar"
                + "\nEscolha: ");
        int opcao = Integer.parseInt(sc.nextLine());
        String s;
        switch (opcao) {
            case 1:
                System.out.print("\nInsira o nome e sobrenome da pessoa: ");
                s = sc.nextLine();
                //Busca e remoção de pessoa e atualização da lista
                for (Pessoa p : pessoas) {
                    if ((p.getNome() + " " + p.getSobrenome()).equals(s)) {
                        pessoas.remove(p);
                        writeP();
                        return;
                    }
                }
                System.out.println("Pessoa não encontrada");
                break;
            case 2:
                System.out.print("\nInsira o nome da sala: ");
                s = sc.nextLine();
                //Busca e remoção de sala e atualização da lista
                for (Sala sa : salas) {
                    if ((sa.getNome()).equals(s)) {
                        salas.remove(sa);
                        writeS();
                        return;
                    }
                }
                System.out.println("Pessoa não encontrada");
                break;
            case 3:
                System.out.print("\nInsira o nome do espaço: ");
                s = sc.nextLine();
                //Busca e remoção de espaço e atualização da lista
                for (Espaco e : espacos) {
                    if ((e.getNome()).equals(s)) {
                        espacos.remove(e);
                        writeE();
                        return;
                    }
                }
                System.out.println("Pessoa não encontrada");
                break;
            case 4:
                break;
            default:
                System.out.println("\nOpção inválida\nPressione enter para continuar");
                sc.nextLine();
        }
    }

    //Menu de busca de elemento
    public static void buscar() {
        System.out.print("\nEscolha uma das opções abaixo:"
                + "\n1 - Pessoa"
                + "\n2 - Sala"
                + "\n3 - Espaço"
                + "\n4 - Voltar"
                + "\nEscolha: ");
        int opcao = Integer.parseInt(sc.nextLine());
        String s;
        switch (opcao) {
            case 1:
                System.out.print("\nInsira o nome e sobrenome da pessoa: ");
                s = sc.nextLine();
                //Busca de pessoa e impressão de informações
                buscarP(s);
                break;
            case 2:
                System.out.print("\nInsira o nome da sala: ");
                s = sc.nextLine();
                //Busca de sala e impressão de informações
                buscarS(s);
                break;
            case 3:
                System.out.print("\nInsira o nome do espaço: ");
                s = sc.nextLine();
                //Busca de espaço e impressão de informações
                buscarE(s);
                break;
            case 4:
                break;
            default:
                System.out.println("\nOpção inválida");
        }
        System.out.println("Pressione enter para continuar");
        sc.nextLine();
    }

    //Algoritimo para processamento de vagas 
    public static void algoritimo() {
        //Variáveis auxiliares
        int i = 0, //Índice de pessoa
                j = 0, //Índice de sala
                k = 0; //Índice de espaço

        //Repetição principal
        do {
            //Se passar da última sala, volte para a primeira
            if (j == salas.size()) {
                j = 0;
            }
            //Se passar do último espaço, volte para o primeiro
            if (k == espacos.size()) {
                k = 0;
            }

            //Vincular pessoas com salas e espaços para a etapa 1
            pessoas.get(i).setSala(salas.get(j));
            pessoas.get(i).setEspaco(espacos.get(k));
            salas.get(j).addPessoas(pessoas.get(i), true);
            espacos.get(k).addPessoas(pessoas.get(i), true);

            //Verificar se está na primeira ou segunda metade das pessoas
            if (i < pessoas.size() / 2) {
                //Se não estiver na última sala
                if (j < salas.size() - 1) {
                    //Próxima sala
                    j++;
                } else { //Senão,
                    //Volte para a primeira sala
                    j = 0;
                }
                //Se não estiver no último espaço
                if (k < espacos.size() - 1) {
                    //Próximo espaço
                    k++;
                } else {//Senão,
                    //Volte para o primeiro espaço
                    k = 0;
                }
            }

            //Vincular pessoas com salas e espaços para a etapa 2
            pessoas.get(i).setSala(salas.get(j));
            pessoas.get(i).setEspaco(espacos.get(k));
            espacos.get(k).addPessoas(pessoas.get(i), false);
            salas.get(j).addPessoas(pessoas.get(i), false);

            //Verificar se está na primeira ou segunda metade das pessoas
            if (i < pessoas.size() / 2) {
                //Se não estiver na primeira sala
                if (j > 0) {
                    //Sala anterior
                    j--;
                } else { //Senão
                    //Última sala
                    j = salas.size() - 1;
                }
                //Se não estiver no primeiro espaço
                if (k > 0) {
                    //Espaço anterior
                    k--;
                } else {
                    //Último espaço
                    k = espacos.size() - 1;
                }
            }

            //Próxima pessoa, sala e espaço
            i++;
            j++;
            k++;
        } while (i < pessoas.size());
    }

    //Exibição de informações
    public static void info() {
        System.out.println("\nPessoas: ");
        //Varredura e exibição de pessoas
        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.getNome() + " " + p.getSobrenome());
        }
        //Varredura e exibição de salas
        System.out.println("\nSalas: ");
        for (Sala s : salas) {
            System.out.println("Nome: " + s.getNome() + " (" + s.getLotacao() + " vagas)");
        }
        //Varredura e exibição espaços
        System.out.println("\nEspaços: ");
        for (Espaco e : espacos) {
            System.out.println("Nome: " + e.getNome());
        }
        System.out.println();
    }

    //Busca de pessoa
    public static void buscarP(String s) {
        //Varredura e exibição de pessoa
        for (Pessoa p : pessoas) {
            if ((p.getNome() + " " + p.getSobrenome()).equals(s)) {
                p.info();
                return;
            }
        }
        System.out.println("Pessoa não encontrada");
    }

    //Busca de sala
    public static void buscarS(String s) {
        //Varredura e exibição de sala
        for (Sala sa : salas) {
            if ((sa.getNome()).equals(s)) {
                sa.info();
                return;
            }
        }
        System.out.println("Sala não encontrada");
    }

    //Busca de espaço
    public static void buscarE(String s) {
        //Varredura e exibição de espaço
        for (Espaco e : espacos) {
            if ((e.getNome()).equals(s)) {
                e.info();
                return;
            }
        }
        System.out.println("Espaço não encontrado");
    }

    //Escrevendo arquivo de texto para persistência de pessoas
    public static void writeP() {
        //Inicialização de escritor
        PrintWriter writer = null;
        try {
            //Definição de arquivo
            writer = new PrintWriter("Pessoas.txt");
            //Escrever a quantidade de pessoas
            String texto = pessoas.size() + "\n";
            //Varredura e armazenamento de pessoas
            for (Pessoa p : pessoas) {
                texto += p.getNome() + "\n" + p.getSobrenome() + "\n";
            }
            //Escrever para o arquivo
            writer.println(texto);
        } catch (Exception e) {
            //Verificação de erro
            System.out.println("1" + e);
        } finally {
            //Encerramento do escritor
            writer.close();
        }
    }

    //Escrevendo arquivo de texto para persistência de salas
    public static void writeS() {
        //Inicialização de escritor
        PrintWriter writer = null;
        try {
            //Definição de arquivo
            writer = new PrintWriter("Salas.txt");
            //Escrever a quantidade de salas
            String texto = salas.size() + "\n";
            //Varredura e armazenamento de salas
            for (Sala s : salas) {
                texto += s.getNome() + "\n" + s.getLotacao() + "\n";
            }
            //Escrever para o arquivo
            writer.println(texto);
        } catch (Exception e) {
            //Verificação de erro
            System.out.println("2" + e);
        } finally {
            //Encerramento do escritor
            writer.close();
        }
    }

    //Escrevendo arquivo de texto para persistência de espaços
    public static void writeE() {
        //Inicialização de escritor
        PrintWriter writer = null;
        try {
            //Definição de arquivo
            writer = new PrintWriter("Espaços.txt");
            //Escrever a quantidade de espaços
            String texto = espacos.size() + "\n";
            //Varredura e armazenamento de espaços
            for (Espaco e : espacos) {
                texto += e.getNome() + "\n";
            }
            //Escrever para o arquivo
            writer.println(texto);
        } catch (Exception e) {
            //Verificação de erro
            System.out.println("3" + e);
        } finally {
            //Encerramento do escritor
            writer.close();
        }
    }

    //Lendo arquivo de texto para persistência
    public static void read() {
        //Inicialização do leitor
        BufferedReader br = null;

        //Variáveis auxiliares
        String s = ""; //Informação lida
        int n; //Quantidade de objetos para ler

        try {
            //Definição de arquivo
            br = new BufferedReader(new FileReader("Pessoas.txt"));
            //Leitura da quantidade de pessoas
            n = Integer.parseInt(br.readLine());
            //Leitura do numero de pessoas definido acima
            for (int i = 0; i < n; i++) {
                //Geração e armazenamento de pessoa com base nas próximas duas linhas lidas
                pessoas.add(new Pessoa(br.readLine(), br.readLine()));
            }
            
            //Redefinição de arquivo
            br = new BufferedReader(new FileReader("Salas.txt"));
            //Leitura da quantidade de salas
            n = Integer.parseInt(br.readLine());
            //Leitura do numero de salas definido acima
            for (int i = 0; i < n; i++) {
                //Geração e armazenamento de sala com base nas próximas duas linhas lidas
                salas.add(new Sala(br.readLine(), Integer.parseInt(br.readLine())));
            }
            
            //Redefinição de arquivo
            br = new BufferedReader(new FileReader("Espaços.txt"));
            //Leitura da quantidade de espaços
            n = Integer.parseInt(br.readLine());
            //Leitura do numero de espaços definido acima
            for (int i = 0; i < n; i++) {
                //Geração e armazenamento de sala com base próxima linha lida
                espacos.add(new Espaco(br.readLine()));
            }

        } catch (Exception e) {
            //Verificação de errro
            System.out.println("4" + e);
        } finally {
            try {
                //Encerramento do leitor
                br.close();
            } catch (Exception e) {
                //Verificação de erro
                System.out.println("5" + e);
            }

        }
    }
}
