import java.io.*;
import java.util.*;
public class AgendaModel{
    public static class Pessoa{
        private int codigo;
        private String nome;
        private String endereco;
        private String telefone;
        private String anotacoes;

        public Pessoa(int codigo, String nome, String endereco, String telefone, String anotacoes) {
            this.codigo = codigo;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.anotacoes = anotacoes;
        }
        public int getCodigo() {
            return codigo;
        }
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }  
        public String getEndereco() {
            return endereco;
        }  
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
        public String getTelefone() {
            return telefone;
        }
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
        public String getAnotacoes() {
            return anotacoes;
        }
        public void setAnotacoes(String anotacoes) {
            this.anotacoes = anotacoes;
        }
        public String paraArquivo() {
        return codigo + ";" + nome + ";" + endereco + ";" + telefone + ";" + anotacoes;
    }
     public static Pessoa daLinha(String linha) {
            String[] partes = linha.split(";");
            return new Pessoa(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3],
                partes[4]
                );
}
    }
    private ArrayList<Pessoa> pessoas;
        private int proximoCodigo;
        private final String NOME_ARQUIVO = "agenda.txt";

        public AgendaModel() {
            this.pessoas = new ArrayList<>();
            this.proximoCodigo = 1;
            carregarDoArquivo();
        }

        public Pessoa adicionarPessoa(String nome, String endereco, String telefone, String anotacoes) {
            Pessoa p = new Pessoa(proximoCodigo++, nome, endereco, telefone, anotacoes);
            pessoas.add(p);
            salvarNoArquivo();
            return p;
        }

        public boolean removerPessoa(int codigo) {
            boolean removido = pessoas.removeIf(p -> p.getCodigo() == codigo);
            if (removido) salvarNoArquivo();
            return removido;
        }

        public List<Pessoa> consultarPorNome(String nome) {
            List<Pessoa> resultado = new ArrayList<>();
            for (Pessoa p : pessoas) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    resultado.add(p);
                }
            }
            return resultado;
        }

        public Pessoa consultarPorCodigo(int codigo) {
            for (Pessoa p : pessoas) {
                if (p.getCodigo() == codigo) return p;
            }
            return null;
        }

        public List<Pessoa> listarTodas() {
            return Collections.unmodifiableList(pessoas);
        }

        private void salvarNoArquivo() {
            try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO))) {
                for (Pessoa p : pessoas) {
                    writer.println(p.paraArquivo());
                }
            } catch (IOException e) {
                System.out.println("Erro ao salvar: " + e.getMessage());
            }
        }

        private void carregarDoArquivo() {
            File f = new File(NOME_ARQUIVO);
            if (!f.exists()) return;

            try (Scanner scanner = new Scanner(f)) {
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    try {
                        Pessoa p = Pessoa.daLinha(linha);
                        pessoas.add(p);
                        if (p.getCodigo() >= proximoCodigo) {
                            proximoCodigo = p.getCodigo() + 1;
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao carregar linha: " + linha);
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
            }
        }
} 