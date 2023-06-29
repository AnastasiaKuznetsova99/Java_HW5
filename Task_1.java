
// Задание

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;
// import java.util.stream.Collectors;


public class Task_1 {

    public static void add_strokaTS(String name, String tel, HashMap spr){
        ArrayList<String> telNumbers = new ArrayList<String>();
        if(spr.containsKey(name)) {
            telNumbers = (ArrayList<String>) spr.get(name);
            telNumbers.add(tel);
        }
        else{
            telNumbers.add(tel);
            spr.put(name,telNumbers);
        }
    }
    public static void main(String[] args) {

        HashMap<String, ArrayList> telSpr = new HashMap<>();

        add_strokaTS("Адюков Андрей Павлович","79224896321",telSpr);
        add_strokaTS("Адюкова Евгения Валерьевна","79235789645",telSpr);
        add_strokaTS("Петров Сергей Андреевич","7932547125",telSpr);
        add_strokaTS("Иванов Сергей Иванович","793289745682",telSpr);
        add_strokaTS("Иванов Сергей Иванович","79224798512",telSpr);
        add_strokaTS("Адюкова Евгения Валерьевна","79225879635",telSpr);

        List list = new ArrayList(telSpr.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,ArrayList<String>>>(){
            @Override
            public int compare(Map.Entry<String,ArrayList<String>> o1, Map.Entry<String,ArrayList<String>> o2) {
               return o2.getValue().size()- o1.getValue().size();
            }
        });

        for (int i = 0; i < list.size() ; i++) {
            String v = list.get(i).toString().split("=")[0];
            System.out.println(v+" : "+telSpr.get(v));
        }


    }

}