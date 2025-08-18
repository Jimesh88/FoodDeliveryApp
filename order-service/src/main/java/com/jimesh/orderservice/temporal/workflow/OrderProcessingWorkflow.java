package com.jimesh.orderservice.temporal.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderProcessingWorkflow {
    @WorkflowMethod
    void processOrder(String orderId);
}