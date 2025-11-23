/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventorymanager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Adrian
 */
public class InventoryManagerTest {
    @Test
    void testInventarioNull() {
        InventoryManager invManager = new InventoryManager();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> invManager.addItem(null, 5)
        );
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }
    
    @Test
    void testCantidadInvalida() {
        InventoryManager invManager = new InventoryManager();
        Exception ex = assertThrows(
        IllegalArgumentException.class,
        () -> invManager.addItem("Mouse", -1)
        );
        assertEquals("La cantidad debe ser mayor que 0", ex.getMessage());
    }
    @Test
    void testCantidadMaxima() {
        InventoryManager invManager = new InventoryManager();
        Exception ex = assertThrows(
        IllegalArgumentException.class,
        () -> invManager.addItem("Mouse", 1001)
        );
        assertEquals("La cantidad máxima permitida es 1000", ex.getMessage());
    }
    
    @Test
    void testInventarioValido() {
        InventoryManager invManager = new InventoryManager();
        invManager.addItem("Laptop", 5);
        assertEquals(5, invManager.getStock("Laptop"));
    }
    
    @Test
    void testInventarioAcumularStock() {
        InventoryManager invManager = new InventoryManager();
        invManager.addItem("Monitor", 10);
        invManager.addItem("Monitor", 7);
        assertEquals(17, invManager.getStock("Monitor"));
    }
    
    @Test
    void testInventarioNombreInvalido() {
        InventoryManager invManager = new InventoryManager();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> invManager.addItem("R", 10)
        );
        assertEquals("El nombre del producto debe tener entre 2 y 50 caracteres", ex.getMessage());
    }
    
    //Nueva prueba
    @Test
    void testMain() {
        var out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        InventoryManager.main(null);

        assertEquals("Stock Laptop: 5", out.toString().trim());
    }
    
    //Nueva prueba
    @Test
    void testInventarioVacio() {
        InventoryManager invManager = new InventoryManager();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> invManager.addItem(" ", 5)
        );
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }
    
    //Nueva prueba
    @Test
    void testInventarioNombreMayor() {
        InventoryManager invManager = new InventoryManager();
        // Nombre de 51 caracteres
        String nombreLargo = "A".repeat(51);
        
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> invManager.addItem(nombreLargo, 10)
        );
        assertEquals("El nombre del producto debe tener entre 2 y 50 caracteres", ex.getMessage());
    }
}
