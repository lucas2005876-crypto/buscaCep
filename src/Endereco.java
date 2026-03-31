public class Endereco {

    private String cep,
            rua,
            complemento,
            unidade,
            bairro,
            cidade,
            uf,
            estado,
            regiao,
            ddd;

    public Endereco(String cep, String rua, String complemento, String unidade, String bairro, String cidade, String uf, String estado, String regiao, String ddd) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.estado = estado;
        this.regiao = regiao;
        this.ddd = ddd;
    }

    public Endereco(EnderecoViacep endereco) {
        this.cep = endereco.cep();
        this.rua = endereco.logradouro();
        this.complemento = endereco.complemento();
        this.unidade = endereco.unidade();
        this.bairro = endereco.bairro();
        ;
        this.cidade = endereco.localidade();
        this.uf = endereco.uf();
        this.estado = endereco.estado();
        this.regiao = endereco.regiao();
        this.ddd = endereco.ddd();
    }


    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getDdd() {
        return ddd;
    }


    @Override
    public String toString() {
        return """
                {
                cep='%s',
                rua='%s',
                complemento='%s',
                unidade='%s',
                bairro='%s',
                cidade='%s',
                uf='%s',
                estado='%s',
                regiao='%s',
                ddd='%s'
                }
                """.formatted(
                cep, rua, complemento, unidade,
                bairro, cidade, uf, estado, regiao, ddd
        );
    }

}