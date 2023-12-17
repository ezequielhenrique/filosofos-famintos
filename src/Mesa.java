import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Mesa {
    final static int PENSANDO = 0;
    final static int COMENDO = 1;
    final static int FAMINTO = 2;
    final static int NUM_FILOSOFOS = 5;
    public int[] estadoFilosofos = new int[NUM_FILOSOFOS];
    public int[] tentativas = new int[NUM_FILOSOFOS];
    public Semaphore[] garfos = new Semaphore[NUM_FILOSOFOS];
    public Semaphore mesa = new Semaphore(2);

    public Mesa()
    {
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            estadoFilosofos[i] = PENSANDO;
            tentativas[i] = 0;
            garfos[i] = new Semaphore(1);
        }
    }

    public void pegarGarfos(int id) {
        this.estadoFilosofos[id] = FAMINTO;        
        try{
            mesa.acquire();
            if (this.estadoFilosofos[vizinhoEsquerda(id)] != COMENDO  && this.estadoFilosofos[vizinhoDireita(id)] != COMENDO) {
                garfos[id].acquire();
                garfos[vizinhoDireita(id)].acquire();
                this.estadoFilosofos[id] = COMENDO;
                this.tentativas[id] ++;
        }
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }        
    }

    public void largarGarfos(int id) {
        this.estadoFilosofos[id] = PENSANDO;
        garfos[id].release();
        garfos[vizinhoDireita(id)].release();
        mesa.release();
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
