import java.util.ArrayList;

public class Toy {

        private int  id;
        private String name;
        private double  weight;

        public Toy(int id,String name, double weight){
            this.id = id;
            this.name = name;
            this.weight = weight;

        }
        public int  get_id(){

            return id;
        }
        public String get_name(){
            return name;
        }
        public double  get_weight(){

            return weight;
        }
        @Override
        public String  toString() {
            return  "id = "+id + "\t"+ "Название = "+ name + "\t" + "вес = "+ weight + "\n";
        }}



