package com.jimesh.orderservice.temporal.workflow;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface OrderProcessingActivities {
    void reserveItemsAtRestaurant(String orderId);
    void processPayment(String orderId);
    void notifyDelivery(String orderId);
    void markOrderComplete(String orderId);
}