/**
 * Interface Paymentsable - оплата за парковку.
 * После успешной реестрации проводим оплату
 * isPayment - метод проверки успешной оплаты
 */
public interface Paymentsable {

    boolean isPayment(String meaning);
}
