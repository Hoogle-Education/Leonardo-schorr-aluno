package application;

import java.util.Scanner;

import entities.Jogador;
import entities.JogoDaVelha;

public class Program {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("--------- JOGO DA VELHA ---------");

    System.out.print("Digite o nome do primeiro jogador: ");
    Jogador jogador1 = new Jogador(input.nextLine());

    System.out.print("Digite o nome do segundo jogador: ");
    Jogador jogador2 = new Jogador(input.nextLine());

    System.out.println("Jogadores Cadastrados!");

    boolean jogarDeNovo = true;
    int dimensao;

    System.out.print("Digite a dimensão do tabuleiro: ");
    dimensao = input.nextInt();

    while(jogarDeNovo){

      JogoDaVelha jogo = new JogoDaVelha(dimensao, jogador1, jogador2);

      while(!jogo.verificaGanhador()){

        int l, c;

        // fazendo a jogada do jogador 1
        System.out.println("Jogador 1:");
        System.out.print("Digite a linha da sua jogada: ");
        l = input.nextInt();
        System.out.print("Digite a coluna da sua jogada: ");
        c = input.nextInt();

        // enquanto a jogada nao for possível, continue tentando outras
        while( ! jogo.realizaJogada(l, c, "X") ){
          System.out.println("Jogada inválida!");
          System.out.print("Digite a linha da sua jogada: ");
          l = input.nextInt();
          System.out.print("Digite a coluna da sua jogada: ");
          c = input.nextInt();
        }

        // testando se o jogador 1 já venceu
        if(jogo.verificaGanhador()){
          jogador1.setPontos( jogo.jogador1.getPontos() );
          jogador2.setPontos( jogo.jogador2.getPontos() );

          while( true ){
            System.out.print("Deseja jogar novamente? (S/N) ");
            
            input.nextLine();
            String option = input.nextLine();
    
            if(option.equals("N")){
              jogarDeNovo = false;
              break;
            }else if(option.equals("S")){
              jogarDeNovo = true;
              break;
            }else{
              System.out.println("Digite uma opção válida!");
            }
          }

          continue;
        }

        // Fazendo a jogada do jogador 2
        System.out.println("Jogador 2: ");
        System.out.print("Digite a linha da sua jogada: ");
        l = input.nextInt();
        System.out.print("Digite a coluna da sua jogada: ");
        c = input.nextInt();

        // enquanto a jogada nao for possível, continue tentando outras
        while( ! jogo.realizaJogada(l, c, "O") ){
          System.out.println("Jogada inválida!");
          System.out.print("Digite a linha da sua jogada: ");
          l = input.nextInt();
          System.out.print("Digite a coluna da sua jogada: ");
          c = input.nextInt();
        }

        System.out.println(jogo);
      }
      
      while( true ){
        System.out.print("Deseja jogar novamente? (S/N) ");
        
        input.nextLine();
        String option = input.nextLine();

        if(option.equals("N")){
          jogarDeNovo = false;
          break;
        }else if(option.equals("S")){
          jogarDeNovo = true;
          break;
        }else{
          System.out.println("Digite uma opção válida!");
        }
      }
    }

    System.out.println(jogador1);
    System.out.println(jogador2);

    input.close();
  }
}
