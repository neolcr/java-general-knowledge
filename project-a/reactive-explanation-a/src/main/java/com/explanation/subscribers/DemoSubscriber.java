package com.explanation.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed to: " + subscription.toString());
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("On next: " + integer);
        subscription.request(1);
//        if (integer == 4) subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("On error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }
}
