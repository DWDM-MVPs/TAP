package tap.ficha2;

public abstract class Figura {
    private String cor;

    public abstract double area();

    public abstract double perimetro();

    public void setCor(String cor) {
	this.cor = cor;
    }

    public String getCor() {
	return cor;
    }

    public String QuemEs() {
	Class c = this.getClass();
	return c.getName();
    }
}