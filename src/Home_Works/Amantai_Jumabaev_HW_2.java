package Home_Works;

import java.util.Random;

//Hi Sensei
public class Amantai_Jumabaev_HW_2 {

    // 1.
    public static String permission(int age,int temp){
            // 2.
        // если возраст человека от 20 до 45 лет и температура на улице от -20 до 30 градусов
        if((age>=20&&age<=45)&&(temp>=-20&&temp<=30)){
            return "Можно идти гулять";
        }
        // если же человеку меньше 20 лет и температура на улице в диапазоне от 0 до 28 градусов
        else if (age<=20&&(temp>=0&&temp<=28)) {
            return "Можно идти гулять";
        }
        // если человеку больше 45 и температура в диапазоне от -10 до 25 градусов
        else if (age>=45&&(temp>=-10&&temp<=25)) {
            return "Можно идти гулять";
        }else{
            return "Оставайтесь дома";
        }
    }
    public static int generateRandomAge(){
        Random random = new Random();
        int randomNum = random.nextInt(100)+1;
        return randomNum;
    }

    public static void main(){

        // 3.
        String result;
        result=permission(30,10);
        System.out.println(result);
        result=permission(18,27);
        System.out.println(result);
        result=permission(60,25);
        System.out.println(result);
        result=permission(50,28);
        System.out.println(result);
        result=permission(30,35);
        System.out.println(result);

        // 5.
        result=permission(generateRandomAge(),35);
        System.out.println(result);
        result=permission(generateRandomAge(),35);
        System.out.println(result);
    }

}

