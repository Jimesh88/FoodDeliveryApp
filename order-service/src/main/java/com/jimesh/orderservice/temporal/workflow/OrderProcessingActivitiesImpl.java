package com.jimesh.orderservice.temporal.workflow;

import com.jimesh.orderservice.temporal.TaskQueueDefinitions;
import io.temporal.spring.boot.ActivityImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ActivityImpl(taskQueues = TaskQueueDefinitions.ORDER_PROCESSING_TASK_QUEUE)
public class OrderProcessingActivitiesImpl implements OrderProcessingActivities {

    @Override
    public void reserveItemsAtRestaurant(String orderId) {
        System.out.println("Reserving items for order {}"+ orderId);
        // Call restaurant-service API here
    }

    @Override
    public void processPayment(String orderId) {
        System.out.println("Processing payment for order {}"+ orderId);
        // Call payment gateway here
    }

    @Override
    public void notifyDelivery(String orderId) {
        System.out.println("Notifying delivery service for order {}"+ orderId);
        // Call delivery-service API here
    }

    @Override
    public void markOrderComplete(String orderId) {
        System.out.println("Order {} marked as complete."+orderId);
        // Update DB status to COMPLETE
    }
}