<%@page import="Java.Metodos"%>
<%@page import="Java.Persistencia"%>
<%@page import="Java.Directorio"%>
<%@include file= "Template/header.jsp" %>
<% 
    ServletContext context = getServletContext();
    String termino=request.getParameter("termino");//Recibe termino de busqueda para listar
    String alert = request.getParameter("alert"); //Recibe alerta para sweet alert o toastr
    String tabla=Metodos.tabla(termino, context); //Se listan los contactos
     if (alert!=null){//Prevenir errores
        if(alert.equals("anadido")){ //Caso de añadido exitoso
%>
<script>
    $(document).ready(function () {
        anadido();
    });
</script>
<%
        }else if(alert.equals("editado")){//Caso de editar
                     
%>
<script>
    $(document).ready(function () {
        editado();
    });
</script>
<%
        }  else if(alert.equals("ingreso")){//Caso de ingresar de nuevo
                     
%>
<script>
    $(document).ready(function () {
        ingreso();
    });
</script>
<%
        }else if(alert.equals("nomRepetido")){//Caso nombre repetido                     
%>
<script>
    $(document).ready(function () {
        nomRep();
    });

</script>

<%
    }else if(alert.equals("eliminado")){//Caso eliminado
%>
<script>
    $(document).ready(function () {
        eliminado();
    });

</script>

<%
        }
    }
