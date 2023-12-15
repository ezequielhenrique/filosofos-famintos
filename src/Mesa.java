public class Mesa {
    final static int PENSANDO = 0;
    final static int COMENDO = 1;
    final static int FAMINTO = 2;
    final static int NUM_FILOSOFOS = 5;
    final static int PRIMEIRO_FILOSOFO = 0;
    final static int ULTIMO_FILOSOFO = NUM_FILOSOFOS - 1;
    boolean[] garfos = new boolean[NUM_FILOSOFOS];
    int[] estadoFilosofos = new int[NUM_FILOSOFOS];
    int[] tentativas = new int[NUM_FILOSOFOS];

    public Mesa()
    {
        for (int i = 0; i < 5; i++)
        {
            garfos[i] = true;
            estadoFilosofos[i] = PENSANDO;
            tentativas[i] = 0;
        }
    }
}
