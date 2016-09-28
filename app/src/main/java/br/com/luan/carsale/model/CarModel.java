package br.com.luan.carsale.model;

import java.io.Serializable;

/**
 * Created by Dev_Maker on 27/04/2016.
 */
public class CarModel implements Serializable{
    private String modelo;
    private String fabricante;
    private String cor;
    private int price;
    private Integer imagem;

    public CarModel() {
            }

    public CarModel(String modelo, String fabricante, String cor, int price, Integer imagem) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.price = price;
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }
}
