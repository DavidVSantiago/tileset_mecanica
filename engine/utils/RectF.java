package engine.utils;

public class RectF {
    // atributos ----------------------------------------------
    public float x1, y1;
    public float x2, y2;

    // construtor ---------------------------------------------
    public RectF(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    // métodos de colisão ------------------------------------------------
    public boolean intersedeEsquerda(Rect outro){ // versão Rect
        return x2>=outro.x1;
    }
    public boolean intersedeEsquerda(RectF outro){ 
        return x2>=outro.x1;
    }
    public boolean intersedeDireita(Rect outro){ // versão Rect
        return x1<=outro.x2;
    }
    public boolean intersedeDireita(RectF outro){
        return x1<=outro.x2;
    }
    public boolean intersedeCima(Rect outro){ // versão Rect
        return y2>=outro.y1;
    }
    public boolean intersedeCima(RectF outro){
        return y2>=outro.y1;
    }
    public boolean intersedeBaixo(Rect outro){ // versão Rect
        return y1<=outro.y2;
    }
    public boolean intersedeBaixo(RectF outro){
        return y1<=outro.y2;
    }
    public boolean intersedeTodo(Rect outro){ // versão Rect
        return (intersedeEsquerda(outro) &&
                intersedeDireita(outro) &&
                intersedeCima(outro) &&
                intersedeBaixo(outro));
    }
    public boolean intersedeTodo(RectF outro){
        return (intersedeEsquerda(outro) &&
                intersedeDireita(outro) &&
                intersedeCima(outro) &&
                intersedeBaixo(outro));
    }
}
