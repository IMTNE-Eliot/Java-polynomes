public class Polynome {
    public int degre;
    public double[] coef;

    public Polynome(){
        System.out.println("fournir le degré du polynome");
        degre = td4.lireEntier();

        coef = new double[degre+1];
        System.out.println("fournir les coefficients du polynome");
        for(int i=0; i<degre+1;i++){
            System.out.println("x^"+i);
            coef[i] = td4.lireDouble();
        }
    }

    public Polynome(int deg, double[] coe){
        degre = deg;
        coef = new double[deg+1];
        for(int i=0; i<degre+1;i++){
            coef[i] = coe[i];
        }
    }

    public static String ecrire (Polynome p){
        String sortie = "Le polynôme P(x) = ";
            sortie += (p.coef[0]);
        for(int i=1; i<p.degre+1;i++){
            if(p.coef[i]<0) {
                sortie += (" "+p.coef[i] + "*x^" + i);
            } else if (p.coef[i]>0) {
                sortie += (" +" + p.coef[i] + "*x^" + i);
            }
        }

        return sortie;
    }

    public static double calculer (Polynome p, double x){
        int valeur = 0;
        for(int i=0; i<p.degre+1;i++){
            valeur+=p.coef[i]*Math.pow(x,i);
        }
        return valeur;
    }

    public static double calculrec (Polynome p, double x, int indice){
        if(indice<p.degre){
            return p.coef[indice]+x*calculrec(p,x,indice+1);
        }
        else {
            return p.coef[indice];
        }
    }

    public static Polynome multalpha (Polynome p, double alpha){
        double[] coefmult = new double[p.degre+1];
        for(int i=0; i<=p.degre;i++){
            coefmult[i] = p.coef[i]*alpha;
        }
        return new Polynome(p.degre, coefmult);
    }

    public static Polynome deriv (Polynome p){
        double[] coefder = new double[p.degre];
        for(int i=0; i<p.degre;i++){
            coefder[i] = p.coef[i+1]*(i+1);
        }
        return new Polynome(p.degre-1, coefder);
    }

    public static Polynome prim (Polynome p){
        double[] coefder = new double[p.degre+2];
        coefder[0] = 0;
        for(int i=1; i<p.degre+2;i++){
            coefder[i] = p.coef[i-1]/(i);
        }
        return new Polynome(p.degre+1, coefder);
    }

    public static double zerodicho (Polynome p, double precision, double a, double b){
        if(Math.abs(a-b) < precision){
            return a;
        }
        if(calculer(p, (a+b)/2.0)<0.0){
            return zerodicho(p, precision, (a+b)/2, b);
        }else if (calculer(p, (a+b)/2.0)>0.0){
            return zerodicho(p, precision, a, (a+b)/2);
        }else {
            return (a + b) / 2;
        }
    }



}


