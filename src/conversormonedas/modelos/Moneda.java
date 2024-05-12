package conversormonedas.modelos;

import java.util.Calendar;
import java.util.Map;

public class Moneda {
    private final double USD;
    private final double MXN;
    private final double ARS;
    private final double BRL;
    private final double CAD;
    private final double EUR;
    private final double CNY;
    private final double RUB;
    private final double VES;
    private final double PEN;
    private final Map<String, Double> listaMonedas;
    private String moneda;
    private Calendar calendario;

    public Moneda(MonedaRecord monedaRecord) {
        this.moneda = monedaRecord.base_code();
        this.listaMonedas = monedaRecord.conversion_rates();
        this.USD = listaMonedas.get("USD");
        this.MXN = listaMonedas.get("MXN");
        this.ARS = listaMonedas.get("ARS");
        this.BRL = listaMonedas.get("BRL");
        this.CAD = listaMonedas.get("CAD");
        this.EUR = listaMonedas.get("EUR");
        this.CNY = listaMonedas.get("CNY");
        this.RUB = listaMonedas.get("RUB");
        this.VES = listaMonedas.get("VES");
        this.PEN = listaMonedas.get("PEN");
        this.calendario = Calendar.getInstance();
    }

    public double getUSD() {
        return USD;
    }

    public double getMXN() {
        return MXN;
    }

    public double getARS() {
        return ARS;
    }

    public double getBRL() {
        return BRL;
    }

    public double getCAD() {
        return CAD;
    }

    public double getEUR() {
        return EUR;
    }

    public double getCNY() {
        return CNY;
    }

    public double getRUB() {
        return RUB;
    }

    public double getVES() {
        return VES;
    }

    public double getPEN() {
        return PEN;
    }

    public Map<String, Double> getListaMonedas() {
        return listaMonedas;
    }

    public String getMoneda() {
        return moneda;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    @Override
    public String toString() {
        return "Moneda=" + moneda +
                ", Fecha y hora: " + calendario.getTime() +
                ", USD=" + USD +
                ", MXN=" + MXN +
                ", ARS=" + ARS +
                ", BRL=" + BRL +
                ", CAD=" + CAD +
                ", EUR=" + EUR +
                ", CNY=" + CNY +
                ", RUB=" + RUB +
                ", VES=" + VES +
                ", PEN=" + PEN;
    }
}

