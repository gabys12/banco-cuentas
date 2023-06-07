public class Ahorro extends Cuenta {
    private float ahorro_meta;
    public Ahorro(int numero, String titular, float saldo_actual, char estado, float ahorro_meta) {
        super(numero, titular, saldo_actual, estado);
        this.ahorro_meta = ahorro_meta;
    }

    public float getAhorro_meta() {
        return ahorro_meta;
    }
    
    public void setAhorro_meta(float ahorro_meta) {
        this.ahorro_meta = ahorro_meta;
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("AHORRO META: " + this.getAhorro_meta());
    }
    
    public float generarInteres(){
        float valor_interes;
        valor_interes = this.getSaldo_actual()* 0.05f / 100;
        return valor_interes;
    }
        
}