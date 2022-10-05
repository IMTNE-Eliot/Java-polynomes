import java.util.Scanner;

public class td4 {
    public static void main(String[] args) {
        /*
        Polynome p = new Polynome();
        System.out.println(Polynome.ecrire(p));
        System.out.println("Quel X ?");
        double x = td4.lireDouble();
        System.out.println(Polynome.calculer(p,x));
        System.out.println(Polynome.calculrec(p,x,0));
        */

        Polynome a = new Polynome();
        Polynome b = new Polynome();

        System.out.println(Polynome.ecrire(a));
        System.out.println(Polynome.ecrire(b));

        Polynome c = addition(a,b);
        System.out.println(Polynome.ecrire(c));

        Polynome d = Polynome.multalpha(c,2);
        System.out.println(Polynome.ecrire(d));

        Polynome e = Polynome.deriv(d);
        System.out.println(Polynome.ecrire(e));

        Polynome f = Polynome.prim(d);
        System.out.println(Polynome.ecrire(f));

        System.out.println(Polynome.zerodicho(a, 0.000000004, -100, 100));
    }

    public static int lireEntier(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static double lireDouble(){
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static Polynome addition (Polynome a, Polynome b){
        int degmax = Math.max(a.degre, b.degre);
        double[] coeftot = new double[degmax+1];
        for(int i=0;i<Math.min(a.degre,b.degre)+1;i++){
            coeftot[i] = a.coef[i] + b.coef[i];
        }
        for(int i=Math.min(a.degre,b.degre)+1;i<Math.max(a.degre,b.degre)+1;i++){
            if(a.degre<b.degre){
                coeftot[i] = b.coef[i];
            }else{
                coeftot[i] = a.coef[i];
            }
        }

        while(coeftot[degmax] == 0){
            degmax--;
        }
        return new Polynome(degmax, coeftot);
    }


}

