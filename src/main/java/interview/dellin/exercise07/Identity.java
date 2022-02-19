package interview.dellin.exercise07;

import java.math.BigInteger;

/**
 * Связывает одинаковые профили
 *
 * @author E.Bolgar on 19.05.2017.
 */
interface Identity {
    /**
     * Идентификатор записи
     */
    public BigInteger getId();

    /**
     * Основная сущность
     */
    public Record getRecord();

    /**
     * Зависимая сущность
     */
    public Record getReference();

    /**
     * Владелец временной записи.
     * Отношения бывают временные и заводятся на пользователя.
     * Если значение null, то запись постоянная
     * Если нет, то временная и принадлежит пользователю
     */
    public String getTemporaryOwner();
}
