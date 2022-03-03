public class Fisch extends Tier {

    private final String groesse ;

    public Fisch(String name, String art, String fundort, String vonmonat, String bismonat, String uhrzeit, int wert, String groesse) {
        super(name, art, fundort, vonmonat, bismonat, uhrzeit, wert);
        this.groesse = groesse;
    }


}
