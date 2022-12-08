package MauricioAmaya.finalBackEnd1.security;


import MauricioAmaya.finalBackEnd1.entity.Usuario;
import MauricioAmaya.finalBackEnd1.entity.UsuarioRole;
import MauricioAmaya.finalBackEnd1.repository.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CagarDatosIniciales implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public CagarDatosIniciales(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //cargar usuario para probar

        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();

        String passCifrada = cifrador.encode("admin");
        String passCifrada1 = cifrador.encode("user");

        Usuario usuario = new Usuario("Mauricio","Mauri","admin",passCifrada, UsuarioRole.ROLE_ADMIN);
        Usuario usuario1 = new Usuario("Mauri","Mauri","user",passCifrada1, UsuarioRole.ROLE_USER);

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario1);


    }
}
