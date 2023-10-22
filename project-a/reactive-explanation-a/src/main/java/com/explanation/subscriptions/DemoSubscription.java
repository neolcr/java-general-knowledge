package com.explanation.subscriptions;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class DemoSubscription implements Subscription {
    private final Subscriber<? super Integer> subscriber;
    private final List<Integer> list;
    private int lastRequestedElement = -1;

    public  DemoSubscription(Subscriber<? super Integer> subscriber, List<Integer> list) {
        this.subscriber = subscriber;
        this.list = list;
    }

    @Override
    public void request(long l) {
        if (lastRequestedElement < list.size() - 1) {
            lastRequestedElement += l;
            subscriber.onNext(list.get(lastRequestedElement));
        } else {
            subscriber.onComplete();
        }
    }

    @Override
    public void cancel() {

    }
}
