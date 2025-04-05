import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int posicao = 0;
        int posicao2 = 1;

        ArrayList<String> alunos = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();

        double soma = 0;
        double mediaTurma = 0;
        double somaMedia = 0;

        int alunosAprovados = 0;
        int alunosReprovados = 0;
        int alunosRecuperacao = 0;

        int cadastro;

        do{
            System.out.println("##### MENU #####");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Consultar notas");
            System.out.println("3 - Consultar resultado da turma");
            System.out.println("4 - Sair");

            cadastro = scan.nextInt();
            switch(cadastro){
                case 1:
                    System.out.print("\nQuantos alunos deseja cadastrar? ");
                    int qntAlunos = scan.nextInt();
                    for(int i = 0; i < qntAlunos; i++){
                        System.out.println("Digite o nome do aluno: ");
                        alunos.add(scan.next());

                        System.out.print("Digite a nota de " + alunos.getLast() + ": ");
                        notas.add(scan.nextDouble());
                        while(notas.getLast() > 10 || notas.getLast() < 0){
                            notas.removeLast();
                            System.out.println("Digite uma nota válida! ");
                            notas.add(scan.nextDouble());
                        }

                        System.out.print("Digite a segunda nota de " + alunos.getLast() + ": ");
                        notas.add(scan.nextDouble());
                        while(notas.getLast() > 10 || notas.getLast() < 0){
                            notas.removeLast();
                            System.out.println("Digite uma nota válida! ");
                            notas.add(scan.nextDouble());
                        }

                        System.out.println("");

                    }

                    System.out.println("Dev - Alunos: " + alunos + " - Notas: " + notas );
                    break;
                case 2:
                    System.out.println("#### NOTAS DOS ALUNOS ####");

                    for(int i = 0; i <= alunos.size(); i += 2){
                        if(i == 0){
                            System.out.println("\nAluno: " + alunos.get(i) + " Média: " + (notas.get(i) + notas.get(i + 1)) / 2);
                            //formatar depois
                        }
                        else{
                            System.out.println("Aluno: " + alunos.get(i -= 1) + " Média: " + (notas.get(i) + notas.get(i + 1)) / 2);
                            //formatar depois
                        }
                    }
                    break;
                case 3:
                    System.out.println("#### RESULTADO DA TURMA ####");


            }

//
//
//                if(medias[i] >= 7) {
//                    status[i] = "Aprovado";
//                }
//                else if(medias[i] >= 5 && medias[i] < 7){
//                    status[i] = "Recuperacao";
//                }
//                else{
//                    status[i] = "Reprovado";
//                }
//            }
//
//            System.out.println("Resultado:\n");

//            for(int i = 0; i < alunos; i++) {
//                System.out.print(nomes[i] + " - ");
//                System.out.printf("Media: %.1f - Status %s \n", medias[i], status[i]);
//            }
//
//            for(double media : medias){
//                somaMedia += media;
//            }
//
//            mediaTurma = somaMedia / alunos;
//                System.out.printf("\nMédia da turma: %.1f", mediaTurma);
//
//            double maiorNota = notas[0][0];
//            double menorNota = notas[0][0];
//
//            for(double [] linha : notas){
//                for(double nota : linha){
//
//                    if(nota > maiorNota){
//                        maiorNota = nota;
//                    }
//                    if(nota < menorNota){
//                        menorNota = nota;
//                    }
//                }
//            }
//            System.out.println("\nMenor nota: " + menorNota);
//            System.out.println("Maior nota: " + maiorNota);
//
//            for(String stats : status){
//                if(stats.equals("Aprovado")){
//                    alunosAprovados += 1;
//                }
//                if(stats.equals("Reprovado")){
//                    alunosReprovados += 1;
//                }
//                if(stats.equals("Recuperacao")){
//                    alunosRecuperacao += 1;
//                }
//            }
//            System.out.println("\nAlunos aprovados: " + alunosAprovados);
//            System.out.println("Alunos reprovados: " + alunosReprovados);
//            System.out.println("Alunos em recuperacao: " + alunosRecuperacao);
//
//            System.out.print("\nDeseja cadastrar outra turma? ");
//                cadastro = scan.next();
        }
        while(cadastro != 4);
    }
}