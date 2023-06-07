public class Corriente extends Cuenta {
    private String oficial_credito;

    public Corriente(int numero, String titular, float saldo_actual, char estado, String oficial_credito) {
        super(numero, titular, saldo_actual, estado);
        this.oficial_credito = oficial_credito;
    }

    public String getOficial_credito() {
        return oficial_credito;
    }

    public void setOficial_credito(String oficial_credito) {
        this.oficial_credito = oficial_credito;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("OFICIAL CREDITO:" + this.getOficial_credito());
    }
    public float generarIntereses(){
        float valor_intereses;
        valor_intereses = this.getSaldo_actual() * 0.08f / 100;
        return valor_intereses;
    }

    @Override
    public float generarInteres() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
