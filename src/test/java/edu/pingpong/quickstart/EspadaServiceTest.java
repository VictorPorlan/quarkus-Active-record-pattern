package edu.pingpong.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;

@QuarkusTest
@Transactional
public class EspadaServiceTest {
    @Inject
    EspadaService service;

    @Test
    public void testLista(){
        Assertions.assertThat(service.getListaEspadas()).hasSize(2);
    }
    @Test
    public void containsTest() {
        Assertions.assertThat(service.getListaEspadas().stream().anyMatch(f -> f.getNombre().equals("Dragonslayer"))).isTrue();
    }
    @Test
    public void addTest() {
        service.postEspada(new Espada("Sable laser", 100.0F));
        Assertions.assertThat(service.getListaEspadas()).hasSize(3);
        Assertions.assertThat(service.getListaEspadas().stream().anyMatch(f -> f.getNombre().equals("Sable laser"))).isTrue();

        // handmade rollback gracias al antipatron ActiveRecord ;)
        Espada fruit = Espada.find("nombre", "Sable laser").firstResult();
        fruit.delete();
        Assertions.assertThat(Espada.count()).isEqualTo(2);
    }
    @Test
    public void removeTest(){
        service.deleteEspadas("Frostmourne");
        Assertions.assertThat(service.getListaEspadas()).hasSize(1);
        Assertions.assertThat(service.getListaEspadas().stream().anyMatch(f -> f.getNombre().equals("Frostmourne"))).isFalse();
        Espada.persist(new Espada("Frostmourne", 100.0F));
        Assertions.assertThat(Espada.count()).isEqualTo(2);
    }
    @Test
    public void getEspadaNombreTest() {
        Assertions.assertThat(service.getEspadaNombre("Dragonslayer")).get().hasFieldOrPropertyWithValue("nombre", "Dragonslayer").hasFieldOrPropertyWithValue("longitud", 200.0F);
        Assertions.assertThat(service.getEspadaNombre("Excalibur")).isEmpty();
    }
    @Test
    public void getEspadaLongitudTest() {
        Assertions.assertThat(service.getEspadaLongitud(200.0F)).get().hasFieldOrPropertyWithValue("nombre", "Dragonslayer").hasFieldOrPropertyWithValue("longitud", 200.0F);
        Assertions.assertThat(service.getEspadaLongitud(150.0F)).isEmpty();
    }
}
