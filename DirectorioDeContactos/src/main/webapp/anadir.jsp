<%@page import="Java.Metodos"%>
<%@include file= "Template/header.jsp" %>
<%
    ServletContext context= getServletContext();
    int id=Metodos.mostrarId(context);
%>
    <!-- Contenido de la pagina -->
        <div class="container-fluid">
            <!-- Titulo -->
            <div class=" justify-content-between mb-4">
                <center>                       
                <h1 style="color: black;"><strong>Directorio de contactos</strong></h1>
                </center>  
            </div>
            <!-- Formulario -->
            <div class="card" style=" border-radius: 2rem; box-shadow: 0px 20px 40px -30px #615145; color: black; background-color: white;" >
                <div class="card-body">
                    <div class="table-responsive">
                        <form action="SvGestionContacto" method="POST" >
                            <div>
                                <label for="validationCustom01" class="form-label">Id</label>
                                <input type="text" class="form-control" name="id" value="<%=id%>" readonly>
                            </div>
                            <div>
                                <label for="validationCustom02" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="validationCustom02" name="nombre" required>
                                </div>
                                <div>
                                  <label for="validationCustomUsername" class="form-label">Apellido</label>
                                    <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" name="apellido" required>
                                </div>
                                <div>
                                  <label for="validationCustom03" class="form-label">Correo</label>
                                  <input type="email" class="form-control" id="validationCustom03" name="correo" required>
                                </div>
                               <div>
                                  <label for="validationCustom03" class="form-label">Direccion</label>
                                  <input type="text" class="form-control" id="validationCustom03" name="direccion" required>
                                </div>
                                <div>
                                  <label for="validationCustom05" class="form-label">Celular</label>
                                  <input type="number" class="form-control" id="validationCustom05" name="celular" required>
                                </div>
                                   
                                <div class="col-md-12" style="margin-top:15px;">
                                    <center><button class="btn btn-primary" type="submit">Submit form</button></center>
                                </div>
                              </form>
                            </div>
                        </div>   
                    </div>

                </div>
                <br>
<%@include file= "Template/footer.jsp" %>
