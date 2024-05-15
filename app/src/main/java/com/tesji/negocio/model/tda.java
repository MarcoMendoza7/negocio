package com.tesji.negocio.model;

public class tda {
    private int cantidad;
    private int cliente;
    private int descuento;
    private int total;
    private int rebaja;
    public String mostrarInfo() {
        String InfoResultado = "";

        if(cliente == 1 && descuento == 1 ){
            rebaja = (cantidad*15)/100;
            total = cantidad - rebaja;
            InfoResultado = "Descuento del 15% : \n $"+ rebaja+ " \n \n" +
                    "Total : \n $"+ total;

        }else if(cliente == 1 && descuento == 2){
            rebaja = (cantidad * 10)/100;
            total = cantidad + rebaja;
            InfoResultado="Descuento del 10% : \n $"+ rebaja+ " \n \n" +
                    "Total: \n $"+ total;
        }else if(cliente == 2 && descuento == 1){
            rebaja = (cantidad * 20)/100;
            total = cantidad - rebaja;
            InfoResultado = "El descuento es del 20% :\n "+ rebaja+ " pesos \n \n" +
                    "Total: \n $ " + total;


        }else if(cliente == 2 && descuento == 2){
            rebaja = (cantidad * 5)/100;
            total = cantidad - rebaja;
            InfoResultado = "Descuento del 5% :\n $"+ rebaja+ " \n \n" +
                    "Total : \n $ "+ total;
        }
        return InfoResultado;

    }
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    public int getCliente(){
        return cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getDescuento(int descuento) {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
