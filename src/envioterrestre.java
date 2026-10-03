public class envioterrestre extends envio{
 private double Costo = 8000;
    public envioterrestre(String codigo, String destino, double peso, double distancia) {
        super(codigo, destino, peso, distancia);
    }

    private double costoInicial() {
        return Costo + (peso * 1500) + (distancia * 400);
    }

    private double recargoPeso() {
        if (peso > 20) {
            return 1.10;
        }
        return 1;
    }

    private double recargoDistancia() {
        if (distancia > 500) {
            return 1.15;
        }
        return 1;
    }

    public double costo() {
        return costoInicial() * recargoPeso() * recargoDistancia();
    }




    @Override
    public double calcularcosto() {
        return calcularcosto();
    }

    @Override
    public double calculartiempo() {
        return calculartiempo();
    }
}
