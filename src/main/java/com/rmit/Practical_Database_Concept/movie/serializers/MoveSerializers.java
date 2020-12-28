//package com.rmit.Practical_Database_Concept.movie.serializers;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//import com.rmit.Practical_Database_Concept.movie.model.Movie;
//
//import java.io.IOException;
//
//public class MoveSerializers extends StdDeserializer<Movie> {
//    public MoveSerializers() {
//        this(null);
//    }
//
//    public MoveSerializers(Class<?> vc) {
//        super(vc);
//    }
//
//    @Override
//    public Movie deserialize(JsonParser jp, DeserializationContext ctxt)
//            throws IOException, JsonProcessingException {
//
//        JsonNode movieNode = jp.getCodec().readTree(jp);
//        Movie movie = new Movie();
//        movie.setId(movieNode.get("id").intValue());
//
//        movie.setDescription(movieNode.get("description").textValue());
//
//
//        product.setName(productNode.get("name").textValue());
//        product.setBrandName(productNode.get("brand")
//                .get("name").textValue());
//        product.setOwnerName(productNode.get("brand").get("owner")
//                .get("name").textValue());
//        return product;
//    }
//}
