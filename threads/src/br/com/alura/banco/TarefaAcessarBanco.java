package br.com.alura.banco;

public class TarefaAcessarBanco implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessarBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        synchronized (this.pool){
            System.out.println("Peguei a chave do pool");
            pool.getConnection();

            synchronized (this.tx){
                System.out.println("Gerenciando transacao");
                tx.begin();
            }

        }

    }
}
