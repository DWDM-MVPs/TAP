package tap.ficha2;

public class Circulo extends Figura
{
    private double raio;

    public Circulo (double r)
    {
        raio = r;
    }

    public double area()
    {
        return Math.PI*Math.pow(raio, 2);
    }

    public double perimetro()
    {
        return 2 * raio * Math.PI;
    }
}