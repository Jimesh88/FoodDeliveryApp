package com.jimesh.orderservice.temporal.workflow;

import com.jimesh.orderservice.temporal.TaskQueueDefinitions;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
@WorkflowImpl(taskQueues = TaskQueueDefinitions.ORDER_PROCESSING_TASK_QUEUE)
public class OrderProcessingWorkflowImpl implements OrderProcessingWorkflow{

    private final OrderProcessingActivities activities;

    public OrderProcessingWorkflowImpl(){
        this.activities = Workflow.newActivityStub(OrderProcessingActivities.class, ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofMinutes(2))
                .setRetryOptions(RetryOptions.newBuilder()
                        .setMaximumAttempts(3)
                        .build())
                .build());
    }
    @Override
    public void processOrder(String orderId) {
        log.info("Starting order workflow for {}", orderId);

        activities.reserveItemsAtRestaurant(orderId);
        activities.processPayment(orderId);
        activities.notifyDelivery(orderId);
        activities.markOrderComplete(orderId);

        log.info("Completed order workflow for {}", orderId);
    }
}
