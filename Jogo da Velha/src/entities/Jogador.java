package entities;

public class Jogador {

  // Jogador j1 = new Jogador("Pedro da Silva");
  // Jogador j2 = new Jogador("Matheus Marins");  
  
  private String nome;
  private int pontos;

  public Jogador(String nome){
    this.nome = nome; 
    pontos = 0;
  }

  public String getNome(){
    return nome;
  }

  public int getPontos() {
    return pontos;
  }

  public void setPontos(int pontos) {
    this.pontos = pontos;
  }

  @Override // a toString já existe para uma classe superior
  public String toString() {
    return "-----------\n"
          + "Nome: " 
          + nome 
          + "\nPontos:" 
          + pontos 
          + "\n-----------";
  }

}
