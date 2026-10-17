public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;
    private int id;

    public Cliente(String nome, String cpf, String email, String dataNascimento, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "\n" + "Nome: " + this.getNome() + " CPF: " + this.getCpf() + " E-mail: " + this.getEmail() + " Data de Nascimento: " + this.getDataNascimento() + " ID: " + this.getId();
    }
}
