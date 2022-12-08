function deleteBy(id)
{

        let aler = confirm("Esta por eliminar un turno, si aun desea hacerlo haz click en confirmar");

         if (aler == true){

          const url = '/turnos/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())

          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

          }else{

                      alert("Excelente decision!");

                     }

}