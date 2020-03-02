package project;

import java.awt.Image;

public interface Boardgame {
    public boolean move(int i, int j); //ger true om draget gick bra, annars false
    public Image getStatus(int i, int j); // returnera innehåll på ruta (i,j)
    public String getMessage(); // returnera OK (eller liknande) eller felmeddelande avseende senaste drag
}
