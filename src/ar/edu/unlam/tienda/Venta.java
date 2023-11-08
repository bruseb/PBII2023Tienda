package ar.edu.unlam.tienda;

import java.util.*;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;
	private List<Vendible> vendibles;

	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {

		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.vendibles = new ArrayList<Vendible>();
	}

	public void agregarVendible(Servicio actual) {
		vendibles.add(actual);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Double getTotal() {
		Double totalServicios = 0.0;
		for (Vendible vendible : vendibles) {
			if (vendible instanceof Producto) {
				totalServicios += vendible.getPrecio();
			}
			if (vendible instanceof Servicio) {
				totalServicios += vendible.getPrecio();
			}
		}
		return totalServicios;
	}

	public void agregarVendible(Producto producto, Integer cantidadVendida) {
		for (int i = 0; i <cantidadVendida;i++) {
			vendibles.add(producto);
		}
		
	}

}
