package br.com.alura.banco;

public class PrincipalBanco {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessarBanco(pool, tx)).run();
        new Thread(new TarefaAcessarBancoProcedimento(pool, tx)).run();

    }

}
