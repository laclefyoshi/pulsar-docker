/**
 * Pulsar.Consumer
 *
 */
package org.saekiyoshiyasu;

import com.yahoo.pulsar.client.api.PulsarClient;
import com.yahoo.pulsar.client.api.Consumer;
import com.yahoo.pulsar.client.api.Message;
import com.yahoo.pulsar.client.api.PulsarClientException;

/**
 * @author laclefyoshi
 */
public class PulsarConsumer {
    public static void main(String[] args) throws PulsarClientException {
        if (args.length < 1) {
            System.err.println("usage: java app.jar PulsarConsumer BROKER_URL");
            System.exit(1);
        }
        String brokerUrl = args[0];
        PulsarClient client = PulsarClient.create(brokerUrl);
        Consumer consumer =
            client.subscribe("persistent://sample/standalone/ns1/my-topic",
                             "subscriber-00");
        while (true) {
            Message msg = consumer.receive();
            String str = new String(msg.getData());
            System.out.println("Received message: " + str);
            consumer.acknowledge(msg);
            if ("quit".equals(str)) {
                break;
            }
        }
        client.close();
    }
}

