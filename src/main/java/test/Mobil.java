package test;

import org.springframework.context.annotation.Bean;

public class Mobil {
    private String roda;
    private String jendela;

    public String getRoda() {
        return roda;
    }

    public void setRoda(String roda) {
        this.roda = roda;
    }

    public String getJendela() {
        return jendela;
    }

    public void setJendela(String jendela) {
        this.jendela = jendela;
    }
}
