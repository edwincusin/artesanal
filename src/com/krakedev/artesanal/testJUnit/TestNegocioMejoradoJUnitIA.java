package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Cliente;

public class TestNegocioMejoradoJUnitIA {

    // Tolerancia usada para comparar valores double (evita errores por precisión)
    private static final double TOLERANCIA = 0.0001;

    /**
     * CASO: Generación de código
     * 
     * OBJETIVO:
     * Verificar que el método generarCodigo genere un código válido.
     * 
     * VALIDACIÓN:
     * - El código debe iniciar con "M-" según la especificación funcional.
     * - No validamos el número exacto porque es aleatorio.
     */
    @Test
    public void testGenerarCodigoFormato() {
        NegocioMejorado negocio = new NegocioMejorado();

        String codigo = negocio.generarCodigo();

        assertTrue(codigo.startsWith("M-"));
    }

    /**
     * CASO: Agregar máquina correctamente
     * 
     * OBJETIVO:
     * Verificar que una máquina se agregue cuando no existe otra con el mismo código.
     * 
     * VALIDACIÓN:
     * - El método debe retornar true indicando éxito.
     * - La lista de máquinas debe aumentar en tamaño.
     */
    @Test
    public void testAgregarMaquinaCorrecto() {
        NegocioMejorado negocio = new NegocioMejorado();

        boolean resultado = negocio.agregarMaquina("Pilsener", "Rubia", 0.02);

        assertTrue(resultado);
        assertEquals(1, negocio.getMaquinas().size());
    }

    /**
     * CASO: Recuperar máquina existente
     * 
     * OBJETIVO:
     * Verificar que se pueda encontrar una máquina previamente agregada.
     * 
     * VALIDACIÓN:
     * - Se obtiene el código real de la máquina creada.
     * - Se recupera usando ese código.
     * - Se espera exactamente la misma instancia.
     */
    @Test
    public void testRecuperarMaquinaExistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Club", "Fría", 0.02);
        Maquina maquinaOriginal = negocio.getMaquinas().get(0);

        Maquina recuperada = negocio.recuperarMaquina(maquinaOriginal.getCodigo());

