package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Model2Servlet", urlPatterns = {"/procesar"})

public class Model2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre = request.getParameter("nombre");
        Integer edad = Integer.valueOf(request.getParameter("edad"));
        String localidad = request.getParameter("localidad");
        
        
        HashMap<String,Object> errores = new HashMap();
       
        if(nombre == null || nombre.length() == 0){
        //ERROR
            errores.put("nombre", "El nombre no puede ser vacio");
        }
        
        if(edad < 0 || edad > 101){
            errores.put("edad", "La edad ingresada es incorrecta");
        }
        
       // if(!"Rawson".equals(localidad) || !"Trelew".equals(localidad) || !"Gaiman".equals(localidad)){
       //     errores.put("localidad","Localidad ingresada incorrecta");
       // }
        
        //poner a dispocicion la variable al jsp
        request.setAttribute("nombre", nombre);
        request.setAttribute("edad", edad);
        request.setAttribute("localidad", localidad);
        
        if(errores.isEmpty()){
            //Forward a la pagina OK
            request.getRequestDispatcher("WEB-INF/jsp/datos_ok.jsp").forward(request, response);
        }
        else{
            //Forward al form con los errores
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("WEB-INF/jsp/form.jsp").forward(request, response);
        }
        
    }}