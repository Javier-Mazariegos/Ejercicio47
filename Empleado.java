
class Empleado{
    private String nombre;
    private String dpi;
    private Double salario_base_hora;

    public Empleado(String nom, String dpi, Double salario)
    {
        this.nombre = nom;
        this.dpi = dpi;
        this.salario_base_hora = salario;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDPI()
    {
        return this.dpi;
    }

    public Double getSalario()
    {
        return this.salario_base_hora;
    }

    public void setNombre(String nom)
    {
        this.nombre = nom;
    }

    public void setDPI(String dpi)
    {
        this.dpi = dpi;
    }

    public void setSalrio(double salario)
    {
        this.salario_base_hora = salario;
    }
}   