        assertEquals(maquinaOriginal, recuperada);
    }

    /**
     * CASO: Recuperar máquina inexistente
     * 
     * OBJETIVO:
     * Validar comportamiento cuando el código no existe.
     * 
     * VALIDACIÓN:
     * - Debe retornar null.
     * - No debe lanzar errores.
     */
    @Test
    public void testRecuperarMaquinaNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        Maquina recuperada = negocio.recuperarMaquina("NO_EXISTE");

        assertEquals(null, recuperada);
    }

    /**
     * CASO: Cargar máquinas
     * 
     * OBJETIVO:
     * Verificar que el método llenarMaquina se ejecute en todas las máquinas.
     * 
     * VALIDACIÓN:
     * - Luego de cargar, cada máquina debe tener cantidadActual > 0.
     * - No validamos valor exacto (depende de la implementación interna).
     */
    @Test
    public void testCargarMaquinas() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("A", "desc", 0.01);
        negocio.agregarMaquina("B", "desc", 0.01);

        negocio.cargarMaquinas();

        for (Maquina m : negocio.getMaquinas()) {
            assertTrue(m.getCantidadActual() > 0);
        }
    }

    /**
     * CASO: Registrar cliente
     * 
     * OBJETIVO:
     * Verificar que los clientes se registren correctamente y reciban código único.
     * 
     * VALIDACIÓN:
     * - Se agregan 2 clientes.
     * - El tamaño de la lista debe ser 2.
     * - Los códigos deben ser consecutivos empezando desde 100.
     */
    @Test
    public void testRegistrarCliente() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan", "123");
        negocio.registrarCliente("Pedro", "456");

        assertEquals(2, negocio.getClientes().size());
        assertEquals(100, negocio.getClientes().get(0).getCodigo());
        assertEquals(101, negocio.getClientes().get(1).getCodigo());
    }

    /**
     * CASO: Buscar cliente por cédula existente
     * 
     * OBJETIVO:
     * Verificar que se encuentre correctamente un cliente registrado.
     * 
     * VALIDACIÓN:
     * - Se busca por cédula.
     * - Se obtiene el cliente correcto.
     */
    @Test
    public void testBuscarClientePorCedulaExistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan", "123");

        Cliente cliente = negocio.buscarClientePorCedula("123");

        assertEquals("Juan", cliente.getNombre());
    }

    /**
     * CASO: Buscar cliente por cédula inexistente
     * 
     * VALIDACIÓN:
     * - Debe retornar null.
     */
    @Test
    public void testBuscarClientePorCedulaNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        Cliente cliente = negocio.buscarClientePorCedula("999");

        assertEquals(null, cliente);
    }

    /**
     * CASO: Buscar cliente por código existente
     */
    @Test
    public void testBuscarClientePorCodigoExistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan", "123");

        Cliente cliente = negocio.buscarClientePorCodigo(100);

        assertEquals("Juan", cliente.getNombre());
    }

    /**
     * CASO: Buscar cliente por código inexistente
     */
    @Test
    public void testBuscarClientePorCodigoNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado();

        Cliente cliente = negocio.buscarClientePorCodigo(999);

        assertEquals(null, cliente);
    }

    /**
     * CASO: Consumo exitoso de cerveza
     * 
     * OBJETIVO:
     * Validar el flujo completo del consumo.
     * 
     * ESCENARIO:
     * - Existe máquina
     * - Existe cliente
     * - Hay suficiente cerveza
     * 
     * VALIDACIÓN:
     * - La cantidad en la máquina disminuye
     * - El cliente acumula consumo (>0)
     */
    @Test
    public void testConsumirCervezaExitoso() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Test", "desc", 0.01);
        negocio.cargarMaquinas();

        Maquina maquina = negocio.getMaquinas().get(0);

        negocio.registrarCliente("Juan", "123");
        Cliente cliente = negocio.getClientes().get(0);

        double cantidadInicial = maquina.getCantidadActual();

        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 100);

        assertTrue(maquina.getCantidadActual() < cantidadInicial);
        assertTrue(cliente.getTotalConsumido() > 0);
    }

    /**
     * CASO: Consumo fallido - máquina no existe
     * 
     * VALIDACIÓN:
     * - No debe registrarse consumo
     * - TotalConsumido permanece en 0
     */
    @Test
    public void testConsumirCervezaMaquinaNoExiste() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan", "123");
        Cliente cliente = negocio.getClientes().get(0);

        negocio.consumirCerveza(cliente.getCodigo(), "INVALIDO", 100);

        assertEquals(0, cliente.getTotalConsumido(), TOLERANCIA);
    }

    /**
     * CASO: Consumo fallido - cliente no existe
     * 
     * VALIDACIÓN:
     * - No debe lanzar excepción
     * - El sistema simplemente no hace nada
     */
    @Test
    public void testConsumirCervezaClienteNoExiste() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Test", "desc", 0.01);

        Maquina maquina = negocio.getMaquinas().get(0);

        negocio.consumirCerveza(999, maquina.getCodigo(), 100);

        assertTrue(true); // se valida que no falle
    }

    /**
     * CASO: Registrar consumo acumulado
     * 
     * VALIDACIÓN:
     * - Los valores se suman correctamente
     */
    @Test
    public void testRegistrarConsumo() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan", "123");
        Cliente cliente = negocio.getClientes().get(0);

        negocio.registrarConsumo(cliente.getCodigo(), 10);
        negocio.registrarConsumo(cliente.getCodigo(), 5);

        assertEquals(15, cliente.getTotalConsumido(), TOLERANCIA);
    }

    /**
     * CASO: Consultar valor total vendido
     * 
     * VALIDACIÓN:
     * - Suma correcta del consumo de todos los clientes
     */
    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan", "123");
        negocio.registrarCliente("Pedro", "456");

        Cliente c1 = negocio.getClientes().get(0);
        Cliente c2 = negocio.getClientes().get(1);

        negocio.registrarConsumo(c1.getCodigo(), 10);
        negocio.registrarConsumo(c2.getCodigo(), 20);

        double total = negocio.consultarValorVendido();

        assertEquals(30, total, TOLERANCIA);
    }
}