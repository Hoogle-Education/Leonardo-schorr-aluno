package entities;

public class JogoDaVelha {
  
  private String[][] tabuleiro;
  private int dimensao;
  private String resultado;

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

    // retorno true ou reseto o find
    if(find == true) {
      resultado = first;
      return true;
    } else find = true;

    // diagonal secundária
    first = tabuleiro[0][dimensao-1];
    for(int i=1; i<dimensao; i++){
      if(first == null || tabuleiro[i][dimensao-i-1] == null){
        find = false;
      }else if( !tabuleiro[i][dimensao-i-1].equals(first) ){
        find = false;
      } 
    }
    
    // retorno true ou reseto o find
    if(find == true) {
      resultado = first;
      return true;
    } else find = true;

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

      // retorno true ou reseto o find
      if(find == true) {
        resultado = first;
        return true;
      } else find = true;
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

      // retorno true ou reseto o find
      if(find == true) {
        resultado = first;
        return true;
      } else find = true;
    }

    // caso de empate
    for(int i=0; i<dimensao; i++){
      for(int j=0; j<dimensao; j++){
        if(tabuleiro[i][j] == null) find = false;
      }
    }

    // retorno true ou retorno false se não conseguir
    if(find == true){
      resultado = "empate";
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

  public int getDimensao() {
    return dimensao;
  }

  public String getResultado() {
    return resultado;
  }

  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

}
