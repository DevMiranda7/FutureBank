package com.futurebank.ui;

import com.futurebank.account.Account;
import com.futurebank.client.AccountHolder;
import com.futurebank.bank.Bank;

import java.util.Scanner;

public class UserInterface {
    public static void Menu() {
        Scanner scanf = new Scanner(System.in);
        Bank admBancario = new Bank();
        boolean rodando = true;
            while (rodando) {
                System.out.println("************************************");
                System.out.println("Welcome to Future-com.com.futurebank.bank.Bank");
                System.out.println("Escolha uma opção");
                System.out.println("(1) Abrir uma conta");
                System.out.println("(2) Informações da conta");
                System.out.println("(3) Atualizar conta");
                System.out.println("(4) Encerrar conta");
                System.out.println("(5) Sair");
                System.out.println("************************************");
                String opcoes = scanf.next();
                switch (opcoes){
                    case "1":
                        System.out.println("Abrir conta");
                        System.out.println(" ");
                        System.out.println("Insira seu nome:");
                        String nome = scanf.next();
                        System.out.println("Insira seu CPF:");
                        String cpf = scanf.next();
                        System.out.println("Insira sua profissão atual: (N/A)");
                        String profissao = scanf.next();
                        AccountHolder accountHolder = new AccountHolder(nome,cpf,profissao);
                        admBancario.createAccount(accountHolder);
                        break;
                    case "2":
                        System.out.println("Informações da conta:");
                        System.out.println("Insira o número da sua da conta:");
                        int numero = scanf.nextInt();
                        Account account = admBancario.accountInformation(numero);
                        if(account != null) {
                            boolean keep = true;
                            while (keep) {
                                System.out.println("Conferir seu saldo (1)");
                                System.out.println("Realizar um deposíto (2)");
                                System.out.println("Realizar um saque (3)");
                                System.out.println("Conferir seu número de conta (4)");
                                System.out.println("Conferir sua agência bancária (5)");
                                System.out.println("Conferir suas informações pessoais (6)");
                                System.out.println("Sair para o menu principal (7)");
                                opcoes = scanf.next();
                                switch (opcoes){
                                    case "1":
                                        System.out.println("Seu saldo atual R$: "+ account.Extrato());
                                        break;
                                    case "2":
                                        System.out.println("Digite o valor para depósito R$:");
                                        double deposito = scanf.nextDouble();
                                        account.Depositar(deposito);
                                        System.out.println("Valor dositado R$: "+deposito);
                                        break;
                                    case "3":
                                        System.out.println("Digite o valor para sacar R$:");
                                        double saque = scanf.nextDouble();
                                        account.Sacar(saque);
                                        System.out.println("Valor sacado R$: "+saque);
                                        break;
                                    case "4":
                                        System.out.println("Seu número de conta: "+ account.getNumero());
                                        break;
                                    case "5":
                                        System.out.println("Sua agência bancária: "+ account.getAgencia());
                                        break;
                                    case "6":
                                        System.out.println("Suas informações pessoais:");
                                        System.out.println("Seu nome: "+ account.getTitular().getNome());
                                        System.out.println("Seu CPF: "+ account.getTitular().getCpf());
                                        System.out.println("Sua profissão: "+ account.getTitular().getProfissao());
                                        break;
                                    case "7":
                                        System.out.println("Voltando para o menu...");
                                        keep = false;
                                        break;
                                    default:
                                        System.out.println("Opção inválida, tente novamente!");
                                        break;
                                }
                            }
                        }
                        else{
                            System.out.println("Erro ao buscar pela número da conta informado!");
                        }
                        break;
                    case "3":
                        System.out.println("Atualizando conta:");
                        System.out.println("Insira o número da sua da conta:");
                        numero = scanf.nextInt();
                        account = admBancario.accountInformation(numero);
                        if (account != null) {
                          AccountHolder accountHolderDados = account.getTitular();
                          boolean repetidor = true;
                            while (repetidor){
                                System.out.println("Qual informação você deseja alterar?");
                                System.out.println("Nome (1)");
                                System.out.println("CPF (2)");
                                System.out.println("Profissão (3)");
                                System.out.println("Todas as informações (4)");
                                System.out.println("Cancelar (5)");
                                String alternativa = scanf.next();
                                switch (alternativa){
                                    case "1":
                                        System.out.println("Alterando nome:");
                                        nome = scanf.next();
                                        accountHolderDados.setNome(nome);
                                        break;
                                    case "2":
                                        System.out.println("Alterando CPF:");
                                        cpf = scanf.next();
                                        accountHolderDados.setCpf(cpf);
                                        break;
                                    case "3":
                                        System.out.println("Alterando profissão:");
                                        profissao = scanf.next();
                                        accountHolderDados.setProfissao(profissao);
                                        break;
                                    case "4":
                                        System.out.println("Alterando todas as informações:");
                                        System.out.println("Digite o novo nome:");
                                        nome = scanf.next();
                                        accountHolderDados.setNome(nome);
                                        System.out.println("Digite o novo CPF:");
                                        cpf = scanf.next();
                                        accountHolderDados.setCpf(cpf);
                                        System.out.println("Digite a nova profissão:");
                                        profissao = scanf.next();
                                        accountHolderDados.setProfissao(profissao);
                                        break;
                                    case "5":
                                        System.out.println("Retornando...");
                                        repetidor = false;
                                        break;
                                    default:
                                        System.out.println("Alternativa inválida, tente novamente!");
                                        break;
                                }
                                if(!alternativa.equals("5")){
                                    admBancario.updateAccount(numero, accountHolderDados);
                                }
                            }
                        }
                        else {
                            System.out.println("Não foi possível atualizar a conta!");
                        }
                        break;
                    case "4":
                        System.out.println("Remover conta:");
                        System.out.println("Insira o número da sua conta:");
                        numero = scanf.nextInt();
                         account = admBancario.accountInformation(numero);
                         if(account != null){
                             System.out.println("Removendo...");
                                admBancario.deleteAccount(numero);
                         }
                         else {
                             System.out.println("Erro ao remover!");
                         }
                         break;
                    case "5":
                        System.out.println("Saindo...");
                        rodando = false;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        break;
                }
            }
        }
}