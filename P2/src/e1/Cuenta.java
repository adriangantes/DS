package e1;

abstract class Cuenta {
    private final String iban;
    private long saldo;
    private final Cliente cliente;

    public Cuenta (String iban, long saldo, Cliente cliente){

        if (iban == null || iban.isEmpty()) {
            throw new IllegalArgumentException("IBAN nulo");
        } else {
            this.iban = iban;
        }

        if (saldo > 0){
            this.saldo = saldo;
        }else{
            throw new IllegalArgumentException("Saldo negativo");
        }

        if (cliente == null){
            throw new IllegalArgumentException("Cliente nulo");
        }else{
            this.cliente = cliente;
        }
    }

    public long getSaldo(){
        return saldo;
    }

    public String getIban (){
        return iban;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public void retirada(long cantidad) {
        if (cantidad <= saldo){
            saldo -= cantidad;
        } else{
            throw new IllegalArgumentException("Cantidad mayor al saldo");
        }

    }
    public void ingreso (long cantidad) {
        saldo += cantidad;
    }
}

class CuentaAhorro extends Cuenta{

    public CuentaAhorro (String iban, long saldo, Cliente cliente) {
        super(iban, saldo, cliente);
    }

    @Override
    public void retirada(long cantidad){
        Cliente cliente =  getCliente();
        if (cantidad >= cliente.getMinimoRetirada() && !cliente.getDescubierto()){
            if (cliente.getCom() == 0.02 && cantidad <= getSaldo()+100000){
                setSaldo(getSaldo() - (cantidad + (long)((double)cantidad * cliente.getCom())));
            }else if(cantidad <= getSaldo()){
                setSaldo(getSaldo() - (cantidad + (long)((double)cantidad * cliente.getCom())));
            }else{
                throw new IllegalArgumentException("Cantidad máxima de retirada superada.");
            }
        }else if (cliente.getDescubierto()){
            setSaldo(getSaldo() - cantidad);
        }else{
            throw new IllegalArgumentException("Retirada imposible.");
        }
    }

    @Override
    public void ingreso(long cantidad){
        Cliente cliente =  getCliente();
        if (cantidad >= cliente.getMinimoIngreso()){
            setSaldo(getSaldo() + cantidad);
        }else{
            throw new IllegalArgumentException("Cantidad mínima de ingreso no superada.");
        }
    }
}

class CuentaCorriente extends Cuenta{
    public CuentaCorriente(String iban, long saldo, Cliente cliente) {
        super(iban, saldo, cliente);
    }

    @Override
    public void retirada(long cantidad){
        Cliente cliente =  getCliente();
        if (cantidad >= cliente.getMinimoRetirada() && !cliente.getDescubierto()){
            if (cliente.getCom() == 0.02 && cantidad <= getSaldo()+100000){
                setSaldo(getSaldo() - cantidad);
            }else if(cantidad <= getSaldo()){
                setSaldo(getSaldo() - cantidad);
            }else{
                throw new IllegalArgumentException("Cantidad máxima de retirada superada.");
            }
        }else if (cliente.getDescubierto()){
            setSaldo(getSaldo() - cantidad);
        }else{
            throw new IllegalArgumentException("Retirada imposible.");
        }
    }
}
