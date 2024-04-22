public class Usuario {
    private String nombre;
    private boolean esResponsable;

    public Usuario(String nombre, boolean esResponsable) {
        this.nombre = nombre;
        this.esResponsable = esResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esResponsable() {
        return esResponsable;
    }
}