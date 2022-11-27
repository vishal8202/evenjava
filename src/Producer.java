import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Random;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        KafkaProducer producer;
        String broker ="localhost:9092";
        String topic ="Even";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,broker);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        producer = new KafkaProducer(props);
        Random rand = new Random();
        while(true){
            try {
                int dataToSend = rand.nextInt(0, 1000);
                String val = String.valueOf(dataToSend);
                producer.send(new ProducerRecord(topic, val));
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);

            }
        }
    }
}