<%@page import="Java.Metodos"%>
<%@page import="Java.Persistencia"%>
<%@page import="Java.Directorio"%>
<%@include file= "Template/header.jsp" %>
                    <% 
                     ServletContext context = getServletContext();
                     String termino=request.getParameter("termino");
                     String alert = request.getParameter("alert");
                     System.out.println(request.getParameter("alert"));
                     String tabla=Metodos.tabla(termino, context);


                     if (alert!=null){
                     
                      if(alert.equals("anadido")){
                     
                      %>
<script>
    $(document).ready(function () {
        anadido();
    });

</script>

<%
                        }else if(alert.equals("editado")){
                     
                      %>
<script>
    $(document).ready(function () {
        editado();
    });

</script>

<%
                        }  else if(alert.equals("ingreso")){
                     
                      %>
<script>
    $(document).ready(function () {
        ingreso();
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

                        <!-- Earnings (Monthly) Card Example -->
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

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Porcentaje de satisfacci�n
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

                        <!-- Pending Requests Card Example -->
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
                    <!-- DataTales Example -->
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
                                            <th>Direcci�n</th>
                                            <th>Telefono</th>
                                            <th>Correo</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%=tabla%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- Fin del contenido de la pagina-->


        </div>
        <!-- End of Content Wrapper -->
        <!-- modal ver -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <!-- Modal de contenedor principal -->
    <div class="modal-dialog">
        <!-- Modal Dialog: Contiene el contenido modal -->
        <div class="modal-content">
            <!-- Modal Content: Contenido del modal -->
            <div class="modal-header">
                <!-- Encabezado del modal -->
                <h5 class="modal-title" id="exampleModalLabel">Detalles del Libro</h5>
                <!-- T�tulo del modal -->
                <button class="close" type="button" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">�</span>
                    </button>
                <!-- Bot�n para cerrar el modal -->
            </div>
            <div class="modal-body">
                <!-- Cuerpo del modal -->
                <div id="libro-details">
                    <!-- Contenido din�mico: Aqu� se mostrar�n los detalles del libro -->
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
                <!-- T�tulo del modal -->
                <h5 class="modal-title" id="exampleModalLabel">Editar</h5>
                <!-- Bot�n para cerrar el modal -->
                 <button class="close" type="button" data-bs-dismiss="modal" aria-label="Close">
                        �
                    </button>
            </div>

            <div class="modal-body">
                    <!-- Formulario para editar -->
                    <div id="editar-details">
                        <!-- Contenido din�mico: Aqu� se mostrar�n los detalles a editar -->
                    </div>
            </div>
            <div class="modal-footer">
                 
            </div>
        </div>
    </div>
</div>        
    </div>
    <!-- End of Page Wrapper -->
    <!-- Scripts necesarios (jQuery) -->
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>

    <!-- Librerias sweet alert -->
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
        <script>
    $(document).ready(function () {
        // Al hacer clic en un elemento con el atributo data-bs-toggle="ver"
        $('[data-bs-toggle="ver"]').on('click', function () {
            // Obtener el t�tulo del libro desde el atributo data-nombre
            var id = $(this).data('nombre');
            // Realizar una solicitud AJAX para obtener detalles del libro por su t�tulo
            $.ajax({
                url: 'SvGestionContacto?id=' + id, // URL del servlet o recurso que maneja la solicitud
                method: 'GET',
                success: function (data) {
                    // �xito: Colocar los detalles del libro en el contenedor #libro-details
                    $('#libro-details').html(data);
                    // Mostrar el modal (exampleModal) una vez que se han cargado los detalles del libro
                    $('#exampleModal').modal('show');
                },
                error: function () {
                    console.log('Error al cargar los detalles del libro.');
                }
            });
        });
    });
   
    $(document).ready(function () {
        $('[data-bs-toggle="editar"]').on('click', function () {
            var id = $(this).data('nombre');
            $.ajax({
                url: 'SvGestiones2?id=' + id,
                method: 'GET',
                success: function (data) {
                    $('#editar-details').html(data);
                    $('#editarModal').modal('show'); // Muestra el modal una vez que se han cargado los detalles del libro
                },
                error: function () {
                    console.log('Error al cargar los detalles del libro.');
                }
            });
        });
    });
        // Repetir el mismo proceso para el bot�n de editar
    $(document).ready(function () {
        $('[data-bs-toggle="editar"]').on('click', function () {
            var id = $(this).data('nombre');
            $.ajax({
                url: 'SvGestiones?id=' + id,
                method: 'GET',
                success: function (data) {
                    $('#editar-details').html(data);
                    $('#editarModal').modal('show'); // Muestra el modal una vez que se han cargado los detalles del libro
                },
                error: function () {
                    console.log('Error al cargar los detalles del libro.');
                }
            });
        });
    });
    
    //ELIMINAR 
 // Seleccionar todos los elementos con la clase "deleteButton" y agregar un event listener a cada uno
    document.querySelectorAll(".deleteButton").forEach(function (button) {
        button.addEventListener("click", function () {
            // Obtener el t�tulo del libro desde el atributo "data-titulo"
            const id = this.getAttribute("data-titulo");

            // Crear un di�logo de confirmaci�n personalizado con SweetAlert2
            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
            });
            // Mostrar el di�logo de confirmaci�n
            swalWithBootstrapButtons.fire({
                title: '�Est�s seguro?',
                text: '�No podr�s revertir esto!',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'S�, borrarlo',
                cancelButtonText: 'No, cancelar ',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    // Redirige al servlet con el t�tulo como par�metro en la URL
                    window.location.href = "SvEliminarBuscar?id=" + encodeURIComponent(id);
                    // Mostrar un mensaje de cancelaci�n si el usuario decide no eliminar
                } else if (result.dismiss === Swal.DismissReason.cancel) {
                    swalWithBootstrapButtons.fire(
                            'Cancelado',
                            'Tu libro imaginario est� a salvo :)',
                            'error'
                            );
                }
            });
        });
    });
    // Definici�n de la funci�n 'a�adido()'
    // Definici�n de la funci�n 'a�adido()'
    function anadido() {
        // Utiliza la librer�a Swal para mostrar una notificaci�n de �xito
        Swal.fire({
            icon: 'success', // Icono de �xito
            title: 'A�adido exitosamente!', // T�tulo de la notificaci�n
            text: '�Puedes verlo en la pagina de gestionar!', // Texto de la notificaci�n
            showConfirmButton: false, // Nos muestra el bot�n de confirmaci�n
            timer: 1500 // Tiempo de duraci�n de la notificaci�n (en milisegundos)
        })
    }
       function editado() {
     Swal.fire({
            icon: 'success', // Icono de �xito
            title: 'Editado exitosamente!', // T�tulo de la notificaci�n
            text: '�Puedes verlo en la pagina de gestionar!', // Texto de la notificaci�n
            showConfirmButton: false, // Nos muestra el bot�n de confirmaci�n
            timer: 1500 // Tiempo de duraci�n de la notificaci�n (en milisegundos)
        })
    }
          function ingreso() {
     Swal.fire({
            icon: 'info', // Icono de �xito
            title: 'Editado exitosamente!', // T�tulo de la notificaci�n
            text: '�Puedes verlo en la pagina de gestionar!', // Texto de la notificaci�n
            showConfirmButton: false, // Nos muestra el bot�n de confirmaci�n
            timer: 1500 // Tiempo de duraci�n de la notificaci�n (en milisegundos)
        })
    }
    </script>
    
<%@include file= "Template/footer.jsp" %>
