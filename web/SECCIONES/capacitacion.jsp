<%-- 
    Document   : capacitacion
    Created on : Mar 22, 2023, 6:47:22 PM
    Author     : jarod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <title>Capacitación</title>
    </head>
    <body class="container">
        <nav>
            <%@include file="COMPONENTES/navbar.jsp" %>
        </nav>
        
        <main>
            
            <h2 class="text-center py-3">Crear Capacitación</h2>
                
                <form action="" method="POST">

                    <div class="form-floating mb-3">
                        <input type="text" required class="form-control" placeholder="Rut Cliente" name="rut">
                        <label for="rutCliente">RUT Cliente:</label>
                    </div>
    
                    <div class="form-floating mb-3">
                        <input type="date" class="form-control" placeholder="Fecha" id="hora" name="fecha">
                        <label for="fecha">Fecha:</label>
                    </div>
    
                    <div class="form-floating mb-3">
                        <input type="text" maxlength="5" class="form-control" placeholder="Hora" id="hora" name="hora">
                        <label for="hora">Hora:</label>
                    </div>
    
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" required minlength="10" maxlength="50" placeholder="Lugar" id="lugar" name="lugar">
                        <label for="lugar">Lugar:</label>
                    </div>
    
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" maxlength="70" placeholder="Duración" id="duracion" name="duracion">
                        <label for="duracion">Duración:</label>
                    </div>
    
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" required placeholder="Cantidad de Asistentes" id="cantAsistentes" name="cantAsistentes">
                        <label for="cantAsistentes">Cantidad de Asistentes:</label>
                    </div>
    
                   
                    <input type="submit" value="Crear Capacitación" class="btn btn-primary">
                      
                </form>
        </main>

                
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>

    <footer class="py-3">
        <%@include file="COMPONENTES/footer.jsp" %>
    </footer>
</html>
