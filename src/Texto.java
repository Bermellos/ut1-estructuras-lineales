public class Texto 
{
    public StringBuilder contenido; 
    public String textoInicial;
    
    public Texto(StringBuilder contenido, String textoInicial)
    {
        this.contenido = contenido; 
        this.textoInicial = textoInicial; 
    }

    public void appendTexto(String textoAgregado)
    {
        this.contenido.append(textoAgregado);
    }

    public void insertTexto(int indice, String textoAgregado)
    {
        this.contenido.insert(indice, textoAgregado);
    }

    public void deleteTexto(int inicio, int fin)
    {
        this.contenido.delete(inicio, fin);
    }

    public void deleteCharAtTexto(int indice)
    {
        this.contenido.deleteCharAt(indice);
    }

    public void setLengthTexto(int nuevoLargo)
    {
        this.contenido.setLength(nuevoLargo);
    }

    public void ensureCapacityTexto(int minimo)
    {
        this.contenido.ensureCapacity(minimo);
    }

    public static void main(String args[])
    {
        Texto texto = new Texto(new StringBuilder("Hola"), "Hola");

        texto.appendTexto("Mundo java");
        System.out.println(texto.contenido);

        texto.insertTexto(2, "Mundo java");
        System.out.println(texto.contenido);

        texto.deleteTexto(2, 4);
        System.out.println(texto.contenido);

        texto.deleteCharAtTexto(2);
        System.out.println(texto.contenido);

        texto.setLengthTexto(2);
        System.out.println(texto.contenido);

        texto.ensureCapacityTexto(3);
        System.out.println(texto.contenido);
    }
}