package entidades;

import java.util.Date;
<<<<<<< ae6ade20d0d8a20af195cf705d7ac5222879979e:src/java/entidades/Cliente.java

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String endereco;
    private String genero;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name="seq_produto", sequenceName="produto_id_seq", allocationSize=1)
public class Produto {
    
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)

    private int id;
    private String produto;
    private double valor;
    private double quantidade;
    private String marca;
>>>>>>> Primeira Entrega:src/java/entidades/Produto.java

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

<<<<<<< ae6ade20d0d8a20af195cf705d7ac5222879979e:src/java/entidades/Cliente.java
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
=======
    public double getQuantidade() {
        return quantidade;
>>>>>>> Primeira Entrega:src/java/entidades/Produto.java
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

<<<<<<< ae6ade20d0d8a20af195cf705d7ac5222879979e:src/java/entidades/Cliente.java
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
=======
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }




}
>>>>>>> Primeira Entrega:src/java/entidades/Produto.java
