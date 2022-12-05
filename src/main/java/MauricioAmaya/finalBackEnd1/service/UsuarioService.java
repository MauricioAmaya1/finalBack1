package MauricioAmaya.finalBackEnd1.service;


import MauricioAmaya.finalBackEnd1.entity.Usuario;
import MauricioAmaya.finalBackEnd1.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByEmail(username);

        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else{
            throw  new UsernameNotFoundException("Nombre de usuario no encontrado");
        }


    }

}
