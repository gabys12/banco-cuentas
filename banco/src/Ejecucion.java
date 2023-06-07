import java.util.Scanner;
public class Ejecucion {
public static int posicion = 0;
public static void CrearCuentaAhorro(Scanner entrada, Cuenta []cta , Cuenta[]ahorro){
    int dc= -1; int num_cta; String titular_cta;  float saldo_actual, ah_meta; char estado;
    int ind=0;
    do{
        System.out.println("\nCREACION DE CUENTAS DE AHORRO");
        System.out.println("*********");
        System.out.println("INGRESE NUMERO CUENTA: ");
        num_cta= entrada.nextInt();
        System.out.println("INGRESE TITULAR CUENTA: ");
        titular_cta= entrada.next();
        System.out.println("INGRESE SALDO ACTUAL: ");
        saldo_actual= entrada.nextFloat();
        System.out.println("INGRESE AHORRO META: ");
        ah_meta= entrada.nextFloat();
        estado= 'A';
        cta[ind]= new Ahorro(num_cta, titular_cta, saldo_actual, estado, ah_meta);
        ahorro[ind]= cta[ind];
        ind++;
        System.out.println("DATOS GRABADOS CORRECTAMENTE.....");
        System.out.println("DIGITE [1] CONTINUAR - DIGITE[2] SALIR AL MENU: ");
        dc=entrada.nextInt();
        System.out.println(dc);  
    }while(dc==1);
}
public static void CrearCuentaCorriente(Scanner entrada, Cuenta []cta){
    int dc = -1; int num_cta; String titular_cta; float saldo_actual; char estado;String of_cred;
    int ind=0;
    do{
        System.out.println("\nCREACION DE CUENTAS CORRIENTES");
        System.out.println("**********");
        System.out.println("INGRESE NUMERO DE CUENTA : ");
        num_cta = entrada.nextInt();
        System.out.println("INGRESE TITULAR DE LA CUENTA: ");
        titular_cta = entrada.next();
        System.out.println("INGRESE SALDO ACTUAL : ");
        saldo_actual = entrada.nextFloat();
        System.out.println("INGRESE OFICIAL DE CREDITO : ");
        of_cred = entrada.next();
        estado = 'A';
        cta[ind] = new Corriente(num_cta, titular_cta, saldo_actual, estado, of_cred);
        ind++;
        System.out.println("DATOS GRABADOS CORRECTAMENTE...");
        System.out.println("DIGITE  [1] CONTINUAR - DIGITE [2] SALIR AL MENU: ");
        dc = entrada.nextInt();
        
    }while(dc == 1);

}
public static void consultarSaldos(Cuenta []cta){
    System.out.println("\nCONSULTANDO DATOS DE LAS CUENTAS...");
        for (int i = 0; i < cta.length; i++){
            System.out.println("TIPO CUENTA: " + cta[i].getClass() + " TITULAR: " + cta[i].getTitular() + "  SALDO ACTUAL: " + cta[i].getSaldo_actual());
        }
}
public static void generarInteres(Cuenta []cta){
    System.out.println("\nGENERANDO INTERES DE LAS CUENTAS...");
    for(int i=0 ; i< cta.length ; i++){
        System.out.println("TITULAR: " + cta[i].getTitular() + " INTERES: " + cta[i].generarInteres());
        cta[i].setSaldo_actual(cta[i].getSaldo_actual() + cta[i].generarInteres());
        System.out.println("SALDO ACTUAL ACTUALIZADO: " + cta[i].getSaldo_actual());
    }
}
public static void depositarCorriente(Cuenta[]cta) {
    Scanner entrada = new Scanner(System.in);float valor_deposito;
    int numero_cuenta, indice = 0, posicion = -1 ;  boolean encontrado = false;
    System.out.println("DEPOSITO DE CORRIENTE");
    System.out.println("*******");
    System.out.println("INGRESAR NUMERO DE CUENTA: ");
    numero_cuenta = entrada.nextInt();
    while(indice< cta.length && encontrado== false){
        if(cta[indice].getNumero() == numero_cuenta){
            posicion = indice;
            encontrado = true;
        }
        indice++;
    }
    if(encontrado == true){ 
    System.out.println("TITULAR: " + cta[posicion].getTitular());
    System.out.println("INGRESAR VALOR DEL DEPOSITO: ");
    valor_deposito = entrada.nextFloat();
    cta[posicion].setSaldo_actual(valor_deposito + cta[posicion].getSaldo_actual());
    System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
    System.out.println("\nDEPOSITO REALIZADO CON EXITO...\n");
    }else{
        System.out.println("\nCUENTA NO EXISTENTE...");
    }
}
public static void depositarAhorro(Cuenta[]cta) {
    Scanner entrada = new Scanner(System.in);float valor_deposito;
    int numero_cuenta, indice = 0, posicion = -1 ;  boolean encontrado = false;
    System.out.println("DEPOSITO DE AHORRO");
    System.out.println("*******");
    System.out.println("INGRESAR NUMERO DE CUENTA: ");
    numero_cuenta = entrada.nextInt();
    while(indice< cta.length && encontrado== false){
        if(cta[indice].getNumero() == numero_cuenta){
            posicion = indice;
            encontrado = true;
        }
        indice++;
    }
    if(encontrado == true){ 
    System.out.println("TITULAR: " + cta[posicion].getTitular());
    System.out.println("INGRESAR VALOR DEL DEPOSITO: ");
    valor_deposito = entrada.nextFloat();
    cta[posicion].setSaldo_actual(valor_deposito + cta[posicion].getSaldo_actual());
    System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
    System.out.println("\nDEPOSITO REALIZADO CON EXITO...\n");
    }else{
        System.out.println("\nCUENTA NO EXISTENTE...");
    }  
}
public static void retiroCorriente(Cuenta[]cta) {
    Scanner entrada = new Scanner(System.in);float valor_retiro;
    int numero_cuenta, indice = 0, posicion = -1 ;  boolean encontrado = false;
    System.out.println("RETIRO DE DINERO DE CUENTA CORRIENTE");
    System.out.println("*******");
    System.out.println("INGRESAR NUMERO DE CUENTA: ");
    numero_cuenta = entrada.nextInt();
    while(indice< cta.length && encontrado== false){
        if(cta[indice].getNumero() == numero_cuenta){
            posicion = indice;
            encontrado = true;
        }
        indice++;
    }
    if(encontrado == true){ 
       do{  
            System.out.println("TITULAR: " + cta[posicion].getTitular());
            System.out.println("INGRESAR VALOR DEL RETIRO: ");
            valor_retiro = entrada.nextFloat();
            if(valor_retiro<=0){ 
                System.out.println("NO SE PUEDE RETIRAR $0 DOLARES");
            }
            if(valor_retiro> cta[posicion].getSaldo_actual()){
                System.out.println("ERROR , SALDO NO SUFICIENTE");
            }
        }while(valor_retiro<=0 || valor_retiro>cta[posicion].getSaldo_actual());
        if(cta[posicion].getSaldo_actual()>=1000){
            cta[posicion].setEstado('A');
            if(cta[posicion].getEstado()=='A'){
                cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual()-valor_retiro);
                System.out.println("RETIRO EXITOSO");
                System.out.println("SALDO ACTUAL EN LA CUENTA:" + cta[posicion].getSaldo_actual());
            }
        }else{
            cta[posicion].setEstado('I');
        }
        if(cta[posicion].getEstado()=='I'){
            System.out.println("CUENTA CORRIENTE INACTIVA , NO SE PUEDE REALIZAR NINGUN RETIRO.");
        }
             
    }else{
        System.out.println("\nCUENTA NO EXISTENTE...");
    }  
}
public static void retiroAhorro(Cuenta[]cta, Ahorro[]ahorro) {
    Scanner entrada = new Scanner(System.in);float valor_retiro;
    int numero_cuenta; int indice =0, posicion = -1 ;  boolean encontrado = false;
    System.out.println("RETIRO DE DINERO DE CUENTA DE AHORRO");
    System.out.println("*******");
    System.out.println("INGRESAR NUMERO DE CUENTA: ");
    numero_cuenta = entrada.nextInt();
    while(indice< cta.length && encontrado== false){
        if(cta[indice].getNumero() == numero_cuenta){
            posicion = indice;
            encontrado = true;
        }
        indice++;
    }
    if(encontrado == true){ 
        System.out.println("TITULAR: " + cta[posicion].getTitular());
        System.out.println("INGRESAR EL VALOR A RETIRAR: ");
        valor_retiro = entrada.nextFloat();
        if(ahorro[posicion].getSaldo_actual()>ahorro[posicion].getAhorro_meta() && valor_retiro< ahorro[posicion].getSaldo_actual()){
            cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual()-valor_retiro);
            System.out.println("SU AHORRO META ES: " + ahorro[posicion].getAhorro_meta());
            System.out.println("SU SALDO ACTUAL ES: " + cta[posicion].getSaldo_actual());
            System.out.println("RETIRO EXITOSO");
        }else
        System.out.println("NO HA ALCANZADO SU AHORRO META , RETIRO NO DISPONIBLE");
    }else{ 
        System.out.println("\nCUENTA NO EXISTENTE...");
    }  
}
public static void menuPrincipal(Scanner entrada, Cuenta []cta , Ahorro[]ahorro){
    System.out.println("MENU PRINCIPAL");
    System.out.println("******");
    System.out.println("1. APERTURAR CUENTA AHORRO");
    System.out.println("2. APERTURAR CUENTA CORRIENTE");
    System.out.println("3. DEPOSITO EN CUENTA AHORRO");
    System.out.println("4. DESPOSITO EN CUENTA CORRIENTE");
    System.out.println("5. CONSULTAR SALDOS DE CUENTAS");
    System.out.println("6. GENERAR INTERES");
    System.out.println("7. RETIRO CUENTA AHORRO");
    System.out.println("8. RETIRO CUENTA CORRIENTE");
    System.out.println("9. SALIR");
    System.out.println("DIGITE UNA OPCION: ");
    int opcion = entrada.nextInt();
    switch(opcion){
        case 1: CrearCuentaAhorro(entrada, cta, ahorro);menuPrincipal(entrada, cta, ahorro);break;
        case 2: CrearCuentaCorriente(entrada, cta);menuPrincipal(entrada, cta, ahorro);break;
        case 3: depositarAhorro(cta);menuPrincipal(entrada, cta, ahorro);break;                
        case 4: depositarCorriente(cta);menuPrincipal(entrada, cta, ahorro);break;
        case 5: consultarSaldos(cta);menuPrincipal(entrada, cta, ahorro);break;
        case 6: generarInteres(cta);menuPrincipal(entrada, cta, ahorro);break;
        case 7: retiroAhorro(cta, ahorro);menuPrincipal(entrada, cta, ahorro);break;
        case 8: retiroCorriente(cta);menuPrincipal(entrada, cta, ahorro);break;

    }
}

    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        final int MAX = 2;
        Cuenta[] cta = new Cuenta[MAX];
        Ahorro[] ahorro=new Ahorro[MAX];
        menuPrincipal(entrada, cta, ahorro);
    }

}