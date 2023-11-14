import database.EmfSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


import static database.ConsultarDepartamentos.leerDepartamentos;
import static database.ConsultarDepartamentosP.leerDepartamentosP;
import static database.ConsultarEmpleados.crearEmpleado;
import static database.ConsultarEmpleadosP.*;
import static database.ConsultarEmpleadosClase.leerEmps;

public class Main {
    //Contexto de persistencia haciendo uso del singleton
    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        //leerEmps(em);
        //leerDepartamentos(em);
        leerDepartamentosP(em);
        //modificarEmpleado(em);
        crearEmpleadoP(em);
        crearEmpleado(em);
        desconectar();
    }

    private static void desconectar() {
        em.close();
        emf.close();
    }


}
