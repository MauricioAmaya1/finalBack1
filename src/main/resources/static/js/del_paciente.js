function deleteBy(id)
{
           let aler = confirm("Al eliminar este paciente puede eliminar un turno, si aun desea hacerlo haz click en confirmar");

           if (aler == true){


          const url = '/pacientes/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())

          //borrar la fila de la pelicula eliminada
          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

          }else{

            alert("Excelente decision!");

          }

}