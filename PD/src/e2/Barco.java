package e2;

public class Barco {
    private int hp;
    private final int blindaje;
    private final int ataque;
    private final int antiaereo;
    private final int vision;

    public Barco (int hp, int blindaje, int ataque, int antiaereo, int vision){
        if(hp < 0){
            System.out.println("HP negativo, inicializado a 0.");
            this.hp = 0;
        }else{
            this.hp = hp;
        }

        if(blindaje < 0){
            System.out.println("Blindaje negativo, inicializado a 0.");
            this.blindaje = 0;
        }else{
            this.blindaje = blindaje;
        }

        if(ataque < 0){
            System.out.println("Ataque negativo, inicializado a 0.");
            this.ataque = 0;
        }else{
            this.ataque = ataque;
        }

        if(antiaereo < 0){
            System.out.println("Antiaereo negativo, inicializado a 0.");
            this.antiaereo = 0;
        }else{
            this.antiaereo = antiaereo;
        }

        if(vision < 0){
            System.out.println("Vision negativo, inicializado a 0.");
            this.vision = 0;
        }else{
            this.vision = vision;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAntiaereo() {
        return antiaereo;
    }

    public int getVision() {
        return vision;
    }
}
