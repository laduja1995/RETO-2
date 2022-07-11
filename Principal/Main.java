
package Principal;
import Vistas.*;
import Modelo.*;


public class Main {

   
    public static void main(String[] args) {
        
        Conexion conexionDB = new Conexion();
        conexionDB.getConnection();
        
        Login login_usuario = new  Login ();
        login_usuario.setVisible(true);
        
        UserMenu userMenu = new UserMenu();
        userMenu.setVisible(true);
      
    }
    
}
 