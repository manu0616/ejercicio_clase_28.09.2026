import java.util.ArrayList;
import java.util.Scanner;

static ArrayList<envio> envios = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

void main() {
    int opcion;
    do {
        mostrarMenu();
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1 -> envios.add(new envioterrestre(
                    leerTexto("Codigo: "),
                    leerTexto("Destino: "),
                    leerNumero("Peso (kg): "),
                    leerNumero("Distancia (km): ")));
            case 2 -> envios.add(new EnvioAereo(
                    leerTexto("Codigo: "),
                    leerTexto("Destino: "),
                    leerNumero("Peso (kg): "),
                    leerNumero("Distancia (km): ")));
            case 3 -> mostrarTodos();
            case 4 -> buscarPorCodigo();
            case 5 -> mostrarMasCostoso();
            case 6 -> calcularTotal();
            case 7 -> contarPorTipo();
            case 8 -> System.out.println("Hasta luego.");
            default -> System.out.println("Opcion no valida.");
        }
    } while (opcion != 8);
}

static void mostrarMenu() {
    System.out.println("\n1. Registrar envio terrestre");
    System.out.println("2. Registrar envio aereo");
    System.out.println("3. Mostrar todos los envios");
    System.out.println("4. Buscar envio por codigo");
    System.out.println("5. Mostrar el envio mas costoso");
    System.out.println("6. Calcular total recaudado");
    System.out.println("7. Mostrar cantidad de envios por tipo");
    System.out.println("8. Salir");
    System.out.print("Opcion: ");
}

static String leerTexto(String mensaje) {
    System.out.print(mensaje);
    return sc.nextLine();
}

static double leerNumero(String mensaje) {
    System.out.print(mensaje);
    return Double.parseDouble(sc.nextLine());
}

static double costoDe(envio e) {
    if (e instanceof envioterrestre) {
        return ((envioterrestre) e).costo();
    }
    return e.CalcularCosto();
}

static void mostrar(envio e) {
    System.out.println("codigo " + e.codigo);
    System.out.println("destino " + e.destino);
    System.out.println("peso " + e.peso);
    System.out.println("distancia " + e.distancia);
    System.out.println("costo " + costoDe(e));
}

static void mostrarTodos() {
    if (envios.isEmpty()) {
        System.out.println("No hay envios registrados.");
        return;
    }
    for (envio e : envios) {
        mostrar(e);
        System.out.println("----------");
    }
}

static void buscarPorCodigo() {
    String codigo = leerTexto("Codigo a buscar: ");
    for (envio e : envios) {
        if (e.codigo.equalsIgnoreCase(codigo)) {
            mostrar(e);
            return;
        }
    }
    System.out.println("No existe un envio con ese codigo.");
}

static void mostrarMasCostoso() {
    if (envios.isEmpty()) {
        System.out.println("No hay envios registrados.");
        return;
    }
    envio mayor = envios.get(0);
    for (envio e : envios) {
        if (costoDe(e) > costoDe(mayor)) {
            mayor = e;
        }
    }
    mostrar(mayor);
}

static void calcularTotal() {
    double total = 0;
    for (envio e : envios) {
        total += costoDe(e);
    }
    System.out.println("Total recaudado: " + total);
}

static void contarPorTipo() {
    int terrestres = 0;
    int aereos = 0;
    for (envio e : envios) {
        if (e instanceof envioterrestre) {
            terrestres++;
        } else if (e instanceof EnvioAereo) {
            aereos++;
        }
    }
    System.out.println("Terrestres: " + terrestres);
    System.out.println("Aereos: " + aereos);
}