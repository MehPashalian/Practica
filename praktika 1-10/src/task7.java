import javax.swing.*;
import java.awt.*;
public class task7 {


    public class VectorDrinkGlass extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Настройки
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2)); // Уменьшено значение для тонких линий

            // Рисуем верхнюю часть бокала (чаша)
            g2d.drawLine(100, 50, 300, 50);
            g2d.drawLine(105, 90, 293, 90);// Чаша бокала

            // Рисуем стенки бокала (сужение)
            g2d.drawLine(100, 50, 140, 250); // Левый бок
            g2d.drawLine(300, 50, 260, 250); // Правый бок

            // Рисуем дно бокала, соответствующее сужению боков
            g2d.drawLine(140, 250, 260, 250); // Дно бокала

            // Жидкость теперь без цвета (прозрачная)
            // Рисуем пузырьки
            g2d.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i < 20; i++) { // Увеличено количество пузырьков
                int bubbleX = 140 + (int) (Math.random() * 120);
                int bubbleY = 90 + (int) (Math.random() * 100);
                g2d.fillOval(bubbleX, bubbleY, 5, 5); // Пузырьки
            }

            // Рисуем соломинку по диагонали
            g2d.setStroke(new BasicStroke(1)); // Уменьшаем толщину соломинки
            g2d.setColor(Color.BLACK);
            g2d.drawLine(220, 30, 190, 250); // Диагональная линия (левая)
            g2d.drawLine(225, 30, 195, 250); // Диагональная линия (правая)

            // Рисуем ножку бокала из двух длинных линий, смещённой влево
            g2d.setStroke(new BasicStroke(6)); // Толщина линий ножки
            g2d.drawLine(200, 250, 200, 350); // Левый сегмент ножки (сместили влево)
            g2d.drawLine(200, 350, 210, 350); // Правый сегмент ножки
            g2d.drawLine(210, 350, 210, 250); // Соединение с бокалом

            // Рисуем основание бокала
            g2d.fillOval(190, 350, 30, 5); // Основание
        }

        public void main(String[] args) {
            JFrame frame = new JFrame("Векторный бокал с напитком");
            VectorDrinkGlass panel = new VectorDrinkGlass();

            frame.add(panel);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

}
