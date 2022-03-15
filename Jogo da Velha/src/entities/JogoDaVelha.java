package entities;

public class JogoDaVelha {
  
  private String[][] tabuleiro;
  private int dimensao;
  public Jogador jogador1, jogador2;

  public JogoDaVelha(int dimensao, Jogador jogador1, Jogador jogador2){
    this.dimensao = dimensao;
    this.jogador1 = jogador1;
    this.jogador2 = jogador2;
    tabuleiro = new String[dimensao][dimensao];
  }

  public boolean realizaJogada(int linha, int coluna, String jogada){
   
    linha--;
    coluna--; // indexando em zero

    if(tabuleiro[linha][coluna] == null){
      tabuleiro[linha][coluna] = jogada;
      return true;
    }else return false;
    
  }

  public boolean verificaGanhador(){

    boolean find = true;

    // diagonal principal
    String first = tabuleiro[0][0];
    for(int i=1; i<dimensao; i++){
      if(first == null || tabuleiro[i][i] == null){
        find = false;
      } else if( !tabuleiro[i][i].equals(first) ) {
        find = false;
      }
    }

    if(mostraVencedor(find, first)) return true;
    else find = true;

    // diagonal secundária
    first = tabuleiro[0][dimensao-1];
    for(int i=1; i<dimensao; i++){
      if(first == null || tabuleiro[i][dimensao-i-1] == null){
        find = false;
      }else if( !tabuleiro[i][dimensao-i-1].equals(first) ){
        find = false;
      } 
    }

    if(mostraVencedor(find, first)) return true;
    else find = true;

    // analisando as linhas
    for(int i=0; i<dimensao; i++){
      first = tabuleiro[i][0];
      for(int j=1; j<dimensao; j++){
        if(first == null || tabuleiro[i][j] == null){
          find = false;
        } else if( !tabuleiro[i][j].equals(first) ) {
          find = false;
        }
      }

      if(mostraVencedor(find, first)) return true;
      else find = true;
    }

    // analisando as colunas
    for(int i=0; i<dimensao; i++){
      first = tabuleiro[0][i];
      for(int j=1; j<dimensao; j++){
        if(first == null || tabuleiro[j][i] == null){
          find = false;
        } else if( !tabuleiro[j][i].equals(first) ) {
          find = false;
        }
      }

      if(mostraVencedor(find, first)) return true;
      else find = true;
    }

    return false;
  }

  public boolean mostraVencedor(boolean find, String first){
    if( find == true ) {
      
      if( first.equals("X") ) {
        jogador1.setPontos( jogador1.getPontos()+1 );
        System.out.println("O jogador 1 venceu!\n" 
                            + jogador1 );
      } else {
        jogador2.setPontos( jogador2.getPontos()+1 );
        System.out.println("O jogador 2 venceu!\n" 
                            + jogador2 );
      }

      return true;
    } else return false;
  } 

  @Override
  public String toString(){
    String aux = "\n";

    for(int i=0; i<dimensao; i++){
      for(int j=0; j<dimensao; j++){
        // adiciono as jogadas contidas no tabuleiro
        if(tabuleiro[i][j] == null) aux += " ";
        else aux += tabuleiro[i][j]; 

        if(j != dimensao-1) aux += " | ";
      }

      // pulo linha entre as jogadas no tabuleiro
      aux += "\n";
    }

    return aux;
  }

}


// 00 01 02 03
// 10 11 12 13
// 31 32 33 34
// 41 42 43 44


/*
matriz = [
          [1, 2, 3, 4],
          [...]

          ]

*/