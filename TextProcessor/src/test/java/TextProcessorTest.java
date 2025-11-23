/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textprocessor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Adrian
 */
public class TextProcessorTest {
    @Test
    void testTextoNull() {
        TextProcessor tp = new TextProcessor();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> tp.reverseAndCapitalize(null)
        );
        assertEquals("El texto no puede ser nulo o vacío", ex.getMessage());
    }
    
    @Test
    void testTextoSoloEspacios() {
        TextProcessor tp = new TextProcessor();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> tp.reverseAndCapitalize("     ")
        );
        assertEquals("El texto no puede ser nulo o vacío", ex.getMessage());
    }
    
    @Test
    void testTextoExcedeLimite() {
        TextProcessor tp = new TextProcessor();
        String largo = "a".repeat(1001);

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> tp.reverseAndCapitalize(largo)
        );

        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }
    
    @Test
    void testInversionCorrecta() {
        TextProcessor tp = new TextProcessor();
        String resultado = tp.reverseAndCapitalize("abc");
        assertEquals("CBA", resultado);
    }

    
    @Test
    void testTrimYTransformacion() {
        TextProcessor tp = new TextProcessor();
        String resultado = tp.reverseAndCapitalize("   mundo ");
        assertEquals("ODNUM", resultado);  // "mundo" → reverse → "odnum" → upper
    }
    
    @Test
    void testMain() {
        var out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        TextProcessor.main(null);

        assertEquals("Resultado: ODNUM ALOH", out.toString().trim());
    }
}
