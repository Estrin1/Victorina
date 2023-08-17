import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.shuffle;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Toy> spisok = new ArrayList<>();
        spisok.add(new Toy(1, "машинка", 2));
        spisok.add(new Toy(2, "Мячик", 3));
        spisok.add(new Toy(3, "Сигареты", 1));
        spisok.add(new Toy(4, "Танк", 5));
        spisok.add(new Toy(5, "Кукла", 4));

        System.out.println("\n" + "<<Список игрушек учавствующих в розыгрыше:>>" + "\n" + spisok);
//ввод новых данных для управления и контроля + шафл список

        Controller(spisok);

//реализовать выбор игрушки по весу. предпочтение в выигрыше у тяжелых игрушек.
    }

    private static void Controller(ArrayList<Toy> spisok) throws IOException {
        int s = 0;
        while (s != 3) {
            Scanner scanner = new Scanner(System.in );
            System.out.println("Нажмите 1 чтобы сыграть"+ "\n" +
                    "нажмите 2 чтобы посмотреть лог прошедших раундов" + "\n" +
                    "нажмите 3 чтобы выйти из викторины");
            s = scanner.nextInt();

            //             ArrayList<Toy>  a = new ArrayList<>();
            //                   a  = Collections.shuffle(spisok);
            if(s == 1) {

                Log_rounds(spisok);
            } else if(s == 2){

                readFile();
            }
            else if(s == 3){
                System.out.println("Не хотите как хотите");
            }

        }
    }

    private static void readFile() {
        try {
            Path path = Paths.get("Log_of_rounds.txt");
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    запись в файл
    private static void Log_rounds(ArrayList<Toy> spisok) throws IOException {
        FileWriter filew = new FileWriter("Log_of_rounds.txt");
        for (int i = 1; i < 11; i++) {
            filew.write(victorina(spisok) + " round = " + i +"\n");
        }
        filew.close();
    }
//Проведение викторины, выпадает первая игрушка удовлетворяющая условию
    public static String victorina(ArrayList<Toy> spisok) {
        double randomN = Math.random() * 8;
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
