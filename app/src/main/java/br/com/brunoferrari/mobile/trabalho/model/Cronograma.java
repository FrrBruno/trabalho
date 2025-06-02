package br.com.brunoferrari.mobile.trabalho.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Cronograma {
    private String nome;
    private String cliente;
    private String descricaoServico;
    private String horasPorPessoa;
    private String quantidadePessoas;
    private String material;
    private String date;

    public Cronograma(JSONObject jp) {
        try {
            this.setNome(jp.getString("IdNome"));
            this.setCliente(jp.getString("idCliente"));
            this.setDescricaoServico(jp.getString("idDescrição"));
            this.setHorasPorPessoa(jp.getString("idQntHoras"));
            this.setQuantidadePessoas(jp.getString("idQntPessoas"));
            this.setMaterial(jp.getString("idMaterial"));
            this.setDate(jp.getString("IdData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Cronograma() {
        this.nome = "";
        this.cliente = "";
        this.descricaoServico = "";
        this.horasPorPessoa = "";
        this.quantidadePessoas = "";
        this.material = "";
        this.date = "";

    }

    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("IdNome", this.nome);
            json.put("idCliente", this.cliente);
            json.put("idDescrição", this.descricaoServico);
            json.put("idQntHoras", this.horasPorPessoa);
            json.put("idQntPessoas", this.quantidadePessoas);
            json.put("idMaterial", this.material);
            json.put("IdData", this.date);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getHorasPorPessoa() {
        return horasPorPessoa;
    }

    public void setHorasPorPessoa(String horasPorPessoa) {
        this.horasPorPessoa = horasPorPessoa;
    }

    public String getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(String quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}