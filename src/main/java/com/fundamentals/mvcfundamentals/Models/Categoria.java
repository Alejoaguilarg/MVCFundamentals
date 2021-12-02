package com.fundamentals.mvcfundamentals.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private Long id;
    private String nombre;
    private String descripcion;

    public static class Builder {
        private Categoria data;

        public Builder() {
            data = new Categoria();
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

        public Categoria build() {
            return data;
        }
    }

}

