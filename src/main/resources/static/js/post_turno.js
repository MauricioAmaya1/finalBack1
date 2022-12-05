window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {

        let formData = {
                    fecha : $("#fecha").val(),
                    odontologo : { id: $("#odontologo").val()
                    },
                    paciente: { id: $("#paciente").val()
                    }
        }

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> turno creado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {

                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";

                     resetUploadForm();})
    });


    $.ajax({
                type : "GET",
                url : "/pacientes/",
                success: function(response){
                $.each(response, (i, paciente) => {
                    let option = '<option' + ' value=' + '\"' + paciente.id + '\">' + paciente.nombre +' '+ paciente.apellido +'</option>';
                    $('#paciente').append(option);
                });
                },
                error : function(e) {
                alert("Error inesperado");
                }
            });

        $.ajax({
            type : "GET",
            url : "/odontologos/",
            success: function(response){
            $.each(response, (i, odontologo) => {
                let option = '<option' + ' value=' + '\"' + odontologo.id + '\">' + odontologo.nombre +' '+ odontologo.apellido +'</option>';
                $('#odontologo').append(option);
            });
            },
            error : function(e) {
            alert("Error inesperado");
            }
        });




    function resetUploadForm(){
        document.querySelector('#fecha').value = "";
        document.querySelector('#odontologo').value = "";
        document.querySelector('#paciente').value = "";


    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});