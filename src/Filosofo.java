public class Filosofo extends Thread {
    final int tempo = 1000;
    final int PENSANDO = 0;
    final int COMENDO = 1;
    final int FAMINTO = 2;
    String nome;
    Mesa mesa;
    int id;
    int estado;

    Filosofo (String nome, Mesa mesa, int id) {
        this.nome = nome;
        this.mesa = mesa;
        this.id = id;
        this.estado = PENSANDO;

        System.out.println("O filósofo " + nome + " sentou-se à mesa");
    }

    public String getNome() {
        return nome;
    }

    public void pensar() {
        try {
            this.estado = PENSANDO;
            System.out.println("O filófofo " + getNome() + " está PENSANDO...");
            Thread.sleep(tempo);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void comFome() {
        this.estado = FAMINTO;
        mesa.estadoFilosofos[id] = FAMINTO;
        System.out.println("O filósofo " + getNome() + " está FAMINTO...");
    }

    public void comer() {
        try {
            this.estado = COMENDO;
            System.out.println("O filófofo " + getNome() + " está COMENDO...");
            Thread.sleep(tempo);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void pegarGarfo() {
        comFome();
        tentaObterGarfos();
    }

    public void largarGarfo() {
        pensar();
        mesa.estadoFilosofos[id] = PENSANDO;
    }

    public void tentaObterGarfos() {
        if (mesa.estadoFilosofos[vizinhoEsquerda()] != 1 && mesa.estadoFilosofos[vizinhoDireita()] != 1) {
            comer();
            mesa.estadoFilosofos[id] = COMENDO;
        }
    }

    private int vizinhoEsquerda() {
        if (this.id == 0) {
            return 4;
        } else {
            return this.id - 1;
        }
    }

    private int vizinhoDireita() {
        if (this.id == 4) {
            return 0;
        } else {
            return this.id;
        }
    }

    @Override
    public void run() {
        try {
            pensar();

            while (true) {
                pegarGarfo();
                Thread.sleep(tempo);
                largarGarfo();
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
