package no.cantara.logback.ext.core;

public interface PayloadConverter<P> {

    P convert(byte[] payload);

}
