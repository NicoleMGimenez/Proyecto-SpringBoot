package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.repository.IClienteDAO;
import ar.edu.unju.edm.service.IClienteService;

@Service
@Qualifier("implementacionMYSQL")

public class ClienteServiceMySQL implements IClienteService {

	@Autowired
	Cliente unCliente;
	@Autowired
	IClienteDAO iClienteDAO;
	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		String pw = unCliente.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unCliente.setPassword(bCryptPasswordEncoder.encode(pw));
		
		iClienteDAO.save(unCliente);
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>) iClienteDAO.findAll();
	}

	@Override
	public Cliente encontrarUnCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		return iClienteDAO.findByNroDocumento(dni).orElseThrow(()->new Exception("El cliente NO existe"));
	}

	@Override
	public void modificarCliente(Cliente clienteModificado) throws Exception {
		// TODO Auto-generated method stub
		//Se busca el Cliente que se quiere modificar en la BD (por algún campo que no se permita modificar)
		//Se utilizo DNI pero si en mi app puedo cambiar el DNI, entonces la sentencia siguiente no sería correcta
		//Tal vez sería mejor buscar por ID, que es un campo que no se modifica (findById)	
		Cliente clienteAModificar = iClienteDAO.findByNroDocumento(clienteModificado.getNroDocumento()).orElseThrow(()->new Exception("El Cliente no fue encontrado"));

		//Si se utiliza directamente save, lo que se hace es AGREGAR otro cliente a la BD, y lo que nosotros queremos hacer es SUSTITUIR
		//Por lo que clienteDAO.save(unClienteModificado); se deja al final del metodo

		//Se realiza el intercambio entre el cliente que viene y el cliente que ya está en la BD
		//Y se guarda el cliente que está en la BD, pero se hace en otro método
		cambiarCliente(clienteModificado, clienteAModificar);

		//Vuelve el cliente en la BD ya modificado y se guarda
		iClienteDAO.save(clienteAModificar);
	}

	private void cambiarCliente(Cliente clienteModificado, Cliente clienteAModificar) {
		// TODO Auto-generated method stub
		//se pasan todos los atributos del cliente que viene, hacia el cliente que ya está en la BD
		clienteAModificar.setNroDocumento(clienteModificado.getNroDocumento());
		clienteAModificar.setTipoDocumento(clienteModificado.getTipoDocumento());
		clienteAModificar.setFechaNacimiento(clienteModificado.getFechaNacimiento());
		clienteAModificar.setCodigoAreaTelefono(clienteModificado.getCodigoAreaTelefono());
		clienteAModificar.setNumTelefono(clienteModificado.getNumTelefono());
		clienteAModificar.setEmail(clienteModificado.getEmail());
	}

	@Override
	public void eliminarCliente(int id) throws Exception {
		// TODO Auto-generated method stub
		Cliente clienteEliminar = iClienteDAO.findByNroDocumento(id).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		iClienteDAO.delete(clienteEliminar);
	}

}