public class EnvioAereo extends envio{

    private double Costo=20000;

    public EnvioAereo() {
    }

    public EnvioAereo(String codigo, String destino, double peso, double distancia) {
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

    @Override
    public String toString() {
        return "EnvioAereo{" +
                "Costo=" + Costo +
                ", Codigo='" + codigo + '\'' +
                ", Destino='" + destino + '\'' +
                ", Peso=" + peso +
                ", Distancia=" + distancia +
                '}';
    }

    @Override
    public double CalcularCosto() {
        double CostoTotal=Costo+(peso*4000)+(distancia*600);
        if(peso>10)
        {
            System.out.println("El valor incrementara un 20% adicional.");
            CostoTotal=CostoTotal+(CostoTotal*0.2);
        } else if (peso<0)
        {
            System.out.println("Error de calculo en el valor de envio.");
        } else {
            System.out.println("Ho hay cambios en el valor.");
        }

        if(distancia>1000)
        {
            System.out.println("El valor reducira un 5% adicional por superar el km limite.");
            CostoTotal=CostoTotal-(CostoTotal*0.05);
        } else if (distancia<0) {
            System.out.println("Error de calculo en el valor de envio.");
        } else {
            System.out.println("No hay cambios en el valor.");
        }
        return CostoTotal;
    }

    @Override
    public double CalcularTiempoEntrega() {
        if(distancia<=500)
        {
            System.out.println("El tiempo de llegada del envio es de 1 dia.");
        } else if (distancia>500 && distancia <=1500) {
            System.out.println("El tiempo de llegada del envio es de 2 dias.");
        } else if (distancia>1500) {
            System.out.println("El tiempo de llegada del envio es de 3 dias.");
        } else {
            System.out.println("Error en el tiempo de llegada.");
        }
        return distancia;
    }
}