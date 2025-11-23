/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.email;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Adrian
 */
public class EmailTest {
    @Test
    void testEmailNull() {
        Email email = new Email();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> email.isValidEmail(null)
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    void testEmailVacio() {
        Email email = new Email();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> email.isValidEmail(" ")
        );
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    void testDominioInvalido() {
        Email email = new Email();
        assertFalse(email.isValidEmail("usuario@com"));
    }

    @Test
    void testEmailTamano() {
        Email email = new Email();
        assertFalse(email.isValidEmail("asdfs"));
    }

    @Test
    void testEmailValido() {
        Email email = new Email();
        assertTrue(email.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    void testExtensionInvalido() {
        Email email = new Email();
        assertFalse(email.isValidEmail("cliente123@tienda.c"));
    }
    //Nuevo Test
    @Test
    void testMain() {
        var out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        Email.main(null);

        assertEquals("true", out.toString().trim());
    }
    //Nuevo Test
    @Test
    void testEmailTamanoMayor() {
        Email email = new Email();

        // 246 + 9 = 255 (mayor a 254)
        String largo = "a".repeat(255);

        assertFalse(email.isValidEmail(largo));
    }
}
