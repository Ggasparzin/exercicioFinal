import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Quantos alunos deseja cadastrar? ");
        int alunos = scan.nextInt();
        String[] status = new String[alunos];

        String [] nomes = new String[alunos];
        double[][] notas = new double [alunos][2];
        double [] media = new double[alunos];
        double soma = 0;

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
                    soma = soma + nota2;

            media[i] = soma / 2;
            System.out.println("Media: " + media[i]);

            if(media[i] >= 7) {
                status[i] = "Aprovado";
            }
            else if(media[i] >= 5 && media[i] < 7){
                status[i] = "Recuperacao";
                }
            else{
                status[i] = "Reprovado";
            }
        }

    }
}