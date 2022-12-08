package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    //PONER LOS LOGGER EN TODOS LOS SERVICE

    private OdontologoRepository odontologoRepository;

    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository){
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardarOdontologo (Odontologo odontologo){
        LOGGER.info("Se inicio un guardado de odontologo");
        return odontologoRepository.save(odontologo);
    }
    public void eliminarOdontologo (Long id){
        LOGGER.info("Se inicio una eliminacion de odontologo");
        odontologoRepository.deleteById(id);
    }
    public void actualizarOdontologo (Odontologo odontologo){
        LOGGER.info("Se inicio una actualizacion de odontologo");
        odontologoRepository.save(odontologo);
    }
    public Optional<Odontologo> buscarOdontologo (Long id){
        LOGGER.info("Se inicio una busqueda por id de odontologo");
        return odontologoRepository.findById(id);
    }
    public List<Odontologo> buscarTodosOdontologos (){
        LOGGER.info("Se inicio una busqueda de odontologos");
        return odontologoRepository.findAll();
    }



}
