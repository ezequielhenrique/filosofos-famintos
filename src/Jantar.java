public class Jantar {
    public static void main (String[] args)
    {
        Mesa mesa = new Mesa ();

        String[] nomesFilosofos = {"Platão", "Aristóteles", "Descartes", "Sócrates", "Euclides"};

        for (int i=0; i < 5; i++) {
            new Filosofo(nomesFilosofos[i], mesa, i).start();
        }
    }
}
