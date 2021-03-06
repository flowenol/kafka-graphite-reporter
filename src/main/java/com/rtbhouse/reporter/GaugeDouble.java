package com.rtbhouse.reporter;

import com.codahale.metrics.Gauge;
import org.apache.kafka.common.metrics.KafkaMetric;

public class GaugeDouble implements Gauge<Double> {

    private final KafkaMetric metric;

    public GaugeDouble(KafkaMetric metric) {
        this.metric = metric;
    }

    @Override
    public Double getValue() {
        Object metricValue = metric.metricValue();
        if (!(metricValue instanceof Number)) {
            return 0.0;
        }
        double value = ((Number) metricValue).doubleValue();
        return Double.isNaN(value) ? 0.0 : value;
    }
}
