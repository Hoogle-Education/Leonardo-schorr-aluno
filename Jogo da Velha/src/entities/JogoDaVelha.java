package entities;

public class JogoDaVelha {
  
  private String[][] tabuleiro;
  private int dimensao;

  public JogoDaVelha(int dimensao){
    this.dimensao = dimensao;
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

  @Override
  public String toString(){
    String aux = "";

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
