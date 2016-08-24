<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <c:if test="${not empty errores}">
            <div class="error">
                Error al proceder el formulario
                <ul>
                <c:forEach var="item" items="errores">
                    <li> ${item}</li> 
                </c:forEach>
                </ul>
            </div>
        </c:if>
        
        <form action="procesar" method="POST">
            <fieldset>
                <legend>Formulario</legend>
                <h1>Nombre: </h1> <input type="text" name="nombre" id="nombre"/>
                
                <h1>Edad: </h1> <input type="number" name="edad" id="edad"/>
                
                <h1>Localidad: </h1> 
                <select name="localidad"> 
                        <option id="localidad" value="Rawson"> Rawson</option> 
                        <option id="localidad" value="Trelew"> Trelew</option> 
                        <option id="localidad" value="Gaiman"> Gaiman</option> 
                </select>
                <input type="submit" name="enviar">Enviar</input>
            </fieldset>
        </form>
    </body>
</html>
