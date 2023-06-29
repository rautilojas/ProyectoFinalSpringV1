package org.lrojas.springframework.boot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="productos")
public class Producto {
    @Getter
    @Setter
    @Id
    @Column(name="idproductos")
    private Integer id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private Double precio;
    @Getter
    @Setter
    private Date fechaAlta;

    @Override
    public String toString() {
        return  "id =" + id +
                " | nombre ='" + nombre + '\'' +
                " | precio =" + precio +
                " | fechaAlta =" + fechaAlta +
                '}';
    }
}
