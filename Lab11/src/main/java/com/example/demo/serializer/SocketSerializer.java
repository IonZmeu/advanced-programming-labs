package com.example.demo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.net.Socket;

public class SocketSerializer extends JsonSerializer<Socket> {
    @Override
    public void serialize(Socket socket, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("address", socket.getInetAddress().getHostAddress());
        jsonGenerator.writeNumberField("port", socket.getPort());
        jsonGenerator.writeNumberField("localPort", socket.getLocalPort());

        jsonGenerator.writeFieldName("outputStream");
        jsonGenerator.writeString(socket.getOutputStream().toString());

        jsonGenerator.writeFieldName("inputStream");
        jsonGenerator.writeString(socket.getInputStream().toString());

        jsonGenerator.writeEndObject();
    }

}