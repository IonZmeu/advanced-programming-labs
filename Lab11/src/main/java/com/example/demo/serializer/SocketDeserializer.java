package com.example.demo.serializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketDeserializer extends JsonDeserializer<Socket> {
    @Override
    public Socket deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String address = node.get("address").asText();
        int port = node.get("port").asInt();
        int localPort = node.get("localPort").asInt();

        InetAddress inetAddress = InetAddress.getByName(address);
        Socket socket = new Socket(inetAddress, port, inetAddress, localPort);

        String outputStr = node.get("outputStream").asText();
        String inputStr = node.get("inputStream").asText();


        socket.setOutputStream(getOutputStreamFromString(outputStr));
        socket.setInputStream(getInputStreamFromString(inputStr));

        return socket;
    }

    private OutputStream getOutputStreamFromString(String str) {
        // Create your custom logic to convert the string representation to an OutputStream
        // Here's an example that returns null
        return null;
    }

    private InputStream getInputStreamFromString(String str) {
        // Create your custom logic to convert the string representation to an InputStream
        // Here's an example that returns null
        return null;
    }
}
