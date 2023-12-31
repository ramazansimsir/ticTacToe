package com.rmzn.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLOgic {

    private int[][] gameBoard;
    private Button playAgainBTN;
    private Button homeBtn;
    private TextView playerTurn;
    private String[] playernames={"Player 1","Player 2"};
    private int player=1;

    // 1st -> row 2st-> col 3-st-> linetype
    private int[]winType={-1,-1,-1};

    GameLOgic(){
     gameBoard=new int[3][3];
        for (int r=0;r<3;r++){

            for(int c=0;c<3;c++){
                gameBoard[r][c]=0;

            }
        }

    }
    public boolean updateGameBoard(int row,int col){

        if (gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1]=player;

            if(player==1){
                playerTurn.setText(playernames[1]+"'s turn");
            }
            else {
                playerTurn.setText(playernames[0]+"'s turn ");
            }
            return  true;
        }
        else {
            return false;
        }
    }

    public void resetGame(){
        for (int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                gameBoard[r][c]=0;
            }
        }
        player=1;
        winType[0] = -1;
        winType[1] = -1;
        winType[2] = -1;
        playAgainBTN.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);
        playerTurn.setText(playernames[0]+"'s Turn");
    }

    public boolean winnerCheck(){
        boolean isWinner=false;
        // horizontal check
        for(int r=0;r<3;r++){
            if (gameBoard[r][0]==gameBoard[r][1] && gameBoard[r][0]==gameBoard[r][2] && gameBoard[r][0]!=0) {isWinner=true;
            winType=new int[]{r,0,1};
            isWinner=true;
            break;
            }
        }
        for(int c=0;c<3;c++){
            if (gameBoard[0][c]==gameBoard[1][c] && gameBoard[1][c]==gameBoard[2][c] && gameBoard[0][c]!=0) {
                isWinner=true;
                winType=new int[]{0,c,2};
                break;
            }

        }
        if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[0][0]==gameBoard[2][2] && gameBoard[0][0]!=0) {
            isWinner=true;
            winType=new int[]{0,2,3};

        }

        if(gameBoard[2][0]==gameBoard[1][1] && gameBoard[2][0]==gameBoard[0][2] && gameBoard[2][0]!=0) {
            isWinner=true;
            winType=new int[]{2,2,4};

        }

        int boardfilled=0;
            for (int r=0;r<3;r++){
                for (int c=0;c<3;c++){
                    if(gameBoard[r][c]!=0){
                        boardfilled+=1;
                    }
                }
            }
        if(isWinner){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurn.setText(playernames[player-1]+" WON !!");
            return true;
        }
        else if (boardfilled==9){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerTurn.setText(" TİE GAME !!!");
            return true;
        }
        else{
            return false;
        }
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setHomeBtn(Button homeBtn) {
        this.homeBtn = homeBtn;
    }

    public void setPlayernames(String[] playernames) {
        this.playernames = playernames;
    }

    public int[] getWinType() {
        return winType;
    }
}
