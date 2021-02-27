import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 20_000_60;
        boolean registered = true;
        long expected = 500;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 20_000_60;
        boolean registered = false;
        long expected = 200;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected,actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected,actual);
    }
}