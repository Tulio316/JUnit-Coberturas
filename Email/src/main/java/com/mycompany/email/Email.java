/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.email;

/**
 *
 * @author Adrian
 */
public class Email {

    public static void main(String[] args) {
        System.out.println(Email.isValidEmail("cliente123@tienda.com"));
    }
    public static boolean isValidEmail(String email) {

        // 1. Validación de nulo o vacío (Escenario 1)
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // 2. Longitud mínima y máxima RFC
        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        // ==========================================================
        //      REGEX PARA VALIDAR CORREO (PARTE LOCAL + DOMINIO)
        // ==========================================================
        //
        // Parte local:
        // - Letras/números/._-
        // - No inicia con punto
        // - No termina con punto
        // - No contiene ".."
        //
        // Dominio:
        // - Debe contener al menos un punto
        // - Al menos 2 caracteres antes del punto
        // - Extensión mínimo 2 caracteres
        //
        // Regex explicado:
        // ^[A-Za-z0-9_-]+(\.[A-Za-z0-9_-]+)*    → parte local sin iniciar/terminar con punto y sin doble punto
        // @                                     → arroba obligatoria
        // [A-Za-z0-9-]{2,}                      → dominio mínimo 2 chars
        // \.[A-Za-z]{2,}$                       → extensión mínimo 2 letras
        //
        // ==========================================================
        String emailRegex
                = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" // parte local sin puntos al inicio/fin ni dobles puntos
                + "[A-Za-z0-9-]{2,}" // dominio mínimo 2 caracteres
                + "\\.[A-Za-z]{2,}$";                    // extensión mínimo 2 letras

        return email.matches(emailRegex);
    }
}
