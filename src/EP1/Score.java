package EP1;
import java.awt.*;
import EP1.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {
	public static int p1=0;
	public static int p2=0;
	private String playerId;

	/**
		Construtor da classe Score.

		@param playerId uma string que identifica o player ao qual este placar está associado.
	*/

	public Score(String playerId){
		this.playerId = playerId;
	}

	/**
		Método de desenho do placar.
	*/

	public void draw(){
		String placar1 = Integer.toString(p1);
		String placar2 = Integer.toString(p2);
		GameLib.setColor(Color.BLUE);
		GameLib.drawText("Player 2:"+placar2, 70, GameLib.ALIGN_RIGHT);
		GameLib.setColor(Color.GREEN);
		GameLib.drawText("Player 1:"+placar1, 70, GameLib.ALIGN_LEFT);
	}

	/**
		Método que incrementa em 1 unidade a contagem de pontos.
	*/

	public void inc(){
		if(playerId == "Player 1"){
			p1++;
		}else if(playerId == "Player 2"){
			p2++;
		}
		return;
	}

	/**
		Método que devolve a contagem de pontos mantida pelo placar.

		@return o valor inteiro referente ao total de pontos.
	*/

	public int getScore(){
		return 0;
	}
}
