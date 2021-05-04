package pro;

public class Main {
    public static void format(byte [][][]digits, int wreps, int hreps){
        for (int line =0;line<8;line++){
            for (int reps =0;reps<hreps;reps++){
                for (int digit=0;digit<digits.length;digit++){
                    for (int i =0;i<8;i++){
                        if (digits[digit][line][i]==0){
                            for (int w=0;w<wreps;w++)
                                System.out.print("   ");
                        }else {
                            for (int w =0;w<wreps;w++)
                                System.out.print("50k");
                        }
                    }
                }
                System.out.println();
            }

        }


    }
    public static void main(String[] args) {
        digits d =new digits();
        byte digits [][][] ={d.five,d.zero,d.k};
        int wreps =3;
        int hreps =3;
        format(digits,wreps,hreps);
    }
}
