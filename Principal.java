import java.util.Scanner;
import java.util.LinkedList;

public class Principal {
    public static Scanner reader = new Scanner(System.in);
    public static LinkedList<Empleado> empleados = new LinkedList<Empleado>();
    public static LinkedList<Double> salarios = new LinkedList<Double>();
    public static Empleado empleado;
    public static String nombre;
    public static String dpi;
    public static Double salario_base_hora;
    public static int opcion = 0;
    public static Double horas_trabajadas;
    public static String seguir;

    public static double calculoSalrio(Double salario, Double horas)
    {
        if(horas >= 0 && horas <= 40)
        {
            return (horas*salario);
        }
        else if(horas > 40)
        {
            horas_trabajadas = horas - 40;
            return ((40*salario)+(salario*1.5*horas_trabajadas));
        }
        else
        {
            return 0.0;
        }
    }


    public static void control() //Control de empleados, agregar, modificar y eliminar.
    {
        try{
            opcion = 0;
            System.out.print("\n Que operacion desea realizar?\n\n 1 = Agregar empleado \n 2 = Modificar empleado \n 3 = Eliminar empleado \n\n Ingrese una opcion: ");
            opcion = reader.nextInt();
            reader.nextLine();
            if(opcion == 1) //Agergar empleados
            {
                System.out.print("\nIngrese el nombre del empleado: ");
                nombre = reader.nextLine();
                System.out.print("Ingrese el DPI del empleado: ");
                dpi = reader.nextLine();
                do{
                    System.out.print("Ingrese el salrio base por hora del empleado: ");
                    salario_base_hora = reader.nextDouble();
                    if(salario_base_hora < 8.0)
                    {
                        System.out.println("Error, el salario base por hora no puede ser menor a $8");
                    }
                }
                while(salario_base_hora < 8.0);
                empleado = new Empleado(nombre, dpi, salario_base_hora);
                empleados.add(empleado);
                System.out.println("\n ---------------Empleado agregado exitosamente----------------");
            }
            else if(opcion == 2) //Modificar empleados
            {
                System.out.println("\nListado de empleados: ");
                if(empleados.size() == 0)
                {
                    System.out.println("\nNo hay ningun empleado registrado");
                    opcion = 0;
                }
                else{
                    opcion = 0;
                    for(int i=0; i<empleados.size(); i++)
                    {
                        empleado = empleados.get(i);
                        System.out.println((i+1) + ": "+empleado.getNombre());
                    }
                    System.out.print("\nIngrese el numero del empleado que desea modificar: ");
                    opcion = reader.nextInt();
                    empleado = empleados.get(opcion-1);
                    opcion =0;
                    System.out.println("\nQue campo desea modificar? ");
                    System.out.print("\n 1 = DPI del empleado \n 2 = Salario base por Hora \n\n Ingrese una opcion: ");
                    opcion = reader.nextInt();
                    reader.nextLine();
                    if(opcion == 1)
                    {
                        System.out.print("\nIngrese el nuevo DPI del empleado: ");
                        dpi = reader.nextLine();
                        empleado.setDPI(dpi);
    
                        System.out.print("\n-----------Modificacion exitosa-----------\n");
                        System.out.print("Nombre:" +empleado.getNombre()+ "\nDPI:"+empleado.getDPI()+ "\nSalario base por Hora:" + empleado.getSalario());
                        System.out.print("\n--------------------------------------------\n");
                    }
                    else if(opcion == 2)
                    {
                        salario_base_hora =0.0;
                        do{
                            System.out.print("\nIngrese el nuevo salrio base por hora del empleado: ");
                            salario_base_hora = reader.nextDouble();
                            if(salario_base_hora < 8.0)
                            {
                                System.out.println("Error, el salario base por hora no puede ser menor a $8");
                            }
                        }
                        while(salario_base_hora < 8.0);
                        empleado.setSalrio(salario_base_hora);

                        System.out.print("\n-----------Modificacion exitosa-----------\n");
                        System.out.print("Nombre:" +empleado.getNombre()+ "\nDPI:"+empleado.getDPI()+ "\nSalario base por Hora:" + empleado.getSalario());
                        System.out.print("\n--------------------------------------------\n");
                    }
                }
            }
            else if(opcion == 3) //eliminar empleados
            {
                try
                {
                    System.out.println("\nListado de empleados: ");
                    if(empleados.size() == 0)
                    {
                        System.out.println("\nNo hay ningun empleado registrado");
                        opcion = 0;
                    }
                    else{
                        opcion = 0;
                        for(int i=0; i<empleados.size(); i++)
                        {
                            empleado = empleados.get(i);
                            System.out.println((i+1) + ": "+empleado.getNombre());
                        }
                        System.out.print("\nIngrese el numero del empleado que desea eliminar: ");
                        opcion = reader.nextInt();
                        opcion = opcion - 1;
                        empleados.remove(opcion);
                        System.out.println("\n ---------------Empleado eliminado exitosamente----------------");
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
            else
            {
                System.out.println("Error, la opcion ingresada no existe");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } //fin control de empleados 




    public static void salario()//calculo de salarios 
    {
        try{
            if(empleados.size() == 0)
            {
                System.out.println("\nNo hay ningun empleado registrado");
            }
            else{
                horas_trabajadas =0.0;
                opcion = 0;
                System.out.print("\n 1 = Calcular el salrio a pagar de un empleado \n 2 = Calcular el salrio a pagar de todos los empleados \n\n Ingrese una opcion: ");
                opcion = reader.nextInt();
                reader.nextLine();
                if(opcion == 1)
                {
                    System.out.println("\nListado de empleados: ");
                    for(int i=0; i<empleados.size(); i++)
                    {
                        empleado = empleados.get(i);
                        System.out.println((i+1) + ": "+empleado.getNombre());
                    }
                    System.out.print("\nIngrese el numero del empleado que desea calcular el salario a pagar: ");
                    opcion = reader.nextInt();
                    empleado = empleados.get(opcion-1);
                    System.out.print("\nIngrese el numero de horas trabajadas de " + empleado.getNombre() + ": ");
                    horas_trabajadas = reader.nextDouble();
                    if(horas_trabajadas > 60.0)
                    {
                        System.out.print("\nNo se puede reportar mas de 60 horas laboradas, unicamente se tomaran en cuenta las 60 horas");
                        horas_trabajadas = 60.0;
                    }
                    reader.nextLine();
                    System.out.println("\nEl salario a pagar del empleado " + empleado.getNombre() + " es: $"+ calculoSalrio(empleado.getSalario(), horas_trabajadas));
                }
                else if(opcion == 2)
                {
                    salarios.clear();
                    for(opcion=0; opcion<empleados.size(); opcion++)
                    {
                        empleado = empleados.get(opcion);
                        System.out.print("Ingrese el numero de horas trabajadas de " + empleado.getNombre() + ": ");
                        horas_trabajadas = reader.nextDouble();
                        if(horas_trabajadas > 60.0)
                        {
                        System.out.println("\nNo se puede reportar mas de 60 horas laboradas, unicamente se tomaran en cuenta las 60 horas");
                        horas_trabajadas = 60.0;
                        }
                        reader.nextLine();
                        salarios.add(calculoSalrio(empleado.getSalario(), horas_trabajadas));
                    }
                    
                    salario_base_hora =0.0;
                    opcion =0;
                    System.out.println("\n-----------------Salrios----------------------------");
                    for(opcion =0; opcion<salarios.size(); opcion++)
                    {
                        empleado = empleados.get(opcion);
                        System.out.println("\nEl salario a pagar del empleado " + empleado.getNombre() + " es: $"+ salarios.get(opcion));
                        salario_base_hora = salario_base_hora + salarios.get(opcion);
                    }

                    System.out.println("\nEl total de salarios a pagar es: " + salario_base_hora);
                    System.out.println("\n----------------------------------------------------");
                }
                else
                {
                    System.out.println("Error, la opcion ingresada no existe");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(final String[] args) {
        
        while(opcion != 3)
        {
            try{
                opcion = 0;
                System.out.println("\nBienvenido al programa que lleva el control y registro de empleados");
                System.out.print("\n 1 = Control de empleados \n 2 = Calculo de salario a pagar \n 3 = Salir \n\n Ingrese una opcion: ");
                opcion = reader.nextInt();
                if(opcion == 1)
                {
                    control();
                }
                else if(opcion == 2)
                {
                    salario();
                }
                else if(opcion == 3)
                {
                    opcion = 3;
                }
                else
                {
                    System.out.println("\nOpcion " + opcion + " no existe\n");
                }
            }
            catch(Exception ex)
            {
                System.out.println("");
            }
        }
     }
}
