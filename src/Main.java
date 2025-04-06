import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAdder;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> alunos = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();
        ArrayList<Double> medias = new ArrayList<>();

        String status = "";

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
                        soma = notas.getLast();

                        System.out.print("Digite a segunda nota de " + alunos.getLast() + ": ");
                        notas.add(scan.nextDouble());
                        while(notas.getLast() > 10 || notas.getLast() < 0){
                            notas.removeLast();
                            System.out.println("Digite uma nota válida! ");
                            notas.add(scan.nextDouble());
                        }
                        soma += notas.getLast();
                        medias.add(soma / 2);
                        System.out.println("DEV soma: " + soma);

                        System.out.println("");

                    }
                    break;

                case 2:
                    System.out.println("#### NOTAS DOS ALUNOS ####");

                    for(int i = 0; i <= alunos.size(); i++){
                        if(medias.get(i) >= 7) {
                        status = "Aprovado";
                    }
                    else if(medias.get(i) >= 5 && medias.get(i) < 7){
                        status = "Recuperacao";
                    }
                    else{
                        status = "Reprovado";
                    }
                        System.out.println("Aluno: " + alunos.getFirst() + " - Média: " + medias.get(i) + " Status: " + status);

                    }
                    break;
                case 3:
                    System.out.println("#### RESULTADO DA TURMA ####");

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