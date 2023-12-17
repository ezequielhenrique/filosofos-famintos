import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Filosofos {
    public class Garfos extends Thread{
        private final int garfoEsquerda;
        private final int garfoDireita ;
        public Garfos(int garfoDireita, int garfoEsquerda){
            this.garfoDireita = garfoDireita;
            this.garfoEsquerda = garfoEsquerda;
            
        }
        public void run(){
            while(true){
                try{
                    SorteioDireita();
                    SorteioESuqerda();
                    Thread.sleep(1000);

                }
                catch(InterruptedException e){
                    System.out.println(e);

                }
            }
        }
        
        private void SorteioDireita() {
            int garfoD;
            Random R = new Random();
            garfoD=R.nextInt(5);
            System.out.println("O garfo da direita sorteado "+ garfoDireita);
            
        }
        private void SorteioESuqerda() {
            int garfoE;
            Random e = new Random();
            garfoE=e.nextInt(5);
            System.out.println("O garfo da direita sorteado "+ garfoEsquerda);
        }
        

    } 
    public class Filosofo extends Thread{
        String nome ;
        Garfos garfo;
        int lugra_mesa;
        public Filosofo(String nome,Garfos garfo,int lugra_mesa ){
            this.nome = nome;
            this.garfo=garfo;
            this.lugra_mesa= lugra_mesa;
            System.out.println("o filosofo "+ nome + " sentou a mesa");



        }
        public void Pensar() throws InterruptedException{
            System.out.println("o filosofo "+ nome+ " está no mundo da lua ");
            Thread.sleep(1000);


        }
        
        public void run(){

            while(true){

                if(garfo.garfoDireita==5){

                    System.out.println("O filosofo "+nome+" pegou o grafo "+ garfo.garfoDireita);

                    if(garfo.garfoEsquerda==1){
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                    }

                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                if (garfo.garfoDireita==1){
                    System.out.println("O filosofo "+nome+" pegou o grafo"+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==2) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " ESTÁ COMENDO");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                        
                    }
                    else{
                        System.out.println("o filosofo "+ nome+ " largou o garfo"+ garfo.garfoDireita);
                    }

                } else{
                     try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                }
                if (garfo.garfoDireita==2) {
                    System.out.println("O filosofo "+nome+" pegou o grafo "+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==3) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                    }
                    else{
                        System.out.println("o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                    }
             
                } else{
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    
                }
                if (garfo.garfoDireita==3) {
                    System.out.println("O filosofo " +nome+" pegou o grafo "+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==4) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println(" o filosofo "+ nome+ " largou o garfo da esquerda");
                        
                    } else{
                        System.out.println(" o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                    }
                    
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                } if (garfo.garfoDireita==4) {
                    System.out.println("O filosofo "+nome+" pegou o grafo "+ garfo.garfoDireita);
                    if (garfo.garfoEsquerda==5) {
                        System.out.println("o filosofo "+ nome+" pegou o garfo "+ garfo.garfoEsquerda);
                        System.out.println("o filosofo "+ nome+ " Está comendo");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("o filosofo "+ nome+ " largou o garfo da esquerda");
                        
                    } else {
                        System.out.println("o filosofo "+ nome+ " largou o garfo "+ garfo.garfoDireita);
                        
                    }
                } else {
                    try {
                        Pensar();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    
                }
            }
        }
        

    }
    public void test(){
            Garfos g1 = new Garfos(5, 1);
            Garfos g2 = new Garfos(1, 2);
            Garfos g3 = new Garfos(2, 3);
            Garfos g4 = new Garfos(3, 4);
            Garfos g5 = new Garfos(4, 5);

            Filosofo filosofo1 = new Filosofo("PEDRO", g1, 1);
             Filosofo filosofo2 = new Filosofo("JOÃO", g2, 2);
              Filosofo filosofo3 = new Filosofo("CARLOS", g3, 3);
               Filosofo filosofo4 = new Filosofo("WALDEMAR", g4, 4);
                Filosofo filosofo5 = new Filosofo("EZEQUEIL", g5, 5);
                
                new Thread(filosofo1).start();
                new Thread(filosofo2).start();
                new Thread(filosofo3).start();
                new Thread(filosofo4).start();
                new Thread(filosofo5).start();
        }
    
    
}
