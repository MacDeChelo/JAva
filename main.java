package examen1;
import java.time.LocalDate;
import java.util.Scanner;
public class Examen1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Cliente  cliente = null;
    Vendedor vendedor = null;
    Factura factura = null;
    int opcion;
    
    do {
        System.out.println("\n === Menu Tienda Online ===");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Ingresar vendedor");
        System.out.println("3. Crear nueva factura");
        System.out.println("4. Agregar producto a la factura");
        System.out.println("5. Mostrar factura ");
        System.out.println("0. Salir");
        opcion = sc.nextInt();
        sc.nextLine();
        
        switch (opcion){
            case 1:
                System.out.println("Nombre del cliente");
                String nombreC = sc.nextLine();
                System.out.println("Rut del cliente");
                String rutC = sc.nextLine();
                System.out.println("Correo del cliente");
                String correoC = sc.nextLine();
                System.out.println("Edad del cliente");
                int edadC = sc.nextInt();
                sc.nextLine();
                cliente = new Cliente(nombreC, rutC, correoC, edadC);
                System.out.println("Cliente ingresado correctamente");
                break;
                
            case 2:
                System.out.println("Nombre del vendedor");
                String nombreV = sc.nextLine();
                System.out.println("Rut del vendedor");
                String rutV = sc.nextLine();
                System.out.println("Año de ingreso");
                int anio = sc.nextInt();
                System.out.println("Mes de ingreso");
                int mes = sc.nextInt();
                System.out.println("Dia de ingreso");
                int dia = sc.nextInt();
                LocalDate fechaDeIngreso = LocalDate.of(anio, mes, dia);
                vendedor = new Vendedor(rutV, nombreV, fechaDeIngreso);
                System.out.println("Vendedor registrado correctamente");
                break;
            
            case 3:
                if (cliente == null || vendedor == null){
                        System.out.println("Debe crear ");
                }else {
                    System.out.println("Codigo de producto");
                    factura = new Factura (cliente, vendedor, LocalDate.now());
                    System.out.println("Factura creada correctamente");
                }
                break;
                
            case 4:
                if(factura == null){
                    System.out.println("tienes que crear una fatura primero");
                }else {
                    System.out.println("Codigo del Producto");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Tipo de producto [Mochila - Maleta - Bolso]");
                    String tipo = sc.nextLine();
                    System.out.println("Precio unitario");
                    double precio = sc.nextDouble();
                    System.out.println("Cantida");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    
                    Producto p = new Producto(codigo, tipo, precio, cantidad);
                    factura.agregarProducto(p);
                    System.out.println("Producto agregar a la factura");
                }
                break;
            case 5:
                if(factura == null){
                    System.out.println("tiene que crear la facura primero");
                }else{
                    System.out.println("\n === Factura detallada === ");
                    System.out.println(factura);
                }
                break;
                        
            case 0:
                System.out.println("Saliendo del sistema... ");
                break;
                
            default:
                System.out.println("Opcion invalida. Intente de nuevo.");
        }
    }while (opcion != 0);
    sc.close();
    }
}
