import java.util.Arrays;

public class Mesa {
    final static int PENSANDO = 0;
    final static int COMENDO = 1;
    final static int FAMINTO = 2;
    final static int NUM_FILOSOFOS = 5;
    public int[] estadoFilosofos = new int[NUM_FILOSOFOS];
    public int[] tentativas = new int[NUM_FILOSOFOS];

    public Mesa()
    {
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            estadoFilosofos[i] = PENSANDO;
            tentativas[i] = 0;
        }
    }

    public void pegarGarfos(int id) {
        this.estadoFilosofos[id] = FAMINTO;

        if (this.estadoFilosofos[vizinhoEsquerda(id)] != COMENDO  && this.estadoFilosofos[vizinhoDireita(id)] != COMENDO) {
            this.estadoFilosofos[id] = COMENDO;
            this.tentativas[id] ++;
        }
    }

    public void largarGarfos(int id) {
        this.estadoFilosofos[id] = PENSANDO;
    }

    private int vizinhoEsquerda(int id) {
        if (id == 0) {
            return 4;
        } else {
            return id - 1;
        }
    }

    private int vizinhoDireita(int id) {
        if (id == 4) {
            return 0;
        } else {
            return id + 1;
        }
    }
    public void status() {
        System.out.println("0-Pensando/1-Comendo/2-Faminto: " + Arrays.toString(estadoFilosofos));
        System.out.println("Vezes que cada filosófo comeu: " + Arrays.toString(tentativas));
    }
}
