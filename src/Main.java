import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double soma = 0;
        double mediaTurma = 0;
        double somaMedia = 0;

        int alunosAprovados = 0;
        int alunosReprovados = 0;
        int alunosRecuperacao = 0;

        String cadastro;

        do{
            System.out.print("Quantos alunos deseja cadastrar? ");
            int alunos = scan.nextInt();

            String[] status = new String[alunos];
            String [] nomes = new String[alunos];
            double[][] notas = new double [alunos][2];
            double [] medias = new double[alunos];

            for(int i = 0; i < alunos; i++) {
                System.out.print("Aluno " + (i + 1) +": ");
                String nome = scan.next();
                nomes[i] = nome;

                System.out.print("Nota 1: ");
                double nota1 = scan.nextDouble();
                while(nota1 > 10 || nota1 < 0){
                    System.out.println("Digite uma nota valida! ");
                    nota1 = scan.nextDouble();
                }
                notas[i][0] = nota1;
                soma = nota1;

                System.out.print("Nota 2: ");
                double nota2 = scan.nextDouble();
                while(nota2 > 10 || nota2 < 0){
                    System.out.println("Digite uma nota valida! ");
                    nota2 = scan.nextDouble();
                }
                notas[i][1] = nota2;
                soma += nota2;

                medias[i] = soma / 2;

                if(medias[i] >= 7) {
                    status[i] = "Aprovado";
                }
                else if(medias[i] >= 5 && medias[i] < 7){
                    status[i] = "Recuperacao";
                }
                else{
                    status[i] = "Reprovado";
                }
            }

            System.out.println("Resultado:\n");

            for(int i = 0; i < alunos; i++) {
                System.out.print(nomes[i] + " - ");
                System.out.printf("Media: %.1f - Status %s \n", medias[i], status[i]);
            }

            for(double media : medias){
                somaMedia += media;
            }

            mediaTurma = somaMedia / alunos;
                System.out.printf("\nMédia da turma: %.1f", mediaTurma);

            double maiorNota = notas[0][0];
            double menorNota = notas[0][0];

            for(double [] linha : notas){
                for(double nota : linha){

                    if(nota > maiorNota){
                        maiorNota = nota;
                    }
                    if(nota < menorNota){
                        menorNota = nota;
                    }
                }
            }
            System.out.println("\nMenor nota: " + menorNota);
            System.out.println("Maior nota: " + maiorNota);

            for(String stats : status){
                if(stats.equals("Aprovado")){
                    alunosAprovados += 1;
                }
                if(stats.equals("Reprovado")){
                    alunosReprovados += 1;
                }
                if(stats.equals("Recuperacao")){
                    alunosRecuperacao += 1;
                }
            }
            System.out.println("\nAlunos aprovados: " + alunosAprovados);
            System.out.println("Alunos reprovados: " + alunosReprovados);
            System.out.println("Alunos em recuperacao: " + alunosRecuperacao);

            System.out.print("\nDeseja cadastrar outra turma? ");
                cadastro = scan.next();
        }
        while(cadastro.equalsIgnoreCase("Sim"));
    }
}