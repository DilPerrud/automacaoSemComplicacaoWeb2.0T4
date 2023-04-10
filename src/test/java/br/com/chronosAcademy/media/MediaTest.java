package br.com.chronosAcademy.media;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MediaTest{
    @Test
    public void validaAprovado(){
        Media media = new Media();
        String resultado = media.calculaMedia(5.0,5.0);
        assertEquals("Aprovado", resultado);
    }

    @Test
    public void validaReprovado(){
        Media media = new Media();
        String resultado = media.calculaMedia(4.9,5.0);
        assertEquals("Reprovado", resultado);

    }

}