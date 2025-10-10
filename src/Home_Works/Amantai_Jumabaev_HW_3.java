package Home_Works;

public class Amantai_Jumabaev_HW_3 {
// Hi Sensei
static void main(){
        double[] numbers ={1,2,-3,-4,-5,6,7,8,9,10,-11,-13,14,15,16};
        double sum = 0.0;
        int length = 0;
        boolean negativeNum = false;
        for(double number:numbers){
            // Находим первую отрицательную
            if(!negativeNum&&number<0){
                negativeNum = true;
                // Исключаем все отрицательные
            } else if (negativeNum&&number>0) {
                sum =sum+number;
                length++;
            }
        }
        // Находим среднюю арифметическую
        double result = sum / length;
        System.out.println(result);

        }
    }

