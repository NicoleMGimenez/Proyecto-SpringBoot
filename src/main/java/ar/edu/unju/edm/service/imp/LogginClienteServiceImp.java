package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.repository.IClienteDAO;

@Service
public class LogginClienteServiceImp implements UserDetailsService {

	@Autowired
	IClienteDAO iClienteDAO;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// metodo que nos devuelve detalles de un usuario
		
		System.out.println("bbbbbbbbbbbbbbbbbb");
		Cliente clienteEncontrado = iClienteDAO.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Cliente inválido"));

		//generamos una lista de autorizaciones
		List<GrantedAuthority> tipos = new ArrayList<>();
		//generamos tipo de autorizaciones
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(clienteEncontrado.getTipoDocumento());
		tipos.add(grantedAuthority);
		System.out.println("cccccccccccccccccccccc");
		//usuario que va a estar en sesion
		UserDetails user = (UserDetails) new User(email, clienteEncontrado.getPassword(), tipos);
		return user;
	}
	
}
