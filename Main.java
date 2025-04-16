import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nome = "Elian Barros";
        String tipoDeConta = "Corrente";
        double saldo = 6000;
        String saldoFormatado = String.format("R$%.2f", saldo);
        String menu = "\nOperacoes: \n\n1) Consultar saldos\n2) Receber Valor\n3) Transferir Valor\n4) Sair\n";
        System.out.println("=".repeat(40));
        System.out.printf("Dados iniciais do cliente: %n%n");
        System.out.printf("Nome: %28s %n", nome);
        System.out.printf("Tipo de conta: %15s %n", tipoDeConta);
        System.out.printf("Saldo inicial: %16s %n", saldoFormatado);
        System.out.println("=".repeat(40));
        int opcao = -1;

        while(opcao != 4) {
            System.out.println(menu);
            System.out.print("Digite a opcao desejada: ");
            opcao = leitura.nextInt();
            if (opcao == 1) {
                System.out.printf("Saldo atual: %s", saldoFormatado);
            } else if (opcao == 2) {
                System.out.print("Digite o valor a ser recebido: ");
                double valorRecebido = leitura.nextDouble();
                saldo += valorRecebido;
                System.out.printf("Saldo atualizado %.2f", saldo);
            } else if (opcao == 3) {
                System.out.print("Informe o valor que deseja tranferir: ");
                double valorTranferido = leitura.nextDouble();
                if (valorTranferido > saldo) {
                    System.out.println("Saldo insuficiente para realizar essa transferencia");
                } else if (valorTranferido < (double)0.0F) {
                    System.out.println("Valor invalido");
                } else {
                    saldo -= valorTranferido;
                    System.out.printf("Saldo atualizado %.2f", saldo);
                }
            } else {
                if (opcao == 4) {
                    System.out.println("Saindo...");
                    break;
                }

                System.out.println("Opcao invalida");
            }
        }

    }
}
