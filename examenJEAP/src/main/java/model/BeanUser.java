package model;

public class BeanUser {

    private long id;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String sexo;
    private String estado_nac;
    private String fecha_nac;
    private String curp;

    public BeanUser() {
    }

    public BeanUser(long id, String nombre, String apellido_p, String apellido_m, String sexo, String estado_nac, String fecha_nac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.sexo = sexo;
        this.estado_nac = estado_nac;
        this.fecha_nac = fecha_nac;
        this.curp = curp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_nac() {
        return estado_nac;
    }

    public void setEstado_nac(String estado_nac) {
        this.estado_nac = estado_nac;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "BeanUser{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido_p='" + apellido_p + '\'' +
                ", apellido_m='" + apellido_m + '\'' +
                ", sexo='" + sexo + '\'' +
                ", estado_nac='" + estado_nac + '\'' +
                ", fecha_nac='" + fecha_nac + '\'' +
                ", curp='" + curp + '\'' +
                '}';
    }
}
