/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model.atividadesemana05;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 *
 * @author cayo
 */
public class Secretaria {

    private int id;
    private String nome;
    private String departamento;
    private String telefone;
    private String detalhes;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the detalhes
     */
    public String getDetalhes() {
        return detalhes;
    }

    /**
     * @param detalhes the detalhes to set
     */
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    
        public static void main(String[] args) {
        // Criando uma instância da classe Secretaria
        Secretaria secretaria = new Secretaria(1, "Cayo", "Departamento de TI", "(11) 99999-9999", "Responsável pelo suporte técnico");

        // Exibindo as informações da secretaria
        System.out.println("ID: " + secretaria.getId());
        System.out.println("Nome: " + secretaria.getNome());
        System.out.println("Departamento: " + secretaria.getDepartamento());
        System.out.println("Telefone: " + secretaria.getTelefone());
        System.out.println("Detalhes: " + secretaria.getDetalhes());
    }

}
