package MauricioAmaya.finalBackEnd1.service;

import MauricioAmaya.finalBackEnd1.entity.Odontologo;
import MauricioAmaya.finalBackEnd1.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    //PONER LOS LOGGER EN TODOS LOS SERVICE

    private OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository){
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardarOdontologo (Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public void eliminarOdontologo (Long id){
        odontologoRepository.deleteById(id);
    }
    public void actualizarOdontologo (Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
    public Optional<Odontologo> buscarOdontologo (Long id){
        return odontologoRepository.findById(id);
    }
    public List<Odontologo> buscarTodosOdontologos (){
        return odontologoRepository.findAll();
    }



}
