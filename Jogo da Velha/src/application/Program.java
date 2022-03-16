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

      JogoDaVelha jogo = new JogoDaVelha( dimensao );

      while(!jogo.verificaGanhador()){

        int l, c;
        boolean first = true;

        // entrada a jogada do primeiro jogador
        do {
          if(!first) System.out.println("#### Jogáda Inválida! ####");
          else first = false;
          System.out.println("----- Jogador 1 -----");
          System.out.print("Digite a linha da sua jogada: ");
          l = input.nextInt();
          System.out.print("Digite a coluna da sua jogada: ");
          c = input.nextInt();
        } while( !jogo.realizaJogada(l, c, "X") );

        // testando se o jogador 1 já venceu
        if(jogo.verificaGanhador()) continue;

        // reseto first
        first = true;

        // entrando a jogada do segundo jogador
        do {
          if(!first) System.out.println("#### Jogáda Inválida! ####");
          else first = false;
          System.out.println("----- Jogador 2 -----");
          System.out.print("Digite a linha da sua jogada: ");
          l = input.nextInt();
          System.out.print("Digite a coluna da sua jogada: ");
          c = input.nextInt();
        }while( !jogo.realizaJogada(l, c, "O") );

        // testando se o jogador 2 já venceu ou deu empate
        if(jogo.verificaGanhador()) continue;
        

        System.out.println(jogo);
      }

      if(jogo.getResultado() == "X") {
        jogador1.setPontos( jogador1.getPontos() + 1 );
        System.out.println("O jogador 1 venceu!");
        System.out.println(jogador1);
      }else if(jogo.getResultado() == "O"){
        jogador2.setPontos( jogador2.getPontos() + 1 );
        System.out.println("O jogador 2 venceu!");
        System.out.println(jogador2);
      }else{
        System.out.println("Empatou!");
        System.out.println(jogador1);        
        System.out.println(jogador2);
      }
      
      while( true ){
        System.out.print("Deseja jogar novamente? (S/N) ");
        
        input.nextLine();
        String option = input.nextLine();

        if(option.equals("N")) jogarDeNovo = false;
        else if(option.equals("S")) jogarDeNovo = true;
        else System.out.println("Digite uma opção válida!");
        
        if( option.equals("N") || option.equals("S") ) break;
      }
    }

    System.out.println(jogador1);
    System.out.println(jogador2);

    input.close();
  }
}
