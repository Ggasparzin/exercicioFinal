import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> alunos = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();
        ArrayList<Double> medias = new ArrayList<>();

        String status;

        double soma = 0;
        double mediaTurma = 0;
        double somaMedia = 0;
        double maiorNota = 0;
        double menorNota = 0;

        int alunosAprovados = 0;
        int alunosReprovados = 0;
        int alunosRecuperacao = 0;

        int cadastro;
        int qntAlunos = 0;

        do {
            System.out.println("##### MENU #####");
            System.out.println("1 - Cadastrar alunos");
            System.out.println("2 - Consultar notas");
            System.out.println("3 - Consultar resultado da turma");
            System.out.println("4 - Sair");

            cadastro = scan.nextInt();
            switch (cadastro) {
                case 1:
                    alunos.clear();
                    medias.clear();
                    System.out.print("\nQuantos alunos deseja cadastrar? ");
                    qntAlunos = scan.nextInt();

                    for (int i = 0; i < qntAlunos; i++) {
                        System.out.println("Digite o nome do aluno: ");
                        alunos.add(scan.next());

                        System.out.print("Digite a nota de " + alunos.getLast() + ": ");
                        notas.add(scan.nextDouble());
                        while (notas.getLast() > 10 || notas.getLast() < 0) {
                            notas.removeLast();
                            System.out.println("Digite uma nota válida! ");
                            notas.add(scan.nextDouble());
                        }
                        soma = notas.getLast();

                        System.out.print("Digite a segunda nota de " + alunos.getLast() + ": ");
                        notas.add(scan.nextDouble());
                        while (notas.getLast() > 10 || notas.getLast() < 0) {
                            notas.removeLast();
                            System.out.println("Digite uma nota válida! ");
                            notas.add(scan.nextDouble());
                        }
                        soma += notas.getLast();
                        medias.add(soma / 2);
                        System.out.println("DEV MEDIAS: " + medias);

                        System.out.println("");

                    }
                    break;

                case 2:
                    System.out.println("#### NOTAS DOS ALUNOS ####");

                    alunosAprovados = 0;
                    alunosReprovados = 0;
                    alunosRecuperacao = 0;

                    for (int i = 0; i < qntAlunos; i++) {
                        if (medias.get(i) >= 7) {
                            status = "Aprovado";
                            alunosAprovados += 1;
                        } else if (medias.get(i) >= 5 && medias.get(i) < 7) {
                            status = "Recuperacao";
                            alunosRecuperacao += 1;
                        } else {
                            status = "Reprovado";
                            alunosReprovados += 1;
                        }
                        System.out.printf("\nAluno: %s - Média: %.1f - Status: %s ",alunos.get(i), medias.get(i),status);

                    }
                    break;
                case 3:
                    System.out.println("#### RESULTADO DA TURMA ####");

                    for (Double media : medias) {
                        somaMedia += media;
                        mediaTurma = somaMedia / medias.size();
                    }
                    System.out.println("Média da turma: " + mediaTurma);

                    for(double nota : notas){
                        if(maiorNota < nota){
                            maiorNota = nota;
                        }
                        if(menorNota > nota){
                            menorNota = nota;
                        }
                    }
                    System.out.println("Maior nota: " + maiorNota);
                    System.out.println("Menor nota: " + menorNota);

                    System.out.println("\nAlunos aprovados: " + alunosAprovados);
                    System.out.println("Alunos em recuperação: " + alunosAprovados);
                    System.out.println("Alunos reprovados: " + alunosReprovados);
                    break;
            }
        }
        while(cadastro != 4);
    }
}