package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BienvenidaServlet", urlPatterns = {"/hola"})
public class BienvenidaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String miNombre = request.getParameter("nombre");
        HashMap<String,Object> errores = new HashMap();
       
        if(errores.isEmpty()){
            //Forward a la pagina OK
            request.getRequestDispatcher("WEB-INF/jsp/datos_ok.jsp").forward(request, response);
        }
        else{
            //Forward al form con los errores
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("WEB-INF/jsp/form.jsp").forward(request, response);
        }
        
        if(miNombre == null || miNombre.length() == 0){
        //ERROR
        errores.put("nombre", "El nombre no puede ser vacio");
        }
        
        //poner a dispocicion la variable al jsp
        request.setAttribute("nombre", miNombre);
        
        //redirijir al jsp.asdasd
        request.getRequestDispatcher("WEB-INF/jsp/hola.jsp").forward(request, response);
        
        
    }
}
    

    