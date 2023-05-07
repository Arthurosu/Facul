public class Corrida{
    private int id;
    private double primeiraVolta;
    private double segundaVolta;

    public Corrida(double primeiraVolta, double segundaVolta) {
        setPrimeiraVolta(primeiraVolta);
        setSegundaVolta(segundaVolta);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setPrimeiraVolta(double primeiraVolta) {
        this.primeiraVolta = primeiraVolta;
    }

    public double getPrimeiraVolta() {
        return this.primeiraVolta;
    }

    public void setSegundaVolta(double segundaVolta) {
        this.segundaVolta = segundaVolta;
    }

    public double getSegundaVolta() {
        return this.segundaVolta;
    }
}