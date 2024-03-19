import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class TicketCalculatorTest {
    private TicketCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TicketCalculator();
    }

    @Test
    void whenThursday_thenFreeTicket() {
        assertEquals(0, calculator.calculateTicketPrice(25, "nowhere", "yes"), "Ticket should be free on Thursdays");
    }

    @Test
    void whenUnderTen_thenFreeTicket() {
        assertEquals(0, calculator.calculateTicketPrice(9, "nowhere", "no"), "Ticket should be free for under 10 years old");
    }

    @Test
    void whenAgeIsTenOnThursday_thenFreeTicket() {
        assertEquals(0, calculator.calculateTicketPrice(10, "nowhere", "yes"), "Ticket should be free for under 10 years old on Thursday");
    }

    @Test
    void whenBetweenTenAndEighteen_thenHalfPriceTicket() {
        assertEquals(20, calculator.calculateTicketPrice(15, "nowhere", "no"), "Ticket should be half price for ages between 10 and 18");
    }

    @Test
    void whenFromWarsawNotThursdayAboveEighteen_thenTenPercentDiscount() {
        assertEquals(36, calculator.calculateTicketPrice(25, "warsaw", "no"), "Residents of Warsaw should get a 10% discount");
    }

    @Test
    void whenUnderEighteenFromWarsawNotThursday_thenCombinedDiscounts() {
        assertEquals(18, calculator.calculateTicketPrice(15, "warsaw", "no"), "Ticket should be half price and an additional 10% discount for Warsaw residents");
    }

    @Test
    void whenAgeIsExactlyEighteenFromWarsawNotThursday_thenHalfPriceTicket() {
        assertEquals(18, calculator.calculateTicketPrice(18, "warsaw", "no"), "Ticket should be half price for exactly 18 years old from Warsaw");
    }

    @Test
    void whenAgeIsExactlyTenFromWarsawNotThursday_thenHalfPriceTicket() {
        assertEquals(36, calculator.calculateTicketPrice(10, "warsaw", "no"), "Ticket should be full price with a 10% discount for exactly 10 years old from Warsaw");
    }

    @Test
    void whenInvalidAge_thenFullPriceTicket() {
        assertEquals(40, calculator.calculateTicketPrice(-1, "nowhere", "no"), "Ticket should be full price for invalid age");
    }

    @Test
    void whenNullResidency_thenFullPriceTicket() {
        assertEquals(40, calculator.calculateTicketPrice(25, null, "no"), "Ticket should be full price for null residency input");
    }

    @Test
    void whenNullDayOfWeek_thenFullPriceTicket() {
        assertEquals(40, calculator.calculateTicketPrice(25, "nowhere", null), "Ticket should be full price for null day of week input");
    }

    // Additional tests can be written for other edge cases and scenarios as necessary.
}
