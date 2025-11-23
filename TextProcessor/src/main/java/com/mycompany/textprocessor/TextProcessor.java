/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.textprocessor;

/**
 *
 * @author Adrian
 */
public class TextProcessor {
    
    public static void main(String[] args) {
        String texto = "   hola mundo   ";

        String resultado = TextProcessor.reverseAndCapitalize(texto);

        System.out.println("Resultado: " + resultado);
    }
    
    public static String reverseAndCapitalize(String input) {

        // Validación de null o vacío/solo espacios
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede ser nulo o vacío");
        }

        // Validación de longitud máxima
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // 1. Eliminar espacios al inicio y final
        String trimmed = input.trim();

        // 2. Invertir texto
        String reversed = new StringBuilder(trimmed).reverse().toString();

        // 3. Convertir a mayúsculas
        return reversed.toUpperCase();
    }
}
