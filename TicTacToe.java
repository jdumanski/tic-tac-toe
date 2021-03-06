package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TicTacToe extends Application {
	static boolean turn = true; // true means its X's turn, false means its O's turn
	static boolean gameOver = false; 
	static int turns = 0;
	@Override
	public void start(Stage primaryStage) {
		
			Pane root = new Pane();
			Scene scene = new Scene(root,600,600);
			root.setStyle("-fx-background-color: Black");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Text title = new Text();
			title.setText("Tuq-Tac-Toe");
			root.getChildren().add(title);
			title.setTranslateX(122); 
			title.setTranslateY(60);
			title.setFont(Font.font ("Verdana",FontWeight.BOLD, 50));
			title.setFill(javafx.scene.paint.Color.DARKRED);
			
			Text winner = new Text();
			root.getChildren().add(winner);
			winner.setTranslateX(80); 
			winner.setTranslateY(550);
			winner.setFont(Font.font ("Verdana",FontWeight.BOLD, 50));
			winner.setFill(javafx.scene.paint.Color.DARKRED);
			
			Text[][] letters = new Text[3][3];
			String[][] text = new String[3][3];
			
			Button[][] board = new Button[3][3];
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					board[i][j] = new Button();
					root.getChildren().add(board[i][j]);
					board[i][j].setPrefHeight(100);
					board[i][j].setPrefWidth(100);
					board[i][j].setTranslateX(120*j+130);
					board[i][j].setTranslateY(120+120*i);
					board[i][j].setStyle("-fx-background-color: DarkRed");
					
					letters[i][j] = new Text();
					root.getChildren().add(letters[i][j]);
					
					letters[i][j].setTranslateX(120*j+149); 
					letters[i][j].setTranslateY(120*i+198);
					letters[i][j].setFont(Font.font ("Verdana",FontWeight.BOLD, 80));
					letters[i][j].setFill(javafx.scene.paint.Color.BLACK);
					int k = i;
					int l = j;
					board[i][j].setOnAction(event -> {
						board[k][l].setDisable(true);
						String winCheck = "XXX";
						String winShow = "X";
						turns++;
						if(turns>=9) {
							winner.setTranslateX(86);
							winner.setText("No One Wins :(");
						}
						if(turn==true) {
							letters[k][l].setText("X");
						}
						else {
							letters[k][l].setText("O");
						}
						text[k][l] = letters[k][l].getText();
						turn = !turn;
						for(int z = 0; z<2; z++) {
							for(int m = 0; m<3; m++) {
								if(((text[m][0]+text[m][1]+text[m][2]).equals(winCheck))||((text[0][m]+text[1][m]+text[2][m]).equals(winCheck))) {
									gameOver = true;
								}
							}
							if((text[0][0]+text[1][1]+text[2][2]).equals(winCheck)||(text[0][2]+text[1][1]+text[2][0]).equals(winCheck)) {
								gameOver = true;
							}	
							if(gameOver==true) {
								z=2;
								for(int y = 0; y<3;y++) {
									for(int x = 0; x<3; x++) {
										board[x][y].setDisable(true);
									}
								}
								winner.setTranslateX(80);
								winner.setText("The Winner is " + winShow+"!");
							}
							else {
								winCheck = "OOO";
								winShow = "O";
							}
						}
					});
				}
			}
		}
	public static void main(String[] args) {
		launch(args);
	}
}
