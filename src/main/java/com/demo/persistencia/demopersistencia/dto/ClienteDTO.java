package com.demo.persistencia.demopersistencia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long cliente_id;
    private String nombre;
    private String direccion;
    private String nit;
}
