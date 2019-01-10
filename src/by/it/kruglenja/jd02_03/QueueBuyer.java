package by.it.kruglenja.jd02_03;

import java.util.LinkedList;

/**
 * Created by user on 20.12.2018.
 */
public class QueueBuyer {

    private static LinkedList<Buyer> buyerQueue = new LinkedList<>();
    private static LinkedList<Buyer> oldMansQueue = new LinkedList<>();

    public static int getBuyersInQueue() {
        return buyerQueue.size();
    }

    //Добавляем баера в очередь
    static synchronized void addBuyer(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    //Удаляем баера из очереди
    static synchronized Buyer buyerExtract()
    {
        return buyerQueue.pollFirst();
    }

}

