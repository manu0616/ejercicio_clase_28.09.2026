public class envioaereo extends envio{

    public envioaereo(String codigo, String destino, double peso, double distancia) {
        super(codigo, destino, peso, distancia);
    }

    @Override
    public double calcularcosto() {
        return 0;
    }

    @Override
    public double calculartiempo() {
        return 0;
    }
}
