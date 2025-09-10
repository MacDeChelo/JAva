package examen1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
     private final Cliente cliente;
    private final Vendedor vendedor;
    private final LocalDate fecha;
    private final ArrayList<Producto> productos;

    // Constructor
    public Factura(Cliente cliente, Vendedor vendedor, LocalDate fecha) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
    }

    // Agregar producto
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Calcular total bruto
    public double calcularTotalBruto() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularSubTotal();
        }
        return total;
    }

    // Aplicar descuentos
    public double calcularDescuento() {
        double totalBruto = calcularTotalBruto();

        // Descuento especial por edad
        if (cliente.getEdad() > 65) {
            return totalBruto * 0.50; // 50%
        }

        if (totalBruto > 150000) {
            return totalBruto * 0.25;
        } else if (totalBruto > 60000) {
            return totalBruto * 0.15;
        }
        return 0;
    }

    // Calcular total neto
    public double calcularTotalNeto() {
        return calcularTotalBruto() - calcularDescuento();
    }

    // Verificar si pedido está confirmado
    public boolean pedidoConfirmado() {
        // Validaciones cliente
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) return false;
        if (cliente.getEdad() < 18 || cliente.getEdad() > 80) return false;

        // Validaciones vendedor
        if (vendedor.getNombreVendedor() == null || vendedor.getNombreVendedor().isEmpty()) return false;
        if (vendedor.getFechaDeIngreso().isAfter(LocalDate.now())) return false;
       
        // Validar productos
        for(Producto p:productos) {
            if(!(p.getTipo().equalsIgnoreCase("Mochila") ||
                 p.getTipo().equalsIgnoreCase("Maleta") ||
                 p.getTipo().equalsIgnoreCase("Bolso"))){
                return false;
            }
        }
        return true;
    }
    public double aplicarDescuento(double porcentaje){
        return calcularTotalBruto() * (1-porcentaje / 100.0);
            
    }

    @Override
    public String toString() {
        return "Factura{" +
                "\ncliente=" + cliente + 
                ",\nvendedor=" + vendedor + 
                ",\nfecha=" + fecha + 
                ",\nProductos=" + productos +
                ",\nTotalBruto=" + calcularTotalBruto() +
                ",\nDescuento=" + calcularDescuento() +
                ",\nTotal Netos=" + calcularTotalNeto() +
                ",\nPedido Confirmado=" + (pedidoConfirmado() ? "Si": "no")+
                "\n";
    }         
    }
