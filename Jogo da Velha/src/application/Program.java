package application;

import entities.Jogador;
import entities.JogoDaVelha;

public class Program {
  public static void main(String[] args) {

    JogoDaVelha jv = new JogoDaVelha(3);

    System.out.println( jv.realizaJogada(1, 1, "O") );
    System.out.println( jv.realizaJogada(1, 1, "X") );

    System.out.println( jv );

  }
}
