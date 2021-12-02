package com.fundamentals.mvcfundamentals.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacante {
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private double salario;
    private Integer destacado;
    private String imagen = "no-image.png";
    private String estatus;
    private  String detalles;
    private Categoria categoria;

    public static class Builder {
        private Vacante data;

        public Builder() {
            data = new Vacante();
        }

        public Builder withId(Long id){
            data.setId(id);
            return this;
        }

        public Builder withNombre(String nombre){
            data.setNombre(nombre);
            return this;
        }

       public Builder withDescripcion(String descripcion){
           data.setDescripcion(descripcion);
           return this;
       }
       public Builder withFecha(Date fecha){
           data.setFecha(fecha);
           return this;
       }

       public Builder withSalario(double salario){
           data.setSalario(salario);
           return this;
       }

       public Builder withDestacado(Integer destacado){
           data.setDestacado(destacado);
           return this;
       }

       public Builder withImagen(String imagen){
           data.setImagen(imagen);
           return this;
       }
       public Builder withCategoria(Categoria categoria){
           data.setCategoria(categoria);
           return this;
       }

        public Vacante build() {
            return data;
        }
    }
}
