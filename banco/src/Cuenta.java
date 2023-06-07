abstract public class Cuenta {
    private int numero;
    private String titular;
    private float saldo_actual;
    private char estado;

    public Cuenta(int numero, String titular, float saldo_actual, char estado) {
        this.numero = numero;
        this.titular = titular;
        this.saldo_actual = saldo_actual;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public float getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(float saldo_actual) {
        this.saldo_actual = saldo_actual;
    }
    
    public void mostrar(){
        System.out.println("NUMERO CTA: " + this.getNumero());
        System.out.println("TITULAR   : " + this.getTitular());
        System.out.println("SALDO     : " + this.getSaldo_actual());
        System.out.println("ESTADO    : " + this.getEstado());
    }
    
    abstract public float generarInteres();
}