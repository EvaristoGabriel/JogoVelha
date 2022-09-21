package brufjfdcc025.jogovelha;

import java.util.Scanner;
import java.util.Random;
/*
    Gabriel Evaristo Carlos
    201965034AB
*/
public class JogoVelha {
    public static void main(String[] args){
        int rodada,opc,linha,coluna,ganhar;
        Scanner teclado;

        String[][] tabuleiro = new String[3][3];
        System.out.println("------- BEM VINDO -------");
        teclado = new Scanner(System.in);
        
       
        for(int i=0; i<3; i++)
            for(int j=0;j<3;j++)
                tabuleiro[i][j] = " ";
        int continuar =1;
        while (continuar != 2){
            ZerarTabuleiro(tabuleiro);
            ganhar = 0;
            System.out.println("Quem vai jogar?");
            System.out.println("1-Player x Player");
            System.out.println("2-Player x Bot");
            System.out.println("Sua opção: ");
            opc = teclado.nextInt();
            rodada=1;
            switch(opc){
                case 1: System.out.println("Player x Player escolhido");
                        String jogador1,jogador2,peca1,peca2;
                        System.out.println("Player 1 qual o seu nome: ");
                        jogador1= teclado.next();
                        System.out.println("Qual peca vc escolhe: ");
                        peca1 = teclado.next();
                        System.out.println("Player 2 qual o seu nome: ");
                        jogador2 = teclado.next();
                        System.out.println("Qual peca vc escolhe: ");
                        peca2 = teclado.next();
                        if(peca1.equals(peca2)){
                            while(peca1.equals(peca2)){
                                System.out.println("ATENÇÃO!!!\nEscolha uma peça diferente do oponente: ");
                                peca2 = teclado.next();
                            }
                        }

                        System.out.println("Jogador 1: "+jogador1+"\nPeca: "+peca1);
                        System.out.println("Jogador 2:\n"+jogador2+"\nPeca: "+peca2);
                        System.out.println("----- TABULEIRO -----");
                        ImprimirTabuleiro(tabuleiro);
                        while(!isCheio(tabuleiro) && ganhar!=1 && ganhar !=2){
                            if(rodada % 2 != 0){
                                System.out.println("Vez de "+jogador1);
                                System.out.println("Escolha uma Linha(1-3): ");
                                linha = teclado.nextInt();
                                System.out.println("Escolha uma Coluna(1-3): ");
                                coluna = teclado.nextInt();
                                if((linha <1 || linha>3)||(coluna<1 || coluna >3)){
                                    System.out.println("Valores inválidos, digite novamente:");
                                    linha = teclado.nextInt();
                                    coluna = teclado.nextInt();
                                }
                                AdicionarJogada(tabuleiro,linha, coluna,peca1);
                            }
                            else{
                                System.out.println("Vez de "+jogador2);
                                System.out.println("Escolha uma Linha(1-3): ");
                                linha = teclado.nextInt();
                                System.out.println("Escolha uma Coluna(1-3): ");
                                coluna = teclado.nextInt();
                                if((linha <1 || linha>3)||(coluna<1 || coluna >3)){
                                    while((linha <1 || linha>3)||(coluna<1 || coluna >3)){
                                        System.out.println("Valores inválidos, digite novamente:");
                                        System.out.println("Escolha uma Linha(1-3): ");
                                        linha = teclado.nextInt();
                                        System.out.println("Escolha uma Coluna(1-3): ");
                                        coluna = teclado.nextInt();
                                    }
                                }
                                AdicionarJogada(tabuleiro,linha, coluna,peca2);
                            }
                            rodada++;
                            ganhar=Verifica(tabuleiro,peca1,peca2);
                            if(ganhar == 1){
                                System.out.println("Parabéns "+jogador1);
                                System.out.println("Você ganhou!!!!");
                            }
                            if(ganhar == 2){
                                System.out.println("Parabéns "+jogador2);
                                System.out.println("Você ganhou!!!!");
                            }
                            if(ganhar == 0)
                                if(isCheio(tabuleiro)){
                                    System.out.println("Vixe... Ninguém ganhou");
                                    System.out.println("Famoso 'Deu velha'");
                                }
                        }

                        break;
                case 2: System.out.println("Player x Bot escolhido");
                        String jogador,peca;
                        Bot computador = new Bot();
                        Random gerador = new Random();
                        System.out.println("Player qual o seu nome: ");
                        jogador= teclado.next();
                        System.out.println("Qual peca vc escolhe: ");
                        peca = teclado.next();
                        if(peca.equals("x")|| peca.equals("X"))
                            computador.setPeca("O");
                        else
                            computador.setPeca("X");

                        System.out.println("Jogador 1: "+jogador+"\nPeca: "+peca);
                        System.out.println("Jogador 2:\n"+computador.getNome()+"\nPeca: "+computador.getPeca());
                        System.out.println("----- TABULEIRO -----");
                        ImprimirTabuleiro(tabuleiro);
                        while(!isCheio(tabuleiro) && ganhar!=1 && ganhar !=2){
                            if(rodada % 2 != 0){
                                System.out.println("Vez de "+jogador);
                                System.out.println("Escolha uma Linha(1-3): ");
                                linha = teclado.nextInt();
                                System.out.println("Escolha uma Coluna(1-3): ");
                                coluna = teclado.nextInt();
                                if((linha <1 || linha>3)||(coluna<1 || coluna >3)){
                                    while((linha <1 || linha>3)||(coluna<1 || coluna >3)){
                                        System.out.println("Valores inválidos, digite novamente:");
                                        System.out.println("Escolha uma Linha(1-3): ");
                                        linha = teclado.nextInt();
                                        System.out.println("Escolha uma Coluna(1-3): ");
                                        coluna = teclado.nextInt();
                                    }
                                }
                                AdicionarJogada(tabuleiro,linha, coluna,peca);
                            }
                            else{
                                System.out.println("Vez de "+computador.getNome());
                                linha = computador.FazerJogada();
                                coluna = computador.FazerJogada();
                                if(tabuleiro[linha-1][coluna-1] != " "){
                                    while(tabuleiro[linha-1][coluna-1] != " "){
                                        linha = computador.FazerJogada();
                                        coluna = computador.FazerJogada();
                                    }
                                }   
                                AdicionarJogada(tabuleiro,linha, coluna,computador.getPeca());
                            }   
                            rodada++;
                            ganhar=Verifica(tabuleiro,peca,computador.getPeca());
                            if(ganhar == 1){
                                System.out.println("Parabéns "+jogador);
                                System.out.println("Você ganhou!!!!");
                            }

                            if(ganhar == 2){
                                System.out.println("Vixe "+jogador+" você perdeu....");
                                System.out.println(computador.getNome()+" ganhou");
                            }
                            if(ganhar == 0)
                                if(isCheio(tabuleiro)){
                                    System.out.println("Vixe... Ninguém ganhou");
                                    System.out.println("Famoso 'Deu velha'");
                                }
                        }

                        break;
                default: System.out.println("Opção inválida!!");
                        break;
            }
            System.out.println("Quer tentar novamente? ");
            System.out.println("1-Sim");
            System.out.println("2-Não");
            System.out.println("Sua opção: ");
            continuar = teclado.nextInt();
        }
    }
    
