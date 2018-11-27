package ru.job4j.pseudo;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 23.11.18
 */
public class Paint {

    /**
     * Метод выводит псевдографику в консоль.
     * @param shape  фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Метод main.
     * @param args  args.
     */
    public static void main(String[] args) {
    Paint paint = new Paint();
    paint.draw(new Square());
    paint.draw(new Triangle());
    }
}
