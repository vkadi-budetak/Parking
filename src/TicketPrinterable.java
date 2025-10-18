// Interface - printing/issuing a ticket
public interface TicketPrinterable {

// метод видачі квитків
void ticketPrint(String ticket);

// метод навності вільних місць
boolean isPresenceOf(String place);
}
