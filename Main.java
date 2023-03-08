
import java.awt.*;
import java.util.*;
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    misLineas ventana = new misLineas();
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

class misLineas extends JFrame {
  public misLineas() {
    Toolkit miPantalla = Toolkit.getDefaultToolkit();
    this.setTitle("Ejercicio 2");
    this.setBounds(0, 0, 300, 300);
    this.setLocationRelativeTo(null);
    DrawnLines hoja = new DrawnLines();
    this.add(hoja);
  }
}

class DrawnLines extends JPanel {
  float misLineas = Float.parseFloat(JOptionPane.showInputDialog("Cuantas lineas quieres dibujar?"));

  public void paintComponent(Graphics g) {
    int maxX = g.getClipBounds().width;
    int maxY = g.getClipBounds().height;

    float x1, y1, x2, y2, x3, y3, x4, y4, mitadX, mitadY, auxX, auxY;

    x1 = 0;
    y1 = 0;
    x2 = maxX - 1;
    y2 = maxY - 1;
    x3 = maxX / (misLineas * 2);
    y3 = maxY / (misLineas * 2);
    mitadX = maxX / 2;
    mitadY = maxY / 2;
    x4 = x3;
    y4 = y3;
    auxY = y2;
    auxX = x3;

    g.drawLine((int) mitadX, (int) y1, (int) mitadX, (int) y2);
    g.drawLine((int) x1, (int) mitadY, (int) x2, (int) mitadY);

    for (int i = 1; i <= misLineas; i++) {
      g.drawLine((int) mitadX, (int) y1, ((int) mitadX - (int) x3), (int) mitadY);
      g.drawLine((int) mitadX, (int) y1, ((int) mitadX + (int) x3), (int) mitadY);
      x3 += x4;
      y1 += y4;
      g.drawLine((int) mitadX, (int) auxY, ((int) mitadX - (int) auxX), (int) mitadY);
      g.drawLine((int) mitadX, (int) auxY, ((int) mitadX + (int) auxX), (int) mitadY);

      auxY -= y4;
      auxX += x4;

    }

  }
}
