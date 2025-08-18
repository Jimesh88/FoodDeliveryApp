package com.jimesh.orderservice;

import com.jimesh.orderservice.temporal.workflow.OrderProcessingActivitiesImpl;
import com.jimesh.orderservice.temporal.workflow.OrderProcessingWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);

        // 1. Create client
        WorkflowClient client = WorkflowClient.newInstance(
                WorkflowServiceStubs.newLocalServiceStubs()
        );

        // 2. Create worker factory
        WorkerFactory factory = WorkerFactory.newInstance(client);

        // 3. Create worker bound to the same task queue
        Worker worker = factory.newWorker("ORDER_PROCESSING_TASK_QUEUE");

        // 4. Register workflow + activities
        worker.registerWorkflowImplementationTypes(OrderProcessingWorkflowImpl.class);
        worker.registerActivitiesImplementations(new OrderProcessingActivitiesImpl());

        // 5. Start polling
        factory.start();
    }
}
