Использование дженериков представлено в моем проекте:
Класс GamePanel
В нем я использовал типизированые типы для списков объектов классов: Bullet, Enemy, PowerUp, Explosion, Text:

...
public static ArrayList<Bullet> bullets; // массив пуль
public static ArrayList<Enemy> enemies; // массив врагов
public static ArrayList<PowerUp> powerUps; //массив припасов-улучшений
public static ArrayList<Explosion> explosions;
public static ArrayList<Text> texts
...

public void run(){
...
bullets = new ArrayList<Bullet>(); // инициализация листа пуль

enemies = new ArrayList<Enemy>(); // инициализация листа врагов

powerUps = new ArrayList<PowerUp>(); // инициализация листа улучшений

explosions = new ArrayList<Explosion>(); // инициализация листа взрывов

texts = new ArrayList<Text>();
...
}