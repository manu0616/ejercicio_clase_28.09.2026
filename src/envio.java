public abstract class envio {

    protected String codigo;
    protected String destino;
    protected double peso;
    protected double distancia;


    public envio() {
    }

    public envio(String codigo, String destino, double peso, double distancia) {
        this.codigo = codigo;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
    }

    public static boolean isEmpty() {
        return false;
    }

    public static int get(int i) {

        return i;
    }

    //motodos propios
    public abstract  double calcularcosto();
    public abstract  double calculartiempo();

    public  void mostrardatos(){
        System.out.println("codigo " + codigo );
        System.out.println("destino " + destino);
        System.out.println("peso " + peso );
        System.out.println("distancia " + distancia);
        System.out.println("costo " + calcularcosto());
        System.out.println("tiempo " + calculartiempo());


    }

    public abstract double CalcularCosto();

    public abstract double CalcularTiempoEntrega();
}
