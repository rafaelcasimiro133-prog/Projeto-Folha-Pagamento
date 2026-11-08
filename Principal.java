import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Colaborador padrão");
            System.out.println("2 - Colaborador comissionado");
            System.out.println("3 - Colaborador da produção");
            System.out.println("4 - Listar colaboradores");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao >= 1 && opcao <= 3) {

                System.out.print("Matrícula: ");
                int matricula = entrada.nextInt();
                entrada.nextLine();

                System.out.print("Nome completo: ");
                String nome = entrada.nextLine();

                if (nome.trim().isEmpty() || matricula <= 0) {
                    System.out.println("Dados inválidos!");
                    continue;
                }

                if (opcao == 1) {

                    colaboradores.add(
                        new ColaboradorPadrao(matricula, nome)
                    );

                } else if (opcao == 2) {

                    System.out.print("Valor das vendas: ");
                    double vendas = entrada.nextDouble();

                    System.out.print("Percentual de comissão: ");
                    double percentual = entrada.nextDouble();

                    if (vendas < 0 || percentual < 0) {
                        System.out.println("Valores inválidos!");
                    } else {
                        colaboradores.add(
                            new ColaboradorComissionado(
                                matricula, nome, vendas, percentual
                            )
                        );
                    }

                } else {

                    System.out.print("Quantidade de peças: ");
                    int pecas = entrada.nextInt();

                    System.out.print("Valor por peça: ");
                    double valor = entrada.nextDouble();

                    if (pecas < 0 || valor < 0) {
                        System.out.println("Valores inválidos!");
                    } else {
                        colaboradores.add(
                            new ColaboradorProducao(
                                matricula, nome, pecas, valor
                            )
                        );
                    }
                }

                System.out.println("Cadastro processado!");

            } else if (opcao == 4) {

                if (colaboradores.isEmpty()) {
                    System.out.println("Nenhum colaborador cadastrado.");
                } else {
                    for (Colaborador c : colaboradores) {
                        System.out.println("\n-------------------");
                        c.exibirDados();
                    }
                }

            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        entrada.close();
    }
}