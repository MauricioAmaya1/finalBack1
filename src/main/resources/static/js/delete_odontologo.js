function deleteBy(id)
{

           let aler = confirm("Al eliminar este odontologo puede eliminar un turno, si aun desea hacerlo haz click en confirmar");

           if (aler == true){

             //con fetch invocamos a la API de peliculas con el método DELETE
             //pasandole el id en la URL
             const url = '/odontologos/'+ id;
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