    public static boolean isCheio(String[][] tabuleiro) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tabuleiro[i][j].equals(" "))
                    return false;
            }
        }
        return true;
    }
    
    public static void ZerarTabuleiro(String[][] tabuleiro){
        for(int i=0; i<3; i++)
            for(int j=0;j<3;j++)
                tabuleiro[i][j] = " ";
    }
    
    public static void ImprimirTabuleiro(String[][] tabuleiro){
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                if(j == 1 || j == 2){
                    System.out.print(" | ");
                }
                System.out.print(tabuleiro[i][j]);
            }
            
            if(i == 0 || i == 1){
                System.out.println("");
                System.out.println("--|---|---");
            }
        }
        System.out.println("");
    }
    
    public static int Verifica(String[][] tabuleiro,String p1,String p2){
        
        for(int i=0;i<3;i++){
            if(tabuleiro[i][0]== p1 && tabuleiro[i][1]== p1 && tabuleiro[i][2]==p1)
                return 1;
            if(tabuleiro[i][0]== p2 && tabuleiro[i][1]== p2 && tabuleiro[i][2]==p2)
                return 2;
        }
        for(int i=0;i<3;i++){
            if(tabuleiro[0][i]== p1 && tabuleiro[1][i]== p1 && tabuleiro[2][i]==p1)
                return 1;
            if(tabuleiro[0][i]== p2 && tabuleiro[1][i]== p2 && tabuleiro[2][i]==p2)
                return 2;
        }
        
        if(tabuleiro[0][0]== p1 && tabuleiro[1][1]== p1 && tabuleiro[2][2]==p1)
                return 1;
        if(tabuleiro[0][0]== p2 && tabuleiro[1][1]== p2 && tabuleiro[2][2]==p2)
                return 2;
        if(tabuleiro[0][2]== p1 && tabuleiro[1][1]== p1 && tabuleiro[2][0]==p1)
                return 1;
        if(tabuleiro[0][2]== p2 && tabuleiro[1][1]== p2 && tabuleiro[2][0]==p2)
                return 2;

        return 0;
    }
    
    public static void AdicionarJogada(String[][] tabuleiro,int linha, int coluna, String peca){
        Scanner teclado = new Scanner(System.in);
        if(tabuleiro[linha-1][coluna-1] == " "){
            tabuleiro[linha-1][coluna-1] = peca;
        }
        else{
            while(tabuleiro[linha-1][coluna-1] != " "){
                ImprimirTabuleiro(tabuleiro);
                System.out.println("Jogada Inválida!! Tente outra posição: ");
                System.out.println("Linha: ");
                linha = teclado.nextInt();
                System.out.println("Coluna: ");
                coluna = teclado.nextInt();
            }
            System.out.println("linha: "+(linha-1)+"\nColuna: "+(coluna-1));
            tabuleiro[linha-1][coluna-1] = peca;
        }
        
        ImprimirTabuleiro(tabuleiro);
    }
    
    
}