%>
    <!-- Contenido de la pagina -->
        <div class="container-fluid">
            <!-- Titulo -->
            <div class=" justify-content-between mb-4">
                <center>                       
                    <h1 style="color: black;"><strong>Directorio de contactos</strong></h1>
                </center>  
            </div>

            <!-- Content Row -->
            <div class="row">

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Contactos gestionados </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">40,000 </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Card -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                        Empresas gestionadas</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">200</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Card -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Porcentaje de satisfacción
                                    </div>
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-auto">
                                            <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">100%</div>
                                        </div>
                                        <div class="col">
                                            <div class="progress progress-sm mr-2">
                                                <div class="progress-bar bg-info" role="progressbar"
                                                     style="width: 100%" aria-valuenow="100" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Card -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                        Conversaciones gestionadas</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">180.000</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-comments fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- tabla -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Listando contactos en preorden</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable_wrapper" width="100%" cellspacing="0" >
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Dirección</th>
                                    <th>Telefono</th>
                                    <th>Correo</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%=tabla%> <!-- Se llama variable creada antes -->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


        <!-- MODALES -->   


        <!-- modal ver -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <!-- Modal de contenedor principal -->
            <div class="modal-dialog">
                <!-- Modal Dialog: Contiene el contenido modal -->
                <div class="modal-content">
                    <!-- Modal Content: Contenido del modal -->
                    <div class="modal-header">
                        <!-- Encabezado del modal -->
                        <h5 class="modal-title" id="exampleModalLabel">Detalles de contacto</h5>
                        <!-- Título del modal -->
                        <button class="close" type="button" data-bs-dismiss="modal" aria-label="Close"> <span aria-hidden="true">×</span> </button> <!-- Botón para cerrar el modal -->
                    </div>

                    <div class="modal-body">
                        <!-- Cuerpo del modal -->
                        <center><img src="https://img.freepik.com/vector-premium/icono-circulo-usuario-anonimo-ilustracion-vector-estilo-plano-sombra_520826-1931.jpg" style="width:70%;"></center>
                        <div id="contacto-details">
                            <!-- Contenido dinámico: Aquí se mostrarán los detalles del Contacto -->
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- modal editar -->
        <div class="modal fade" id="editarModal" tabindex="-1" aria-labelledby="editarModalLabel"aria-hidden="true">
            <!-- Modal Dialog: Contiene el contenido modal -->
            <div class="modal-dialog">
                <!-- Modal Content: Contenido del modal -->
                <div class="modal-content">
                    <!-- Encabezado del modal -->
                    <div class="modal-header">
                        <!-- Título del modal -->
                        <h5 class="modal-title" id="exampleModalLabel">Editar</h5>
                        <!-- Botón para cerrar el modal -->
                        <button class="close" type="button" data-bs-dismiss="modal" aria-label="Close"> × </button>
                    </div>
                    <div class="modal-body">
                        <!-- Formulario para editar -->
                        <div id="editar-details">
                            <!-- Contenido dinámico: Aquí se mostrarán los detalles a editar -->
                        </div>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>   
        
        <!-- Boton Scroll para arriba-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Scripts necesarios (jQuery) -->
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>

        <!-- Librerias sweet alert/ Toastr / Bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>  
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

        <script>
    //Gestionar opcion VER
    $(document).ready(function () {
        // Al hacer clic en un elemento con el atributo data-bs-toggle="ver"
        $('[data-bs-toggle="ver"]').on('click', function () {
            // Obtener el id del contacto desde el atributo data-nombre
            var id = $(this).data('nombre');
            // Realizar una solicitud AJAX para obtener detalles del contacto por su id
            $.ajax({
                url: 'SvVerAnadir?id=' + id, // URL del servlet o recurso que maneja la solicitud
                method: 'GET',
                success: function (data) {
                    // Éxito: Colocar los detalles del contacto en el contenedor #contacto-details
                    $('#contacto-details').html(data);
                    // Mostrar el modal (exampleModal) una vez que se han cargado los detalles del contacto
                            $('#exampleModal').modal('show');
                        },
                        error: function () {
                            console.log('Error al cargar los detalles del contacto.');
                        }
                    });
                });
            });
        //Gestionar opcion EDITAR    
            $(document).ready(function () {
                $('[data-bs-toggle="editar"]').on('click', function () {
                    var id = $(this).data('nombre');
                    $.ajax({
                        url: 'SvEditar?id=' + id,
                        method: 'GET',
                        success: function (data) {
                            $('#editar-details').html(data);
                            $('#editarModal').modal('show'); // Muestra el modal una vez que se han cargado los detalles del contacto
                        },
                        error: function () {
                            console.log('Error al cargar los detalles del contacto.');
                        }
                    });
                });
            });

            //ELIMINAR 
            // Seleccionar todos los elementos con la clase "deleteButton" y agregar un event listener a cada uno
            document.querySelectorAll(".deleteButton").forEach(function (button) {
                button.addEventListener("click", function () {
                    // Obtener el título del contacto desde el atributo "data-titulo"
                    const id = this.getAttribute("data-titulo");

                    // Crear un diálogo de confirmación personalizado con SweetAlert2
                    const swalWithBootstrapButtons = Swal.mixin({
                        customClass: {
                            confirmButton: 'btn btn-success',
                            cancelButton: 'btn btn-danger'
                        },
                        buttonsStyling: false
                    });
                    // Mostrar el diálogo de confirmación
                    swalWithBootstrapButtons.fire({
                        title: '¿Estás seguro?',
                        text: '¡No podrás revertir esto!',
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonText: 'Sí, borrarlo',
                        cancelButtonText: 'No, cancelar ',
                        reverseButtons: true
                    }).then((result) => {
                        if (result.isConfirmed) {
                            // Redirige al servlet con el id como parámetro en la URL
                            window.location.href = "SvEliminarBuscar?id=" + encodeURIComponent(id);
                            // Mostrar un mensaje de cancelación si el usuario decide no eliminar
                        } else if (result.dismiss === Swal.DismissReason.cancel) {
                            swalWithBootstrapButtons.fire(
                                    'Cancelado',
                                    'Tu contacto imaginario está a salvo :)',
                                    'error'
                                    );
                        }
                    });
                });
            });
            // Definición de la función 'añadido()'
            function anadido() {
                // Utiliza la librería Swal para mostrar una notificación de éxito
                Swal.fire({
                    icon: 'success', // Icono de éxito
                    title: 'Añadido exitosamente!', // Título de la notificación
                    text: '¡Puedes verlo en la pagina de gestionar!', // Texto de la notificación
                    showConfirmButton: false, // No muestra el botón de confirmación
                    timer: 1500 // Tiempo de duración de la notificación (en milisegundos)
                })
            }
            function editado() {
                Swal.fire({
                    icon: 'warning', // Icono de éxito
                    title: 'Editado exitosamente!', // Título de la notificación
                    text: '¡Revisalo en la tabla!', // Texto de la notificación
                    showConfirmButton: false, // No muestra el botón de confirmación
                    timer: 1500 // Tiempo de duración de la notificación (en milisegundos)
                })
            }
            function ingreso() {
                Swal.fire({
                    icon: 'info', // Icono de éxito
                    title: 'Bienvenido!', // Título de la notificación
                    text: '¡Nos alegra verte de nuevo ;) !', // Texto de la notificación
                    showConfirmButton: false, // No muestra el botón de confirmación
                    timer: 1500 // Tiempo de duración de la notificación (en milisegundos)
                })
            }
            function nomRep() {
                toastr.options = {
                    "closeButton": false,
                    "debug": false,
                    "newestOnTop": false,
                    "progressBar": false,
                    "positionClass": "toast-top-center",
                    "preventDuplicates": false,
                    "onclick": null,
                    "showDuration": "300",
                    "hideDuration": "1000",
                    "timeOut": "3000",
                    "extendedTimeOut": "1000",
                    "showEasing": "swing",
                    "hideEasing": "linear",
                    "showMethod": "fadeIn",
                    "hideMethod": "fadeOut"
                }
                toastr["error"]("El nombre ingresado ya existe, intenta con otro!", "Error");
            }
            function eliminado() {
                Swal.fire({
                    icon: 'success', // Icono de éxito
                    title: 'Eliminado exitosamente!', // Título de la notificación
                    text: '¡Puedes verlo en la tabla!', // Texto de la notificación
                    showConfirmButton: false, // Nos muestra el botón de confirmación
                    timer: 1500 // Tiempo de duración de la notificación (en milisegundos)
                })
            }
</script>

<%@include file= "Template/footer.jsp" %>
