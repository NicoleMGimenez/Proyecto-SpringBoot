package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IProductoDAO;
import ar.edu.unju.edm.service.IProductoService;

@Service
@Qualifier("implementacionMYSQLproducto")

public class ProductoServiceMySQL implements IProductoService{

	@Autowired
	Producto unProducto;
	@Autowired
	IProductoDAO iProductoDAO;
	@Override
	public void guardarProducto(Producto productoGuardado) {
		// TODO Auto-generated method stub
		iProductoDAO.save(productoGuardado);
	}

	@Override
	public Producto obtenerUnProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return (ArrayList<Producto>) iProductoDAO.findAll();
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto encontrarUnProducto(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object crearProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public void modificarProducto(Producto productoModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		
	}

}
