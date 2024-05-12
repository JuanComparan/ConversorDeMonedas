package conversormonedas.modelos;

import java.util.Map;

public record MonedaRecord(Map<String, Double> conversion_rates, String base_code) {
}
