package brufjfdcc025.jogovelha;

import java.util.Random;
import java.util.ArrayList;

public class Bot {

    protected String nome, peca;

    public Bot() {
        this.setNome("Computador");
    }

    public int FazerJogada() {
        Random gerador = new Random();

        int num = gerador.nextInt(9);

        if (num == 0 || num == 3 || num == 6) {
            return 1;
        }
        if (num == 1 || num == 4 || num == 7) {
            return 2;
        }
        return 3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

}
