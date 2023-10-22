package com.explanation.publishers;

import com.explanation.subscriptions.DemoSubscription;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.List;

public class DemoPublisher implements Publisher<Integer> {

    private final List<Integer> list;

    public DemoPublisher(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        DemoSubscription subscription = new DemoSubscription(subscriber, list);
        subscriber.onSubscribe(subscription);
    }
}
