package Servlet;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {
    
    //get date
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String entered;
    
    
    
    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {
        
        //tries to create a reader and read from log.txt
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xdark\\Documents\\NetBeansProjects\\ReadWrite\\src\\java\\textFile\\log.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            //while the line is not empty, add it to the string
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            
            //print the string created from the log file
            String everything = sb.toString();
            response.getWriter().write(everything);
            
            //tries to create a reader and read from writeFrom.txt
            try(BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\xdark\\Documents\\NetBeansProjects\\ReadWrite\\src\\java\\textFile\\writeFrom.txt"))) {
            StringBuilder s = new StringBuilder();
            String writeLine = b.readLine();

            //while the line is not empty, add it to the string
            while (writeLine != null) {
                s.append(writeLine);
                s.append("" + System.lineSeparator());
                writeLine = b.readLine();
            }
            
            //append the string created to the log file
            String allWrite = s.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\xdark\\Documents\\NetBeansProjects\\ReadWrite\\src\\java\\textFile\\log.txt", true));
            writer.append(' ');
            writer.append(dateFormat.format(date) + allWrite);

            writer.close();
        
        }
    
    }
    }


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
