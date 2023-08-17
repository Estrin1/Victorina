import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Toy> spisok = new ArrayList<>();
        spisok.add(new Toy(1, "машинка", 2));
        spisok.add(new Toy(2, "Мячик", 3));
        spisok.add(new Toy(3, "Сигареты", 1));
        spisok.add(new Toy(4, "Танк", 5));
        spisok.add(new Toy(5, "Кукла", 3));

        System.out.println(spisok);

        Log_rounds(spisok);

//реализовать выбор игрушки по весу. предпочтение в выигрыше у тяжелых игрушек.
        victorina(spisok);

    }

    private static void Log_rounds(ArrayList<Toy> spisok) throws IOException {
        FileWriter filew = new FileWriter("Log_of_rounds.txt");
        for (int i = 0; i < 10; i++) {
            filew.write(victorina(spisok) + "round = " + i+"\n");
        }
        filew.close();
    }

    public static String victorina(ArrayList<Toy> spisok) {
        double randomN = Math.random() * 10;
        String st = "к сожалению никому в этом раунде не удалось победить";
        for (Toy toy : spisok) {
            String name = toy.get_name();
            double weight = toy.get_weight();
            if (weight >= randomN) {
                return "Победитель раунда = " + name;
            }

            }
        return st;
    }

    }
