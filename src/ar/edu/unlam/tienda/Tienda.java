package ar.edu.unlam.tienda;

import java.util.*;

public class Tienda {

	private String cuit;
	private String nombre;
	private List<Producto> stock;
	private Set<Cliente> clientes;
	private Set<Vendedor> vendedores;
	private Set<Venta> ventas;
	private Set<Servicio> servicios;

	public Tienda(String cuit, String nombre) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
		this.stock = new ArrayList<Producto>();
		this.clientes = new HashSet<Cliente>();
		this.vendedores = new HashSet<Vendedor>();
		this.ventas = new HashSet<Venta>();
		this.servicios = new HashSet<Servicio>();
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarProducto(Producto producto) {
		stock.add(producto);

	}

	public Producto getVendible(String codigo) throws VendibleInexistenteException {
		for (Producto producto : stock) {
			if (producto.getCodigo().equals(codigo)) {
				return producto;
			}

		}
		return null;
	}

	public void agregarProducto(Producto producto, Integer cantidad) {

		for (int i = 0; i < cantidad; i++) {
			stock.add(producto);
		}
	}
	
	public void retirarProductoDelStock(Producto producto, Integer cantidad) throws StockInsuficienteException, VendibleInexistenteException {
		
		
		for (int i = 0; i < cantidad; i++) {
		Producto buscado = getVendible(producto.getCodigo());
				
		if(buscado == null) {
			throw new StockInsuficienteException();
		}else {
			stock.remove(producto);
		}
			
		}
	}

	public Integer getStock(Producto producto) {

		return stock.size();
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);

	}

	public Cliente getCliente(String cuit) throws ClienteInexistenteException {
		for (Cliente cliente : clientes) {
			if (cliente.getCuit().equals(cuit)) {
				return cliente;
			}
		}
		throw new ClienteInexistenteException();
	}

	public void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);

	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException {

		for (Vendedor vendedor : vendedores) {
			if (vendedor.getDni().equals(dniEjemplo)) {
				return vendedor;
			}
		}

		throw new VendedorInexistenteException();
	}

	public void agregarVenta(Venta ticket) {
		ventas.add(ticket);
		
	}

	public void agregarProductoAVenta(String codigo, Producto producto, Integer cantidadVendida) throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Venta buscada = buscarVenta(codigo);
		if(buscada == null) {
			throw new VentaInexistenteException();
	}
		
		retirarProductoDelStock(producto,cantidadVendida);
		buscada.agregarVendible(producto,cantidadVendida);
	
		
	}

	private Venta buscarVenta(String codigo) {
		for (Venta venta : ventas) {
			if(venta.getCodigo().equals(codigo)) {
				return venta;
			}
		}
		return null;
	}

	public void agregarServicio(Servicio servicio) {
		servicios.add(servicio);
		
	}

	public void agregarServicioAVenta(String codigo, Servicio servicio) throws VentaInexistenteException {
		Venta buscada = buscarVenta(codigo);
		if(buscada == null) {
			throw new VentaInexistenteException();
	}else {
		buscada.agregarVendible(servicio);
		
	}
		
	}

}
