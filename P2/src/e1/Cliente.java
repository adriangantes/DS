package e1;


abstract class Cliente {
    private final String dni;
    private double com = 0;
    private long minimoIngreso=0;
    private long minimoRetirada=0;
    private boolean descubierto = false;

    public Cliente (String dni){
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("DNI nulo");
        } else {
            this.dni = dni;
        }
    }

    public String getDni (){
        return dni;
    }

    public double getCom (){
        return com;
    }
    public long getMinimoIngreso (){
        return minimoIngreso;
    }
    public long getMinimoRetirada (){
        return minimoRetirada;
    }
    public boolean getDescubierto (){
        return descubierto;
    }
    public void setCom (double com){
        this.com = com;
    }

    public void setMinimoRetirada (long minimoRetirada){
        this.minimoRetirada = minimoRetirada;
    }

    public void setMinimoIngreso (long minimoIngreso){
        this.minimoIngreso = minimoIngreso;
    }

    public void setDescubierto (boolean descubierto){
        this.descubierto = descubierto;
    }
}

class ClienteNormal extends Cliente {

    public ClienteNormal(String dni) {
        super(dni);
        setCom(0.04);
        setMinimoIngreso(100000);
        setMinimoRetirada(300);
    }
}

class ClientePreferente extends Cliente{

    public ClientePreferente(String dni) {
        super(dni);
        setCom(0.02);
        setMinimoIngreso(50000);
        setMinimoRetirada(100);
    }
}

class ClienteVip extends Cliente{
    public ClienteVip(String dni) {
        super(dni);
        setDescubierto(true);
    }
}
