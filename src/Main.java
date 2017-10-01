import ui.Window;

/**
 * Главный класс приложения в нем прописана ф-ия
 * для запуска приложения
 * @author Балун Владимир
 */
public class Main {

    /**
     * Главаня функция приложения, с нее начинается запуск приложения
     */
    public static void main(String[] arg) {

        //Создаем окно и вызываем метод вывода его на экран
        Window window = new Window("Снежные войны", 1000, 600);
        window.showWindow();

    }

}
