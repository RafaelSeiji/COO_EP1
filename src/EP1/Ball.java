package EP1;
import EP1.*;

import java.awt.*;
import java.util.Random;

/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {
	private int rand = -1;
	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private double speed;
	private double speedx;
	private double speedy;
	private double timer;

	/**
		Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola 
		(em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada 
		aleatóriamente pelo construtor.

		@param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
		@param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
		@param width largura do retangulo que representa a bola.
		@param height altura do retangulo que representa a bola.
		@param color cor da bola.
		@param speed velocidade da bola (em pixels por millisegundo).
	*/

	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;
		//speed = 2;
		speedx = speed;
		speedy = speed;
	}


	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
	*/

	public void draw(){

		GameLib.setColor(Color.YELLOW);
		GameLib.fillRect(cx, cy, width, height);
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.
		
		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void update(long delta){
		//AUMENTAR SPEED SE TIVER MUITO LENTO
		if(rand == -1){
			Random r = new Random();
			rand = r.nextInt(4);
		}
		switch (rand){
			case 0:
				cx+=speedx;
				cy+=speedy;
				break;
			case 1:
				cx-=speedx;
				cy+=speedy;
				break;
			case 2:
				cx+=speedx;
				cy-=speedy;
				break;
			case 3:
				cx-=speedx;
				cy-=speedy;
				break;
		}
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
	
		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	public void onPlayerCollision(String playerId){
		speedx = speedx*-1;

	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.

		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

	public void onWallCollision(String wallId){
		if(wallId == "Bottom"){
			speedy = speedy*-1;
		}
		if(wallId == "Top"){
			speedy = speedy*-1;
		}
		if(wallId == "Right") {
			cx = getCx();
			cy = getCy();
			rand = -1;
		}
		if(wallId == "Left"){
			cx=getCx();
			cy=getCy();
			rand=-1;
		}

	}

	/**          
		Método que verifica se houve colisão da bola com uma parede.

		@param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/
	
	public boolean checkCollision(Wall wall){
		if(wall.getId()=="Bottom" && cy>=wall.getCy()-height){
			return true;
		}
		if(wall.getId()=="Top" && cy<=wall.getCy()+height){
			return true;
		}
		if(wall.getId()=="Left" && cx<=wall.getCx()+width){
			return true;
		}
		if(wall.getId()=="Right" && cx>=wall.getCx()-height){
			return true;
		}
		 return false;
	}

	/**
		Método que verifica se houve colisão da bola com um jogador.

		@param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/	

	public boolean checkCollision(Player player){
		if(player.getId() == "Player 1"){
			if(cx<=(player.getCx()+5+player.getWidth()/2) && cy<=(player.getCy())+(player.getHeight()/2)
					&& cy>=(player.getCy())-(player.getHeight()/2)){
				if(cx<=(player.getCx()+player.getWidth()/2)){
					return false;
				}
				return true;
			}
		}else if(player.getId() == "Player 2"){
			if(cx>=(player.getCx()-5-player.getWidth()/2) && cy<=(player.getCy())+(player.getHeight()/2)
					&& cy>=(player.getCy())-(player.getHeight()/2)){
				if(cx>=(player.getCx()+player.getWidth()/2)) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	/**
		Método que devolve a coordenada x do centro do retângulo que representa a bola.
		@return o valor double da coordenada x.
	*/
	
	public double getCx(){

		return 400;
	}

	/**
		Método que devolve a coordenada y do centro do retângulo que representa a bola.
		@return o valor double da coordenada y.
	*/

	public double getCy(){

		return 300;
	}

	/**
		Método que devolve a velocidade da bola.
		@return o valor double da velocidade.

	*/

	public double getSpeed(){

		return 0;
	}

}
