/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventorymanager;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adrian
 */
public class InventoryManager {

    public static void main(String[] args) {
        // Ejemplo de prueba manual
        InventoryManager inv = new InventoryManager();
        inv.addItem("Laptop", 5);
        System.out.println("Stock Laptop: " + inv.getStock("Laptop"));
    }
    private Map<String, Integer> inventory = new HashMap<>();
    public void addItem(String item, int quantity) {
    // Validar nombre nulo o vacío
    if (item == null || item.trim().isEmpty()) {
    throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
    }
    // Validar longitud del nombre (2–50)
    if (item.length() < 2 || item.length() > 50) {
    throw new IllegalArgumentException("El nombre del producto debe tener entre 2 y 50 caracteres");
    }
    // Validar cantidad mínima
    if (quantity <= 0) {
    throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
    }
    // Validar cantidad máxima
    if (quantity > 1000) {
    throw new IllegalArgumentException("La cantidad máxima permitida es 1000");
    }
    // Agregar o sumar stock
    inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }
    public int getStock(String item) {
    return inventory.getOrDefault(item, 0);
    }

}
