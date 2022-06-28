package engine.utils;

import engine.scene.Level;
import engine.scene.Tile;

public class Camera {
    public static Camera singleton = null;
    // atributos
    public float posX,posY;
    public float velX,velY,velBaseX,velBaseY,velBaseYParede,decremVelY,limiteVelY;
    public int largura, altura;
    public Level levelAtual;

    // construtor
    public Camera(float posX,float posY,int largura,int altura){
        this.posX = posX;
		this.posY = posY;
		this.largura = largura;
		this.altura = altura;
		this.velBaseX=4;
        this.velBaseY=4;
        this.velBaseYParede=1.5f;
		this.velX=0;
		this.velY=0;
        this.decremVelY=0.2f;
        this.limiteVelY = 6;
    }

    // metodos gameloop ------------------------
    public void handlerEvents() {
         // move a tela
		KeyState keyState = Recursos.getInstance().keyState;
        velX=0;
		velY=0;
        // move baixo e cima
        if(keyState.k_baixo)
            velY=velBaseY;
        else if(keyState.k_cima)
            velY=-velBaseY;

        // move esquerda e direita
        if(keyState.k_esquerda)
            velX=-velBaseX;
        else if(keyState.k_direita)
            velX=velBaseX;
    }
    public void update(){
        posX+=velX;
        posY+=velY;
    }

    // Métodos posicionamento --------------------------------------------

    public void moverHorizontal(){
        posX += velX;
    }

    public void moverVertical(){
        posY += velY;
    }

    // metodos --------------------------------

    public void checarColisao(){
        // colisão com limites do Level
        if(posX<0) posX=0;
        if(posY<0) posY=0;
        if(posX+largura>levelAtual.larguraLevel) posX=levelAtual.larguraLevel-largura;
        if(posY+altura>levelAtual.alturaLevel) posY=levelAtual.alturaLevel-altura;
    }

    public boolean cameraEsquerdaLevel(){
        if(posX<=0) return true;
        return false;
    }
    public boolean cameraDireitaLevel(){
        if(posX+largura>=levelAtual.larguraLevel) return true;
        return false;
    }
    public boolean cameraSuperiorLevel(){
        if(posY<=0) return true;
        return false;
    }
    public boolean cameraInferiorLevel(){
        if(posY+altura>=levelAtual.alturaLevel) return true;
        return false;
    }
}