package tasks.six.a;

/** Издание. Общая реализация процесса для книги, журнала и учебного пособия */
public abstract class Publication implements PublicationProcess {
    private String title;
    private Status status = Status.CREATED;
    private boolean paid;
    private boolean laidOut;

    public Publication(String title) {
        this.title = title;
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public void signContract() {
        if (status != Status.CREATED) {
            System.out.println("Договор уже оформлен: " + title);
            return;
        }
        status = Status.CONTRACT_SIGNED;
        System.out.println("Оформлен договор: " + title);
    }

    @Override
    public void open() {
        if (status != Status.CONTRACT_SIGNED) {
            System.out.println("Открыть можно только после оформления договора: " + title);
            return;
        }
        status = Status.OPEN;
        System.out.println("Издание открыто: " + title);
    }

    @Override
    public void edit() {
        if (!isOpen()) {
            return;
        }
        /** После правок издание нужно сверстать заново */
        laidOut = false;
        System.out.println("Издание отредактировано: " + title);
    }

    @Override
    public void layout() {
        if (!isOpen()) {
            return;
        }
        laidOut = true;
        System.out.println("Издание сверстано: " + title);
    }

    @Override
    public void pay() {
        if (status == Status.CREATED || status == Status.REFUSED || status == Status.CLOSED) {
            System.out.println("Сейчас оплатить нельзя: " + title);
            return;
        }
        if (paid) {
            System.out.println("Издание уже оплачено: " + title);
            return;
        }
        paid = true;
        System.out.println("Издание оплачено: " + title);
    }

    @Override
    public void print() {
        if (!isOpen()) {
            return;
        }
        if (!laidOut) {
            System.out.println("Нельзя печатать без верстки: " + title);
            return;
        }
        if (!paid) {
            System.out.println("Нельзя печатать без оплаты: " + title);
            return;
        }
        status = Status.PRINTED;
        System.out.println("Отправлено на печать: " + title);
    }

    @Override
    public void refuse() {
        if (status == Status.PRINTED || status == Status.REFUSED || status == Status.CLOSED) {
            System.out.println("Отказаться уже нельзя: " + title);
            return;
        }
        status = Status.REFUSED;
        System.out.println("Отказ от издания: " + title);
    }

    @Override
    public void resume() {
        if (status != Status.REFUSED && status != Status.CLOSED) {
            System.out.println("Возобновить можно только после отказа или закрытия: " + title);
            return;
        }
        status = Status.OPEN;
        System.out.println("Издание возобновлено: " + title);
    }

    @Override
    public void close() {
        if (status != Status.OPEN && status != Status.PRINTED) {
            System.out.println("Закрыть можно только открытое или напечатанное издание: " + title);
            return;
        }
        status = Status.CLOSED;
        System.out.println("Издание закрыто: " + title);
    }

    /** Подклассы используют эту проверку в своих методах */
    protected boolean isOpen() {
        if (status != Status.OPEN) {
            System.out.println("Издание не открыто: " + title);
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getType() + " \"" + title + "\", статус: " + status + ", оплачено: " + (paid ? "да" : "нет");
    }
}
