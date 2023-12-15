public class Filosofo extends Thread {
    final int tempo = 1000;
    String nome;
    Mesa mesa;
    int id;

    Filosofo (String nome, Mesa mesa, int id) {
        this.nome = nome;
        this.mesa = mesa;
        this.id = id;

        System.out.println("O filósofo " + nome + " sentou-se à mesa");
    }

    public String getNome() {
        return nome;
    }

    public void pensar() {
        try {
            System.out.println("O filófofo " + getNome() + " está PENSANDO...");
            Thread.sleep(tempo);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void comFome() {
        System.out.println("O filósofo " + getNome() + " está FAMINTO...");
    }

    public void comer() {
        try {
            System.out.println("O filófofo " + getNome() + " está COMENDO...");
            mesa.status();
            Thread.sleep(tempo);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void pegarGarfo() {
        mesa.pegarGarfos(id);
    }

    public void largarGarfo() {
        mesa.largarGarfos(this.id);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(tempo);
                pensar();
                pegarGarfo();
                Thread.sleep(tempo);
                comer();
                largarGarfo();
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
