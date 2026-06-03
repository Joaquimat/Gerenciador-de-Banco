package banco;

import banco.model.Conta;
import banco.service.ContaService;

import java.util.Scanner;


public class AppBanco {
    public static void main(String[] args) {
        Conta conta = new Conta();
        ContaService contaService = new ContaService();
        Scanner sc = new Scanner(System.in);
        int resp;

        do {
            System.out.println("||GERENCIADOR DE BANCO DIGITAL||");
            System.out.println("1 - CRIAR CONTA");
            System.out.println("2 - LISTAR CONTAS");
            System.out.println("3 - LISTAR CONTA PELO NÚMERO");
            System.out.println("4 - ATUALIZAR EMAIL");
            System.out.println("5 - DELETAR CONTA");
            System.out.println("6 - REALIZAR DEPÓSITO");
            System.out.println("7 - REALIZAR SAQUE");
            System.out.println("0 - SAIR");

            resp = sc.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("DIGITE O NÚMERO DA SUA CONTA");
                    int nc = sc.nextInt();
                    sc.nextLine();
                    System.out.println("DIGITE SEU NOME COMPLETO");
                    String nm = sc.nextLine();
                    System.out.println("DIGITE SEU CPF (APENAS NÚMEROS)");
                    String cpf = sc.nextLine();
                    System.out.println("DIGITE SEU EMAIL");
                    String em = sc.nextLine();

                    conta.setNumero(nc);
                    conta.setCliente(nm);
                    conta.setCpf(cpf);
                    conta.setEmail(em);

                    contaService.salvarService(conta);

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("CONTAS EXISTENTES");
                    System.out.println(contaService.listarService());

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    sc.nextLine();
                    break;


                case 3:
                    System.out.println("DIGITE O NÚMERO DA CONTA QUE VOCÊ QUER CONSULTAR");
                    int nu = sc.nextInt();

                    conta.setNumero(nu);
                    System.out.println(contaService.buscarPNumeroService(conta));

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 4:

                    System.out.println("DIGITE O NÚMERO DA CONTA QUE VOCÊ QUER MUDAR O EMAIL");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("DIGITE O NOVO EMAIL");
                    String m = sc.nextLine();

                    conta.setNumero(n);
                    conta.setEmail(m);

                    contaService.atualizarService(conta);

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("DIGITE O NÚMERO DA CONTA QUE VOCÊ QUER DELETAR");
                    int num = sc.nextInt();
                    sc.nextLine();

                    conta.setNumero(num);
                    contaService.deletarService(conta);

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    break;

                case 6:
                    System.out.println("DIGITE O NÚMERO DA CONTA QUE VOCÊ QUER DEPOSITAR");
                    int numb = sc.nextInt();
                    sc.nextLine();

                    System.out.println("DIGITE O VALOR QUE VOCÊ QUER DEPOSITAR");
                    Long d = sc.nextLong();

                    conta.setNumero(numb);
                    conta.setSaldo(d);

                    contaService.depositarService(conta);

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 7:
                    System.out.println("DIGITE O NÚMERO DA CONTA QUE VOCÊ QUER SACAR");
                    int numbe = sc.nextInt();
                    sc.nextLine();

                    System.out.println("DIGITE O VALOR QUE VOCÊ QUER SACAR");
                    Long s = sc.nextLong();

                    conta.setNumero(numbe);
                    conta.setSaldo(s);

                    contaService.sacarService(conta);

                    System.out.println("APERTE ENTER PARA VOLTAR AO MENU");
                    sc.nextLine();
                    sc.nextLine();
                    break;

            }

        } while (resp != 0);


    }


}
