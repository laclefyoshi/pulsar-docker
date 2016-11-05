/**
 * Pulsar.Producer
 *
 */
package org.saekiyoshiyasu;

import com.yahoo.pulsar.client.api.PulsarClient;
import com.yahoo.pulsar.client.api.Producer;
import com.yahoo.pulsar.client.api.PulsarClientException;

/**
 * @author laclefyoshi
 */
public class PulsarProducer {
    public static void main(String[] args) throws PulsarClientException {
        if (args.length < 1) {
            System.err.println("usage: java app.jar PulsarProducer BROKER_URL");
            System.exit(1);
        }
        String brokerUrl = args[0];
        PulsarClient client = PulsarClient.create(brokerUrl);
        Producer producer =
            client.createProducer("persistent://sample/standalone/ns1/my-topic");
        for (int i = 0; i < 10; i++) {
            producer.send(("Hello " + Integer.toString(i)).getBytes());
        }
        client.close();
    }
}

