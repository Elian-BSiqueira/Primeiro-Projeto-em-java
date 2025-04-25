import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int VerificarInteiro(String texto,int minimo, int maximo) {
        Scanner scan = new Scanner(System.in);
        boolean controleDeLoop = true;
        int numero = 0;

        while (controleDeLoop) {
            System.out.print(texto);
            try {
                numero = scan.nextInt();
                if (numero < minimo || numero > maximo) {
                    scan.nextLine();
                    System.out.printf("DIGITE UM NUMERO ENTRE %d E %d %n", minimo, maximo);
                } else {
                    controleDeLoop = false;
                }

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("DIGITE UM NUMERO INTEIRO");
            }
        }
        return numero;
    }

    static double VerificarDouble(String texto) {
        Scanner scan = new Scanner(System.in);
        boolean controleDeLoop = true;
        double numero = 0;

        while (controleDeLoop) {
            System.out.print(texto);
            try {
                numero = scan.nextDouble();
                controleDeLoop = false;

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("DIGITE UM NUMERO");
            }
        }
        return numero;
    }

    static double VerificarDoublePositivo(double valor, String texto) {
        String textoComErro = "Digite um valor positivo. " + texto;
        while (valor < 0) {
            valor = VerificarDouble(textoComErro);
            }
            return valor;
        }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite seus dados iniciais");
        System.out.print("Digite seu nome: ");
        String nome;
        while (true) {
            nome = (leitura.nextLine()).strip();

            if (!nome.equals("")) {
                break;
            } else {
                System.out.print("Campo obrigatorio. Digite seu nome: ");
            }
        }
        String tipoDeConta;
        while (true) {
            System.out.println("""
                    Tipos de conta:
                    1) Corrente
                    2) Poupanca
                    """);
            int tipoConta = VerificarInteiro("Digite o número correspondente " +
                    "ao tipo da sua conta: ", 1, 2);
            if (tipoConta == 1) {
                tipoDeConta = "Corrente";
            } else {
                tipoDeConta = "Poupanca";
            }

            break;

        }

        double saldo = 0;
        String saldoFormatado = String.format("R$%.2f", saldo);
        String menu = """
                \nOperacoes:
                1) Consultar saldos
                2) Receber Valor
                3) Transferir Valor
                4) Sair
                """;
        System.out.println("=".repeat(40));

        System.out.print(String.format("""
                Dados iniciais do cliente:
                Nome:                       %s
                Tipo de conta:              %s
                Saldo inicial:              %s
                """, nome, tipoDeConta, saldoFormatado));
        System.out.println("=".repeat(40));
        int opcao = -1;

        while(opcao != 4) {
            System.out.println(menu);
            opcao = VerificarInteiro("Digite a opcao desejada: ", 1, 4);
            if (opcao == 1) {
                System.out.printf("Saldo atual: %.2f", saldo);
            } else if (opcao == 2) {
                double valorRecebido;
                valorRecebido = VerificarDouble("Digite o valor a ser recebido: ");
                valorRecebido = VerificarDoublePositivo(valorRecebido,"Digite o valor a ser recebido: " );

                saldo += valorRecebido;
                System.out.printf("Saldo atualizado %.2f", saldo);

            } else if (opcao == 3) {
                double valorTransferido = VerificarDouble("Informe o valor que deseja tranferir: ");
                valorTransferido = VerificarDoublePositivo(valorTransferido, "Informe o valor que deseja tranferir: ");

                if (valorTransferido > saldo) {
                    System.out.println("Saldo insuficiente para realizar essa transferencia");
                } else if (valorTransferido < (double)0.0F) {
                    System.out.println("Valor invalido");
                } else {
                    saldo -= valorTransferido;
                    System.out.printf("Saldo atualizado %.2f", saldo);
                }
            } else {
                System.out.println("Saindo...");
                break;

            }
        }

    }
}
